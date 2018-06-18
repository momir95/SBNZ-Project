import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {FormsModule} from '@angular/forms';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { NavbarComponent } from './components/navbar/navbar.component';
import { AppComponent }  from './app.component';
import {HomeComponent} from "./components/home/home.component";
import { AddUserComponent } from "./components/addUser/addUser.component";


import { AuthenticationService } from "./services/authentication.service";

import { routing } from "./app.routes";
import {FindMedicalRecordComponent} from "./components/doctor/findMedicalRecord/findMedicalRecord.component";
import {ShowMedicalRecordComponent} from "./components/doctor/showMedicalRecord/showMedicalRecord.component";
import {CreateMedicalRecordComponent} from "./components/doctor/createMedicalRecord/createMedicalRecord.component";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {AddCureComponent} from "./components/admin/addCure/addCure.component";
import {AddIngredientComponent} from "./components/admin/addIngredient/addIngredient.component";
import {AddDiseaseComponent} from "./components/admin/addDisease/addDisease.component";





@NgModule({
  imports:      [
    BrowserModule,
    routing,
    HttpModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    NgMultiSelectDropDownModule.forRoot()

  ],
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AddUserComponent,
    FindMedicalRecordComponent,
    ShowMedicalRecordComponent,
    CreateMedicalRecordComponent,
    AddCureComponent,
    AddIngredientComponent,
    AddDiseaseComponent

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthenticationService
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
