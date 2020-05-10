import { Component, OnInit, AfterViewInit, Input } from "@angular/core";
import { MessageService } from "primeng/components/common/messageservice";

@Component({
  selector: "app-win-condition",
  templateUrl: "./win-condition.component.html",
  styleUrls: ["./win-condition.component.css"]
})
export class WinConditionComponent implements AfterViewInit {

  @Input() private winCondition;

  private winConditionMessages = [];

  constructor(private messageService: MessageService) { }

  ngAfterViewInit() {
    if (this.winCondition && this.winConditionMessages.length === 0) {
      if (this.winCondition.winMessage) {
        this.winConditionMessages.push({ severity: "success", summary: "Winner!", detail: this.winCondition.winMessage, life: 30000 });
      }
      if (this.winCondition.winners) {
        for (const winner of this.winCondition.winners) {
          this.winConditionMessages.push({
            severity: "info", summary: winner.name + " " + winner.message,
            detail: "Gets " + winner.points + " points", life: 30000
          });
        }
      }
      if (this.winConditionMessages.length > 0) {
        this.messageService.addAll(this.winConditionMessages);
      }
    }
    if (!this.winCondition) {
      this.winConditionMessages = [];
      this.messageService.clear();
    }
  }

}
