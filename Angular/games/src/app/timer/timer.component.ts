import { Component, OnInit, AfterViewInit, Input } from "@angular/core";

@Component({
  selector: "app-timer",
  templateUrl: "./timer.component.html",
  styleUrls: ["./timer.component.css"]
})
export class TimerComponent {

  @Input() private time: number;
  @Input() private label: string;

  constructor() { }

}
