import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {Ingredient, Cure, Symptom, Disease} from "../../../models";
import {Router} from "@angular/router";
import {IngredientService} from "../../../services/ingredient.service";
import {CureService} from "../../../services/cure.service";
import {SymptomService} from "../../../services/symptom.service";
import {DiseaseService} from "../../../services/disease.service";

@Component({
  moduleId: module.id,
  selector: 'admin',
  templateUrl: './addDisease.component.html',
  styleUrls: ['./addDisease.component.css'],
  providers: [SymptomService, DiseaseService]

})
export class AddDiseaseComponent implements OnInit
{
  private name: string;
  private symptoms: Symptom[];
  private selectedSymptoms: Symptom[] = [];
  private disease: Disease;


  items = [];
  selectedItems = [];
  dropdownSettings = {};


  constructor(private symptomService: SymptomService, private diseaseService: DiseaseService, private _router: Router)
  {
    this.name = "";
  }

  ngOnInit()
  {
    this.symptomService.getAll().subscribe(
      (data: Symptom[])  => this.symptoms = data,
      error => alert(error),
      () => {

        for(let symptom of this.symptoms)
        {
          var item = {item_id: symptom.id , item_text: symptom.name}
          this.items.push(item);
        }

        this.items = JSON.parse(JSON.stringify(this.items));
        console.log(this.items);


        this.dropdownSettings = {
          singleSelection: false,
          idField: 'item_id',
          textField: 'item_text',
          selectAllText: 'Select All',
          unSelectAllText: 'UnSelect All',
          itemsShowLimit: 3,
          allowSearchFilter: true
        };
      }
    );
  }

  create()
  {
    for(let selectedItem of this.selectedItems)
    {
      let symptom: Symptom = this.find(selectedItem.item_id);
      if(symptom != null)
      {
        this.selectedSymptoms.push(symptom);
      }
    }

    let disease: Disease = new Disease(null, this.name, "FIRST", this.selectedSymptoms);

    this.diseaseService.save(disease).subscribe(
      (data: Disease)  => this.disease = data,
      error => alert(error),
      () => {
        //this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);

        alert("Successifull added disease!");
      }
    );

  }

  find(id: number)
  {
    for(let symptom of this.symptoms)
    {
      if(symptom.id == id)
        return symptom;
    }

    return null;
  }


  onItemSelect(item:any){
    console.log(item);
  }
  onSelectAll(items: any){
    console.log(items);
  }


}
