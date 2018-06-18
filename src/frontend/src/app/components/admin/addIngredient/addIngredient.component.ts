import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {Ingredient, Cure} from "../../../models";
import {Router} from "@angular/router";
import {IngredientService} from "../../../services/ingredient.service";
import {CureService} from "../../../services/cure.service";

@Component({
  moduleId: module.id,
  selector: 'admin',
  templateUrl: './addIngredient.component.html',
  styleUrls: ['./addIngredient.component.css'],
  providers: [IngredientService, CureService]

})
export class AddIngredientComponent
{

  private ingredients: Ingredient[] = [];
  private name: string;



  constructor(private cureService: CureService, private ingredientService: IngredientService, private _router: Router)
  {
    this.name="";
  }

  create()
  {

    this.ingredientService.save(this.ingredients).subscribe(
      (data: Ingredient[])  => this.ingredients = data,
      error => alert(error),
      () => {
        //this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);

        alert("Successifull added ingredients!");
      }
    );

  }


  addIngredient()
  {
    this.ingredients.push(new Ingredient(null, this.name));
    this.name="";
  }

  delete(name: string)
  {
    let i : number = this.find(name);

    if(i != null)
      this.ingredients.splice(i, 1);
  }

  find(name: string)
  {
    let i = 0;
    for(let ingredient of this.ingredients)
    {
      if(name == ingredient.name)
        return i

      i += 1;
    }

    return null;

  }
}
