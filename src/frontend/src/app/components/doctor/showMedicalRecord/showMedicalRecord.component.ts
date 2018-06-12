import { Component } from '@angular/core';
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
export class ShowMedicalRecordComponent
{
  private medicalRecord: MedicalRecord;


  constructor(private medicalRecordService: MedicalRecordService, private _router: Router, private route: ActivatedRoute)
  {
    this.medicalRecordService.getMedicalRecordByID(this.route.snapshot.params['p1']).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => alert("Error"),
      () => {

      }
    );
  }






}
