import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";

@Injectable({ providedIn: "root" })
export class HttpService {
  constructor(private http: HttpClient) { }

  public makePostRequest(url: string, data: {}, inHeader: boolean): Observable<any> {
    const body = inHeader ? null : data;
    const headers = { params: inHeader ? data : null };
    return this.http.post(url, body, headers).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    window.alert(JSON.stringify(error));
    return throwError(error);
  }

}
