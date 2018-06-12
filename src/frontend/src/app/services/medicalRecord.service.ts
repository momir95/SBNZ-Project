import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
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

}

