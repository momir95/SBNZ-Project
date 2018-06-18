import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {Ingredient, Symptom} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class SymptomService
{
  constructor(private http: HttpClient)
  {
  }

  getAll()
  {
    return this.http.get(Consts.getHostname() + "/api/symptom/getAll", httpOptions);
  }

  save(symptoms: Symptom[])
  {
    let param = JSON.stringify(symptoms);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/symptom/save", param, httpOptions);
  }


}


