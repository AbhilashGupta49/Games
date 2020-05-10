import { Injectable } from "@angular/core";
import { CanActivate, Router } from "@angular/router";
import { GlobalVariables } from "../global-variables";
import { Constants } from "../configs/constants-list";

@Injectable({ providedIn: "root" })
export class NameAuthGuard implements CanActivate {
  constructor(private router: Router) { }

  canActivate() {

    if (GlobalVariables.myName) {
      return true;
    } else {
      const name = localStorage.getItem(Constants.GAME_NAME_STORAGE);
      if (name) {
        GlobalVariables.myName = name;
        return true;
      } else {
        window.alert("Enter name first");
        this.router.navigate(["/home"]);
      }
    }
  }

}
