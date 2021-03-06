import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {Cure} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class CureService
{
  constructor(private http: HttpClient)
  {
  }

  getAll()
  {
    return this.http.get(Consts.getHostname() + "/api/cure/getAll", httpOptions);
  }

  save(cure: Cure)
  {
    let param = JSON.stringify(cure);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/cure/save", param, httpOptions);
  }


}


