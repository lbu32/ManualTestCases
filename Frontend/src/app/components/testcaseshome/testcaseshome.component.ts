import { Component, OnInit } from '@angular/core';
import { Testcase } from './testcaseshome';

@Component({
  selector: 'app-testcaseshome',
  templateUrl: './testcaseshome.component.html',
  // styleUrls: ['./testcaseshome.component.css']
})
export class TestcaseshomeComponent 
// implements OnInit 
{

  // constructor() { 

    
  // }

  // ngOnInit() {
  // }
  tests = [
    new Testcase(1, 'Testfallname 1', true, 'false'),
    new Testcase(2, 'Testfallname 2', true, 'true'),
    new Testcase(3.2, 'Testfallname 3 - Version 2', true, 'untested'),
    new Testcase(3.1, 'Testfallname 3 - Version 1', false, 'untested')
        
    ];



}
