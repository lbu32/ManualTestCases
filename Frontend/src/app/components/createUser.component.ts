import {Component} from 'angular2/core';
import {CreateUserService}  from '../services/createUser.service';
import {RegisterService} from '../services/login.service';
import {DropdownModule} from 'primeng/primeng';
import {SelectItem} from 'primeng/primeng';

@Component({
  selector: 'createUser',
  templateUrl: './createUser.component.html',
  providers:[CreateUserService]
})
  constructor(private createUserService: CreateUserService) {
    this.user = localStorage.getItem("createUserService");
  }

  onSubmit() {
    this.createUserService.sendCredential(this.model).subscribe(
      data => {
        localStorage.setItem("token", JSON.parse(JSON.stringify(data))._body);
        this.createUserService.sendToken(localStorage.getItem("token")).subscribe(
          data => {
            this.currentUserName=this.model;
            localStorage.setItem("currentUserName", this.model.name);
      }
      }
  });




