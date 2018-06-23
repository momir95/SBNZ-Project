import {Component, OnInit} from '@angular/core';
import {MedicalRecordService} from "../../../services/medicalRecord.service";
import {MedicalRecord, Cure, Symptom, Disease, ValidateCures, Review, User} from "../../../models";
import {Router, ActivatedRoute} from "@angular/router";
import {CureService} from "../../../services/cure.service";
import {SymptomService} from "../../../services/symptom.service";
import {DiseaseService} from "../../../services/disease.service";
import {LoggedUtils} from "../../../utils/logged.utils";

@Component({
  moduleId: module.id,
  selector: 'doctor',
  templateUrl: './showMedicalRecord.component.html',
  styleUrls: ['./showMedicalRecord.component.css'],
  providers: [MedicalRecordService, CureService, SymptomService, DiseaseService]

})
export class ShowMedicalRecordComponent implements OnInit
{
  private medicalRecord: MedicalRecord;

  private cures: Cure[];
  items = [];
  selectedItems = [];
  dropdownSettings = {};
  selectedCures: Cure[] = [];
  visible: boolean = false;

  items1 = [];
  selectedItems1 = [];
  selectedSymptoms: Symptom[] = [];
  dropdownSettings1 = {};
  symptoms: Symptom[];

  items2 = [];
  selectedItems2 = [];
  selectedCures1: Cure[] = [];

  selectedItems3 = [];


  disease: Disease;
  chooseSymptoms: Symptom[] = [];
  chooseCures: Cure[];
  validateCures: ValidateCures;
  diseases: Disease [];

  tableVisible: boolean = false;
  validateC: boolean = false;
  novalidateC: boolean = false;

  allDiseases: Disease[];
  items3 = [];
  selectedItem;
  selectedDisease: Disease;
  dropdownSettings2 = {};

  symptomsOfDisease: Symptom[];





  constructor(private symptomService: SymptomService, private diseaseService: DiseaseService, private cureService: CureService, private medicalRecordService: MedicalRecordService, private _router: Router, private route: ActivatedRoute)
  {

  }


  ngOnInit()
  {
    this.medicalRecordService.getMedicalRecordByID(this.route.snapshot.params['p1']).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => alert("Error"),
      () => {
        console.log(JSON.stringify(this.medicalRecord));
        this.complete();
      }
    );

    this.symptomService.getAll().subscribe(
      (data: Symptom[])  => this.symptoms = data,
      error => alert(error),
      () => {

        for(let symptom of this.symptoms)
        {
          var item = {item_id: symptom.id , item_text: symptom.name}
          this.items1.push(item);
        }

        this.items1 = JSON.parse(JSON.stringify(this.items1))

        this.dropdownSettings1 = {
          singleSelection: false,
          idField: 'item_id',
          textField: 'item_text',
          selectAllText: 'Select All',
          unSelectAllText: 'UnSelect All',
          itemsShowLimit: 5,
          allowSearchFilter: true
        };
      }
    );

