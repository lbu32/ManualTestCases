import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent }  from './components/home.component';
import { Register} from './components/register.component';
import {Login} from './components/login.component';
import { TestcaseshomeComponent } from './components/testcaseshome/testcaseshome.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  //damit Nutzer keinen direkten Zugriff auf home haben, das heißt die home-Seite aufrufen können,
  //ohne angemeldet zu sein, sollte hier der path auskommentiert bzw. nicht definiert sein
  {
    path: 'home',
    component: HomeComponent
  },
  {
  	path: 'register',
  	component: Register
  },
  {
    path: 'login',
    component: Login
  },
  {
    path: 'testcaseshome',
    component: TestcaseshomeComponent
  }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
