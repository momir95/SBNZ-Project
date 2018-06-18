import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {MedicalRecord, Cure, Patient} from "../../../models";
import {Router, ActivatedRoute} from "@angular/router";
import {CureService} from "../../../services/cure.service";
import {PatientService} from "../../../services/patient.service";

declare var $: any;


@Component({
  moduleId: module.id,
  selector: 'doctor',
  templateUrl: './createMedicalRecord.component.html',
  styleUrls: ['./createMedicalRecord.component.css'],
  providers: [CureService, MedicalRecordService, PatientService]

})
export class CreateMedicalRecordComponent implements OnInit
{
  private cures: Cure[];
  items = [];
  selectedItems = [];
  dropdownSettings = {};

  private firstname: string;
  private lastname: string;
  private lbo: string;

  patient: Patient;
  medicalRecord: MedicalRecord;
  selectedCures: Cure[] = [];



  constructor(private cureService: CureService, private medicalRecordService: MedicalRecordService, private patientService: PatientService, private _router: Router, private route: ActivatedRoute)
  {
    this.firstname = "";
    this.lastname = "";
    this.lbo = "";

  }

  ngOnInit()
  {
    this.cureService.getAll().subscribe(
      (data: Cure[])  => this.cures = data,
      error => alert(error),
      () => {

        for(let cure of this.cures)
        {
          var item = {item_id: cure.id , item_text: cure.name}
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


  onItemSelect(item:any){
    console.log(item);
  }
  onSelectAll(items: any){
    console.log(items);
  }

  create()
  {
    for(let selectedItem of this.selectedItems)
    {
      let c: Cure = this.find(selectedItem.item_id);
      if(c != null)
      {
        this.selectedCures.push(c);
      }
    }

    this.patientService.save(new Patient(null, this.firstname, this.lastname)).subscribe(
      (data: Patient)  => this.patient = data,
      error => alert(error),
      () => {

        this.medicalRecord = new MedicalRecord(null, this.lbo,null, this.patient, this.selectedCures);
        this.medicalRecordService.save(this.medicalRecord).subscribe(
          (data: MedicalRecord)  => this.medicalRecord = data,
          error => alert(error),
          () => {
            this._router.navigate(['/showMedicalRecord/' + this.medicalRecord.id]);
          }
        );
      }
    );


  }

  find(id: number)
  {
    for(let cure of this.cures)
    {
      if(cure.id == id)
        return cure;
    }

    return null;
  }




}
