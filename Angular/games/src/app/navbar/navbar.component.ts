import { Component, OnInit } from "@angular/core";
import { ConfigsList } from "../configs/config-list";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"]
})
export class NavbarComponent implements OnInit {
  gameList = [];

  constructor() {
    this.gameList = ConfigsList.getActualGameList();
  }

  ngOnInit() {
  }

}
