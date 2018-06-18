import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {MedicalRecord, Cure} from "../../../models";
import {Router, ActivatedRoute} from "@angular/router";
import {CureService} from "../../../services/cure.service";

@Component({
  moduleId: module.id,
  selector: 'doctor',
  templateUrl: './showMedicalRecord.component.html',
  styleUrls: ['./showMedicalRecord.component.css'],
  providers: [MedicalRecordService, CureService]

})
export class ShowMedicalRecordComponent implements OnInit
{
  private medicalRecord: MedicalRecord;

  private cures: Cure[];
  items = [];
  selectedItems = [];
  dropdownSettings = {};
  selectedCures: Cure[] = [];





  constructor(private cureService: CureService, private medicalRecordService: MedicalRecordService, private _router: Router, private route: ActivatedRoute)
  {

  }


  ngOnInit()
  {
    this.medicalRecordService.getMedicalRecordByID(this.route.snapshot.params['p1']).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => alert("Error"),
      () => {
        this.complete();
      }
    );
  }

  complete()
  {
    this.cureService.getAll().subscribe(
      (data: Cure[])  => this.cures = data,
      error => alert(error),
      () => {

        for(let cure of this.cures)
        {
          if(this.find(cure.id)) {
            var item = {item_id: cure.id, item_text: cure.name}
            this.items.push(item);
          }
        }

        this.items = JSON.parse(JSON.stringify(this.items));
        console.log(this.items);


        this.dropdownSettings = {
          singleSelection: false,
          idField: 'item_id',
          textField: 'item_text',
          selectAllText: 'Select All',
          unSelectAllText: 'UnSelect All',
          itemsShowLimit: 2,
          allowSearchFilter: true
        };
      }
    );
  }

  find(id: number)
  {
    for(let cure of this.medicalRecord.cures)
    {
      if(cure.id == id)
        return false;
    }
    return true;
  }

  create()
  {
    for(let selectedItem of this.selectedItems)
    {
      let c: Cure = this.findCure(selectedItem.item_id);
      if(c != null)
      {
        this.selectedCures.push(c);
      }
    }


    this.medicalRecordService.updateCures(this.medicalRecord.id, this.selectedCures).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => alert(error),
      () => {
        this.items = [];
        this.selectedCures = [];
        for(let cure of this.cures) {
          if (this.find(cure.id)) {
            var item = {item_id: cure.id, item_text: cure.name}
            this.items.push(item);
          }
        }
        this.selectedItems = [];
      }
    );
  }

  findCure(id: number)
  {
    for(let cure of this.cures)
    {
      if(cure.id == id)
        return cure;
    }

    return null;
  }


}
