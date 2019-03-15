import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {routing} from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import {NavBar} from './components/nav-bar.component';
import {Register} from './components/register.component';
import {Login} from './components/login.component';

import {RegisterService} from './services/register.service';
import {LoginService} from './services/login.service';
import {UserService} from './services/user.service';

import { CustomerlistComponent } from './components/customerlist/customerlist.component';
import { TestcaseshomeComponent } from './components/testcaseshome/testcaseshome.component';
import { TestcaseprotocolsComponent } from './components/testcaseprotocols/testcaseprotocols.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBar,
    Register,
    Login,
    CustomerlistComponent,
    TestcaseshomeComponent,
    TestcaseprotocolsComponent,
    CreateCustomerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
    RegisterService,
    LoginService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
