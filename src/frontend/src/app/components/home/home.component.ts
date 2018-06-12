import { Component } from '@angular/core';
import { AuthenticationService } from "../../services/authentication.service";
import {LoggedUtils} from "../../utils/logged.utils";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent
{
  private username: string;
  private password: string;

  constructor(private authenticationService: AuthenticationService)
  {
    this.username = "";
    this.password = "";
  }

  authenticate()
  {
    this.authenticationService.authenticateUser(this.username, this.password).subscribe(
      data => localStorage.setItem("loggedUser", JSON.stringify(data)),
      error => this.badInput(),
      () => {
        this.callEmitter();
        console.log('Logged user: ' + JSON.stringify(LoggedUtils.getUser()));
      }
    );

  }

  callEmitter()
  {
    this.authenticationService.emitRole(this.username);
  }

  badInput()
  {
    document.getElementById("login").innerHTML = "<div class=\"alert alert-danger col-sm-offset-4 \"> Wrong username or password! </div>";
  }

}
