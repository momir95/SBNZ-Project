import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent} from './components/home/home.component';
import { AddUserComponent } from './components/addUser/addUser.component';
import {FindMedicalRecordComponent} from "./components/doctor/findMedicalRecord/findMedicalRecord.component";
import {ShowMedicalRecordComponent} from "./components/doctor/showMedicalRecord/showMedicalRecord.component";
import {CreateMedicalRecordComponent} from "./components/doctor/createMedicalRecord/createMedicalRecord.component";
import {AddCureComponent} from "./components/admin/addCure/addCure.component";
import {AddIngredientComponent} from "./components/admin/addIngredient/addIngredient.component";
import {AddDiseaseComponent} from "./components/admin/addDisease/addDisease.component";

const appRoutes : Routes =
  [
    {
      path : '',
      component : HomeComponent
    },
    {
      path : 'findMedicalRecord',
      component : FindMedicalRecordComponent
    },
    {
      path : 'showMedicalRecord/:p1',
      component : ShowMedicalRecordComponent
    },
    {
      path : 'createMedicalRecord',
      component : CreateMedicalRecordComponent
    },
    {
      path : 'createCure',
      component : AddCureComponent
    },
    {
      path : 'createIngredient',
      component : AddIngredientComponent
    },
    {
      path : 'addDoctor',
      component : AddUserComponent
    },
    {
      path : 'createDisease',
      component : AddDiseaseComponent
    },

  ];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

