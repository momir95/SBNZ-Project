import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {Ingredient, Symptom, Disease} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class DiseaseService
{
  constructor(private http: HttpClient)
  {
  }

  getAll()
  {
    return this.http.get(Consts.getHostname() + "/api/disease/getAll", httpOptions);
  }

  save(disease: Disease)
  {
    let param = JSON.stringify(disease);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/disease/save", param, httpOptions);
  }


}


