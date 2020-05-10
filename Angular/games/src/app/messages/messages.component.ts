import { Component, Input, Output, ElementRef, ViewChild } from "@angular/core";
import { EventEmitter } from "@angular/core";
import { ScrollPanel } from "primeng/scrollpanel";

@Component({
  selector: "app-messages",
  templateUrl: "./messages.component.html",
  styleUrls: ["./messages.component.css"]
})
export class MessagesComponent {

  @Output() private myMessages: EventEmitter<any> = new EventEmitter<any>();
  @Input() private allMessages;

  private myText = "";

  constructor() { }

  private addToMyMessages() {
    this.myMessages.emit(this.myText);
    this.myText = "";
  }
}
