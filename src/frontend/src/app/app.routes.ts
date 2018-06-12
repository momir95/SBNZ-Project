import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent} from './components/home/home.component';
import { AddUserComponent } from './components/addUser/addUser.component';
import {FindMedicalRecordComponent} from "./components/doctor/findMedicalRecord/findMedicalRecord.component";
import {ShowMedicalRecordComponent} from "./components/doctor/showMedicalRecord/showMedicalRecord.component";

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
      path : 'addUser',
      component : AddUserComponent
    }

  ];

export const routing : ModuleWithProviders = RouterModule.forRoot(appRoutes);

