import { Component, ElementRef, ViewChild, AfterViewInit, OnDestroy } from "@angular/core";
import { fromEvent, Subscription, timer } from "rxjs";
import { switchMap, takeUntil, pairwise, concatMap } from "rxjs/operators";
import { HttpService } from "../services/http.service";
import { Constants } from "../configs/constants-list";
import { PictionaryDataService } from "./pictionary-data.service";
import { GlobalVariables as gv } from "../global-variables";
import { MessageService } from "primeng/components/common/messageservice";

@Component({
  selector: "app-pictionary",
  templateUrl: "./pictionary.component.html",
  styleUrls: ["./pictionary.component.css"]
})
export class PictionaryComponent implements AfterViewInit, OnDestroy {

  @ViewChild("canvas") public canvas: ElementRef;
  canvasContext: CanvasRenderingContext2D;
  width = 400;
  height = 400;
  strokeArray = [];

  myMessages = [];
  allMessages = [];
  winCondition;

  scoreCard;

  currentWord;

  myChance = false;
  currentChance = "";

  time = 0;

  subscription: Subscription = new Subscription();

  constructor(
    private pictionaryDataService: PictionaryDataService,
    private httpService: HttpService,
    private messageService: MessageService) {
  }

  public ngAfterViewInit() {
    const canvasElement: HTMLCanvasElement = this.canvas.nativeElement;
    this.canvasContext = canvasElement.getContext("2d");
    canvasElement.width = this.width;
    canvasElement.height = this.height;
    this.canvasContext.lineWidth = 3;
    this.canvasContext.strokeStyle = "#000000";
    this.canvasContext.lineCap = "round";
    this.captureEvents(canvasElement);
    this.subscription.add(this.exchangeData());
  }

  public ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  private exchangeData() {
    return timer(0, 1000).pipe(concatMap(value =>
      this.httpService.makePostRequest(
        gv.basePath + gv.gameName + Constants.HTTP_EXCHANGE_DATA,
        this.pictionaryDataService.convertStrokesToRequestObject(gv.myName,
          this.myChance ? this.strokeArray : [], this.myChance ? [] : this.myMessages
        ),
        false
      ),
    )).subscribe(response => this.performTasks(response));
  }

  private performTasks(response) {
    this.myMessages = [];
    this.mapResponse(response);
  }

  private mapResponse(response) {
    if (response) {
      if (response.messages) {
        this.allMessages = response.messages;
      }
      if (response.names) {
        this.currentChance = response.names[0];
        this.myChance = response.names[0] === gv.myName;
      }
      if (response.strokes !== null) {
        if (!this.myChance) {
          if (response.strokes.length === 0) {
            this.cleanCanvas();
          } else {
            this.jsonToStrokes(response.strokes);
          }
        }
      }
      this.currentWord = response.currentWord;
      this.winCondition = response.winCondition;
      this.scoreCard = response.scoreCard;
      this.time = response.time;
    }
  }

  private captureEvents(canvasElement: HTMLCanvasElement) {
    fromEvent(canvasElement, "mousedown")
      .pipe(
        switchMap((e) => {
          return fromEvent(canvasElement, "mousemove")
            .pipe(
              takeUntil(fromEvent(canvasElement, "mouseup")),
              takeUntil(fromEvent(canvasElement, "mouseleave")),
              pairwise()
            );
        })
      )
      .subscribe((coordinates: [MouseEvent, MouseEvent]) => {
        if (this.myChance) {
          const rect = canvasElement.getBoundingClientRect();
          const prevPos = {
            x: coordinates[0].clientX - rect.left,
            y: coordinates[0].clientY - rect.top
          };
          const currentPos = {
            x: coordinates[1].clientX - rect.left,
            y: coordinates[1].clientY - rect.top
          };
          this.drawOnCanvas(prevPos, currentPos);
        }
      });
  }

  public cleanCanvas() {
    this.strokeArray = [];
    this.canvasContext.clearRect(0, 0, this.width, this.height);
  }

  private jsonToStrokes(strokes: any) {
    for (const stroke of strokes) {
      this.drawOnCanvas(stroke.prevPos, stroke.currentPos);
    }
  }


  private drawOnCanvas(prevPos: { x: number, y: number }, currentPos: { x: number, y: number }) {
    if (!this.canvasContext) { return; }
    this.canvasContext.beginPath();
    if (prevPos) {
      this.canvasContext.moveTo(prevPos.x, prevPos.y);
      this.canvasContext.lineTo(currentPos.x, currentPos.y);
      this.canvasContext.stroke();
      this.strokeArray.push({ prevPos, currentPos });
    }
  }

}
