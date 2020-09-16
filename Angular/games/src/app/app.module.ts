import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { BrowserModule } from "@angular/platform-browser";
import { CommonModule } from "@angular/common";
import { AppComponent } from "./app.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { PictionaryComponent } from "./pictionary/pictionary.component";
import { ConfigsList } from "./configs/config-list";
import { HttpClientModule } from "@angular/common/http";
import { HomeComponent } from "./home/home.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { ButtonModule, Button } from "primeng/button";
import { InputTextModule, InputText } from "primeng/inputtext";
import { FormsModule } from "@angular/forms";
import { MessagesComponent } from "./messages/messages.component";
import { ScrollPanelModule } from "primeng/scrollpanel";
import { ToastModule } from "primeng/toast";
import { ScorecardComponent } from "./scorecard/scorecard.component";
import { ToolbarModule } from "primeng/toolbar";
import { MessageService } from "primeng/components/common/messageservice";
import { WinConditionComponent } from "./win-condition/win-condition.component";
import { CardModule } from "primeng/card";
import { TimerComponent } from './timer/timer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PictionaryComponent,
    HomeComponent,
    MessagesComponent,
    ScorecardComponent,
    WinConditionComponent,
    TimerComponent
  ],
  imports: [BrowserAnimationsModule, BrowserModule, ButtonModule, CardModule, CommonModule, FormsModule,
    HttpClientModule, InputTextModule, RouterModule.forRoot([]),
    ScrollPanelModule, ToastModule, ToolbarModule],
  providers: [Button, InputText, MessageService],
  bootstrap: [AppComponent],
  entryComponents: [
    HomeComponent, PictionaryComponent
 ]
})
export class AppModule {
}
