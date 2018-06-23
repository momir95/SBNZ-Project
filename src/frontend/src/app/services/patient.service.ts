import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {MedicalRecord, Patient} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class PatientService
{
  constructor(private http: HttpClient)
  {
  }


  save(patient: Patient)
  {
    let param = JSON.stringify(patient);

    return this.http.post(Consts.getHostname() + "/api/patient/save", param, httpOptions);
  }

  getFirst()
  {
    return this.http.get(Consts.getHostname() + "/api/patient/getPatientWithHronicalDisease", httpOptions);
  }

  getSecond()
  {
    return this.http.get(Consts.getHostname() + "/api/patient/getPatientWithAnalgeticCures", httpOptions);
  }

  getThird()
  {
    return this.http.get(Consts.getHostname() + "/api/patient/getPatientWithWeakImunitet", httpOptions);
  }

}


