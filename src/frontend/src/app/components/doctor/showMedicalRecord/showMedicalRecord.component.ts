import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {MedicalRecord} from "../../../models";
import {Router, ActivatedRoute} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'doctor',
  templateUrl: './showMedicalRecord.component.html',
  styleUrls: ['./showMedicalRecord.component.css'],
  providers: [MedicalRecordService]

})
export class ShowMedicalRecordComponent implements OnInit
{
  private medicalRecord: MedicalRecord;

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};


  constructor(private medicalRecordService: MedicalRecordService, private _router: Router, private route: ActivatedRoute)
  {
    // this.medicalRecordService.getMedicalRecordByID(this.route.snapshot.params['p1']).subscribe(
    //   (data: MedicalRecord)  => this.medicalRecord = data,
    //   error => alert("Error"),
    //   () => {
    //
    //   }
    // );
  }

  ngOnInit(){
    this.dropdownList = [
      { item_id: 1, item_text: 'Mumbai' },
      { item_id: 2, item_text: 'Bangaluru' },
      { item_id: 3, item_text: 'Pune' },
      { item_id: 4, item_text: 'Navsari' },
      { item_id: 5, item_text: 'New Delhi' }
    ];
    this.selectedItems = [
      { item_id: 3, item_text: 'Pune' },
      { item_id: 4, item_text: 'Navsari' }
    ];
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
  onItemSelect(item:any){
    console.log(item);
  }
  onSelectAll(items: any){
    console.log(items);
  }






}
