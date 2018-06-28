import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {SymptomService} from "../../../services/symptom.service";
import {Symptom} from "../../../models";

@Component({
  moduleId: module.id,
  selector: 'home',
  templateUrl: './addSymptom.component.html',
  styleUrls: ['./addSymptom.component.css'],
  providers: [SymptomService]
})
export class AddSymptomComponent
{
  private name: string;
  private type: string;
  items = [];
  selectedItem;
  dropdownSettings = {};

  symptom: Symptom;

  constructor(private symptomService: SymptomService)
  {
    this.name = "";


    var item1 = {item_id: 1 , item_text: 'SPECIFIC'}
    var item2 = {item_id: 2 , item_text: 'GENERAL'}

    this.items.push(item1);
    this.items.push(item2);



    this.items = JSON.parse(JSON.stringify(this.items))

    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      allowSearchFilter: true
    };
  }


  add()
  {
    this.symptom = new Symptom(null, this.name, this.type);
    this.symptomService.saveSymptom(this.symptom).subscribe(
      (data: Symptom)  => this.symptom = data,
      error => alert(error),
      () => {
        //this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);

        alert("Successifull added symptom!");
      }
    );
  }

  onItemSelect(item:any){

    if(item.item_id == 1)
      this.type = 'SPECIFIC';
    else
      this.type = 'GENERAL';
  }
  onItemDeselect(items: any) {
  }

}
