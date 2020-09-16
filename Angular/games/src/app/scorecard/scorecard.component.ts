import { Component, Input, AfterViewInit } from "@angular/core";
import { KeyValue } from "@angular/common";

@Component({
  selector: "app-scorecard",
  templateUrl: "./scorecard.component.html",
  styleUrls: ["./scorecard.component.css"]
})
export class ScorecardComponent implements AfterViewInit {

  @Input() scoreCard;

  valueDescOrder = (a: KeyValue<string, number>, b: KeyValue<string, number>) => {
    return a.value > b.value ? -1 : (b.value > a.value ? 1 : 0);
  }

  constructor() { }

  ngAfterViewInit() {

  }

}
