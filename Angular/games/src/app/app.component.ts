import { Component } from "@angular/core";
import { GlobalVariables } from "./global-variables";
import { NavigationEnd, Router } from "@angular/router";
import { Constants } from "./configs/constants-list";
import { ConfigsList } from "./configs/config-list";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "app";

  constructor(private router: Router) {
    router.resetConfig(ConfigsList.getRoutes());
    let origin = window.location.origin;
    if (!window.location.origin) {
      origin = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ":" + window.location.port : "");
    }
    GlobalVariables.basePath = origin.substring(0, origin.indexOf(":", 5)) + ":8080/";
    router.events.subscribe((val: NavigationEnd) => {
      if (val instanceof NavigationEnd) {
        GlobalVariables.gameName = val.url.substring(1);
      }
    });
    const name = localStorage.getItem(Constants.GAME_NAME_STORAGE);
    if (name) {
      GlobalVariables.myName = name;
    }
  }

}
