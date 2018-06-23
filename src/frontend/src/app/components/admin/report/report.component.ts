import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {Patient} from "../../../models";
import {PatientService} from "../../../services/patient.service";

@Component({
  moduleId: module.id,
  selector: 'home',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
  providers: [PatientService]
})
export class ReportComponent
{
  private patients: Patient[];
  private tableVisible: boolean;
  private first: boolean;
  private second: boolean;
  private third: boolean;

  constructor(private patientService: PatientService)
  {
    this.tableVisible = false;
    this.first = false;
    this.second = false;
    this.third = false;

  }

  firstF()
  {
    this.first = true;
    this.second = false;
    this.third = false;
  }
  secondF()
  {
    this.first = false;
    this.second = true;
    this.third = false;
  }
  thirdF()
  {
    this.first = false;
    this.second = false;
    this.third = true;
  }

  report()
  {
    if(this.first)
    {
      this.patientService.getFirst().subscribe(
        (data: Patient[])  => this.patients = data,
        error => alert(error),
        () => {
          this.tableVisible = true;

        }
      );
    }
    else if(this.second)
    {
      this.patientService.getSecond().subscribe(
        (data: Patient[])  => this.patients = data,
        error => alert(error),
        () => {
          this.tableVisible = true;

        }
      );
    }
    else if(this.third)
    {
      this.patientService.getThird().subscribe(
        (data: Patient[])  => this.patients = data,
        error => alert(error),
        () => {
          this.tableVisible = true;

        }
      );
    }
  }

}
