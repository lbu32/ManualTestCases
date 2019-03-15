import {Component} from '@angular/core';
import {Observable}  from 'rxjs/Observable';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class Login {
  private model = {'email':'', 'password':''};
  private currentUserName;

  constructor (private loginService: LoginService){
    this.currentUserName=localStorage.getItem("currentUserName");
  }

  onSubmit() {
    this.loginService.sendCredential(this.model).subscribe(
      data => {
                localStorage.setItem("token", JSON.parse(JSON.stringify(data))._body);
                this.loginService.sendToken(localStorage.getItem("token")).subscribe(
                  data => {
                            this.currentUserName=this.model.email;
                            localStorage.setItem("currentUserName", this.model.email);
                            this.model.email='';
                            this.model.password='';
                          },
                  error => console.log(error)
                );
              },
      error => console.log(error)
    );

  }


}
