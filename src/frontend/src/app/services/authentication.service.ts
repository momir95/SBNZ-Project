import { Injectable, EventEmitter, Output } from '@angular/core';
import {Http, Headers} from '@angular/http';
import 'rxjs/add/operator/map';

import {LoggedUtils} from "../utils/logged.utils";
import {Consts} from "../utils/const.utils";
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthenticationService
{
  //@Output() getLoggedInName: EventEmitter<string> = new EventEmitter();
  //@Output() getLoggedInName = new EventEmitter<string>();
  public OnChangeRole = new Subject<string>();

  constructor(private http: Http) {}

  authenticateUser(username: string, pass: string)
  {
    let authenticationRequest = {username: username, password: pass};
    let param = JSON.stringify(authenticationRequest);
    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    return this.http.post(Consts.getHostname() + "/api/auth/signin", param, { headers : headers })
      .map(res => res.json());
  }

  emitRole(urs:string)
  {
    if(urs!="")
    {
      console.log('Rola: ' + LoggedUtils.getRole());
      this.OnChangeRole.next(LoggedUtils.getRole());
    }
  }

  getRoleEmitter(): Observable<any> {
    return this.OnChangeRole.asObservable();
  }

}
