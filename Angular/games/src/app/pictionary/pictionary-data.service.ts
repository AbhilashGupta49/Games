import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class PictionaryDataService {
  constructor() { }

  public convertStrokesToRequestObject(name, strokes, msgs) {
    return { "names": [name], "strokes": strokes, "messages": msgs };
  }
}
