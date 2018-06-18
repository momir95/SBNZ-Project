import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {Ingredient, Cure} from "../../../models";
import {Router} from "@angular/router";
import {IngredientService} from "../../../services/ingredient.service";
import {CureService} from "../../../services/cure.service";

@Component({
  moduleId: module.id,
  selector: 'admin',
  templateUrl: './addCure.component.html',
  styleUrls: ['./addCure.component.css'],
  providers: [IngredientService, CureService]

})
export class AddCureComponent implements OnInit
{
  private name: string;
  private ingredients: Ingredient[];
  private selectedIngridients: Ingredient[] = [];
  private cure: Cure;


  items = [];
  selectedItems = [];
  dropdownSettings = {};


  constructor(private cureService: CureService, private ingredientService: IngredientService, private _router: Router)
  {
    this.name = "";
  }

  ngOnInit()
  {
    this.ingredientService.getAll().subscribe(
      (data: Ingredient[])  => this.ingredients = data,
      error => alert(error),
      () => {

        for(let ingridient of this.ingredients)
        {
          var item = {item_id: ingridient.id , item_text: ingridient.name}
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
      let ingridient: Ingredient = this.find(selectedItem.item_id);
      if(ingridient != null)
      {
        this.selectedIngridients.push(ingridient);
      }
    }

    let cure: Cure = new Cure(null, this.name, this.selectedIngridients);

    this.cureService.save(cure).subscribe(
      (data: Cure)  => this.cure = data,
      error => alert(error),
      () => {
        //this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);

        alert("Successifull added cure!");
      }
    );

  }

  find(id: number)
  {
    for(let ingridient of this.ingredients)
    {
      if(ingridient.id == id)
        return ingridient;
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
