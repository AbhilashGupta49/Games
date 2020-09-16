import { Component, Input, Output, ElementRef, ViewChild } from "@angular/core";
import { EventEmitter } from "@angular/core";
import { ScrollPanel } from "primeng/scrollpanel";

@Component({
  selector: "app-messages",
  templateUrl: "./messages.component.html",
  styleUrls: ["./messages.component.css"]
})
export class MessagesComponent {

  @Output() myMessages: EventEmitter<any> = new EventEmitter<any>();
  @Input() allMessages;

  myText = "";

  constructor() { }

  addToMyMessages() {
    this.myMessages.emit(this.myText);
    this.myText = "";
  }
}
