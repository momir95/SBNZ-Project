import { Component } from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {MedicalRecord} from "../../../models";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'doctor',
  templateUrl: './findMedicalRecord.component.html',
  styleUrls: ['./findMedicalRecord.component.css'],
  providers: [MedicalRecordService]

})
export class FindMedicalRecordComponent
{
  private numberOfMR: string;
  private medicalRecord: MedicalRecord;


  constructor(private medicalRecordService: MedicalRecordService, private _router: Router)
  {
    this.numberOfMR = "";
  }

  findMR()
  {
    this.medicalRecordService.getMedicalRecord(this.numberOfMR).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => this.badInput(),
      () => {
        this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);
      }
    );

  }


  badInput()
  {
    document.getElementById("message").innerHTML = "<div class=\"alert alert-danger col-sm-offset-4 \"> Wrong LBO or medical record doesn't exist! </div>";
  }

}
