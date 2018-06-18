import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import {SignUpRequest} from "../models";
import {Consts} from "../utils/const.utils";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class AdminService
{
  constructor(private http: HttpClient)
  {
  }

  save(signUp: SignUpRequest)
  {
    let param = JSON.stringify(signUp);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/auth/signup", param, httpOptions);
  }

}


