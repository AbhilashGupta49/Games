import { Component, OnInit, ViewChild, AfterViewInit } from "@angular/core";
import { HttpService } from "../services/http.service";
import { Constants } from "../configs/constants-list";
import { HomeDataService } from "./home-data.service";
import { GlobalVariables } from "../global-variables";
import { Router } from "@angular/router";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements AfterViewInit {

  name = "";

  constructor(private router: Router, private httpService: HttpService, private homeDataService: HomeDataService) {

  }
  ngAfterViewInit() {
    let localName = localStorage.getItem(Constants.GAME_NAME_STORAGE);
    if (!localName) {
      localName = GlobalVariables.myName;
    }
    if (localName) {
      this.navigateToNext(localName);
    }
  }

  addPlayer() {
    const name = this.name;
    this.httpService.makePostRequest(
      GlobalVariables.basePath + Constants.HTTP_ADD_PLAYER,
      this.homeDataService.preparePlayerAddData(name), true
    ).subscribe(response => {

      if (!response) {
        window.alert("Name already in use");
      } else {
        localStorage.setItem(Constants.GAME_NAME_STORAGE, name);
        GlobalVariables.myName = name;
        this.navigateToNext(name);
      }
    });
  }

  private navigateToNext(name: string) {
    this.router.navigate(["/pictionary"]);
    window.alert("Welcome " + name + "!");
  }

}
