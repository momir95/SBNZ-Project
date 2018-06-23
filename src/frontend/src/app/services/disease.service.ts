import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {Ingredient, Symptom, Disease, MedicalRecord} from "../models";

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

  determineDisease(mrId: number, symptoms: Symptom[])
  {
    let param = JSON.stringify(symptoms);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/disease/determineDisease/" + mrId, param, httpOptions);
  }

  getDiseases(symptoms: Symptom[])
  {
    let param = JSON.stringify(symptoms);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/disease/getDiseases", param, httpOptions);
  }

  getSymptoms(disease: Disease)
  {
    let param = JSON.stringify(disease);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/disease/getSymptoms", param, httpOptions);
  }



}


