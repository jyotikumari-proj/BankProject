import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _router:Router) { }

  userReg(pageName:string):void
  {
    console.log("inside user Registration");
    this._router.navigate([`${pageName}`]);
  }

  login(pageName:string):void
  {
   console.log("inside user login home page");
   this._router.navigate([`${pageName}`]);
  }

  logout(pageName:string):void
  {
   console.log("inside user logout home page");
   this._router.navigate([`${pageName}`]);
  }

  home(pageName:string):void
  {
   console.log("inside  home page");
   this._router.navigate([`${pageName}`]);
  }

  ngOnInit(): void {
  }

}
