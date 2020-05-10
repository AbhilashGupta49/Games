import { Injectable } from "@angular/core";

@Injectable({ providedIn: "root" })
export class HomeDataService {

  constructor() { }

  public preparePlayerAddData(name: string) {
    return { name };
  }
}
