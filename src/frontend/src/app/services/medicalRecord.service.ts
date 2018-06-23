import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {MedicalRecord, Cure, Review} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json', 'Access-Control-Allow-Origin': '*' })
};

@Injectable()
export class MedicalRecordService
{
  constructor(private http: HttpClient)
  {
  }

  getMedicalRecord(numberOfMR: string)
  {
    let registerRequest = {numberOfMR: numberOfMR};
    let param = JSON.stringify(registerRequest);
    return this.http.get(Consts.getHostname() + "/api/medicalRecord/getByNumber/" + numberOfMR, httpOptions);

  }

  getMedicalRecordByID(id: number)
  {
    return this.http.get(Consts.getHostname() + "/api/medicalRecord/getById/" + id, httpOptions);
  }

  save(medicalRecord: MedicalRecord)
  {
    let param = JSON.stringify(medicalRecord);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/medicalRecord/save", param, httpOptions);
  }

  updateCures(id:number, cures: Cure[])
  {
    let param = JSON.stringify(cures);
    console.log(param);

    return this.http.put(Consts.getHostname() + "/api/medicalRecord/updateCures/" + id, param, httpOptions);
  }

  validateCures(mrId: number, cures: Cure[])
  {
    let param = JSON.stringify(cures);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/medicalRecord/validateCures/" + mrId, param, httpOptions);
  }

  saveReview(id:number, review: Review)
  {
    let param = JSON.stringify(review);
    console.log(param);

    return this.http.put(Consts.getHostname() + "/api/medicalRecord/addReview/" + id, param, httpOptions);
  }

}


