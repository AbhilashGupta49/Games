import { PictionaryComponent } from "../pictionary/pictionary.component";
import { Routes } from "@angular/router";
import { HomeComponent } from "../home/home.component";
import { NameAuthGuard } from "../auth-guard/named-auth-guard.service";


export class ConfigsList {
  public static GAMES_LIST = [{
    name: "Home",
    icon: "fa fa-home",
    routerLink: "/home",
    path: "home",
    component: HomeComponent
  }, {
    name: "Pictionary",
    icon: "fa fa-photo",
    routerLink: "/pictionary",
    canActivate: [NameAuthGuard],
    path: "pictionary",
    component: PictionaryComponent
  }];

  public static getRoutes() {
    const routes: Routes = [...this.GAMES_LIST.map(function (route) {
      return { "path": route.path, "canActivate": route.canActivate, "component": route.component };
    })];
    routes.unshift({ path: "", redirectTo: this.GAMES_LIST[0].routerLink, pathMatch: "full" });
    return routes;
  }

  public static getActualGameList() {
    return [...ConfigsList.GAMES_LIST].splice(0);
  }
}
