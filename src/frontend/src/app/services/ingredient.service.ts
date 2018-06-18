import { Injectable } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import {Consts} from "../utils/const.utils";
import {Ingredient} from "../models";

const httpOptions = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable()
export class IngredientService
{
  constructor(private http: HttpClient)
  {
  }

  getAll()
  {
    return this.http.get(Consts.getHostname() + "/api/ingredient/getAll", httpOptions);
  }

  save(ingredients: Ingredient[])
  {
    let param = JSON.stringify(ingredients);
    console.log(param);

    return this.http.post(Consts.getHostname() + "/api/ingredient/save", param, httpOptions);
  }


}