    this.diseaseService.getAll().subscribe(
      (data: Disease[])  => this.allDiseases = data,
      error => alert(error),
      () => {

        for(let disease of this.allDiseases)
        {
          var item = {item_id: disease.id , item_text: disease.name}
          this.items3.push(item);
        }

        this.items3 = JSON.parse(JSON.stringify(this.items3))

        this.dropdownSettings2 = {
          singleSelection: true,
          idField: 'item_id',
          textField: 'item_text',
          itemsShowLimit: 5,
          allowSearchFilter: true
        };
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

        for(let cure of this.cures)
        {

          var item = {item_id: cure.id, item_text: cure.name}
          this.items2.push(item);

        }

        this.items2 = JSON.parse(JSON.stringify(this.items2));
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


  addReview()
  {
      this.visible = true;
      this.selectedItems3 = [];
      this.diseases = [];
      this.tableVisible = false;
      this.selectedItems1 = [];

    this.selectedItem = null;
    this.symptomsOfDisease = [];
    this.selectedItems2 = [];


  }

  determineDesease()
  {
    this.selectedSymptoms = [];
    for(let selectedItem of this.selectedItems1)
    {
      let s: Symptom = this.findSymptom(selectedItem.item_id);
      if(s != null)
      {
        this.selectedSymptoms.push(s);
      }
    }



    this.diseaseService.determineDisease(this.medicalRecord.id, this.selectedSymptoms).subscribe(
      (data: Disease[])  => this.diseases = data,
      error => alert(error),
      () => {
        alert(JSON.stringify(this.diseases));
        this.chooseSymptoms = this.selectedSymptoms;
        this.tableVisible = true;

      }
    );


  }

  findSymptom(id: number)
  {
    for(let symptom of this.symptoms)
    {
      if(symptom.id == id)
        return symptom;
    }

    return null;
  }

  validate()
  {
    this.novalidateC = false;
    this.validateC = false;
    this.selectedCures1 = [];
    for(let selectedItem of this.selectedItems2)
    {
      let c: Cure = this.findCure(selectedItem.item_id);
      if(c != null)
      {
        this.selectedCures1.push(c);
      }
    }

    this.chooseCures = this.selectedCures1;

    this.medicalRecordService.validateCures(this.medicalRecord.id, this.selectedCures1).subscribe(
      (data: ValidateCures)  => this.validateCures = data,
      error => alert(error),
      () => {
          if((this.validateCures.allergicIngredients.length == 0) && (this.validateCures.allergicCures.length == 0))
          {
            this.validateC = true;
          }
          else
          {
            this.novalidateC = true;
          }

      }
    );

  }

  getDiseases()
  {
    this.selectedSymptoms = [];
    for(let selectedItem of this.selectedItems3)
    {
      let s: Symptom = this.findSymptom(selectedItem.item_id);
      if(s != null)
      {
        this.selectedSymptoms.push(s);

      }
    }
    this.chooseSymptoms = this.selectedSymptoms;
    alert(JSON.stringify(this.chooseSymptoms));

    this.diseaseService.getDiseases(this.selectedSymptoms).subscribe(
      (data: Disease[])  => this.diseases = data,
      error => alert(error),
      () => {
        //alert(JSON.stringify(this.diseases));
        this.tableVisible = true;
      }
    );
  }

  drugi()
  {
    this.tableVisible = false;
    this.selectedItems3 = [];
    this.diseases = [];
    this.selectedItems2 = [];

  }

  prvi()
  {
    this.tableVisible = false;
    this.selectedItems1 = [];
    this.diseases = [];
    this.selectedItems2 = [];
  }

  treci()
  {
    this.tableVisible = false;
    this.selectedItem = null;
    this.symptomsOfDisease = [];
    this.selectedItems2 = [];

  }

  cetvrti()
  {
    this.tableVisible = false;
    this.selectedItem = null;
    this.selectedItems2 = [];

  }

  chooseDisease(disease: Disease)
  {
    this.disease = disease;
  }

  saveReview()
  {
    var user: User = new User(LoggedUtils.getId(), null, null, null, null);
    this.medicalRecordService.saveReview(this.medicalRecord.id, new Review(null, null, this.chooseCures, this.disease, this.chooseSymptoms, user)).subscribe(
      (data: MedicalRecord)  => this.medicalRecord = data,
      error => alert(error),
      () => {
        this.visible = false;
        this.validateC = false;
        this.novalidateC = false;
        this.selectedItems2 = [];

      }
    );
  }

  findDisease(id: number)
  {
    for(let disease of this.allDiseases)
    {
      if(disease.id == id)
        return disease;
    }

    return null;
  }

  showSymptoms()
  {
    this.diseaseService.getSymptoms(this.selectedDisease).subscribe(
      (data: Symptom[])  => this.symptomsOfDisease = data,
      error => alert(error),
      () => {
        this.tableVisible = true;
        this.chooseSymptoms = this.symptomsOfDisease;
      }
    );
  }


  onItemSelect(item:any){
    console.log("Broj selektovanih: " + this.selectedItems1.length);
  }
  onItemDeselect(items: any){
    console.log("Broj selektovanih: " + this.selectedItems1.length);  }

  onDiseaseSelect(item:any){
    this.selectedDisease = this.findDisease(item.item_id);
    this.disease = this.selectedDisease;
    this.showSymptoms();
  }


}
