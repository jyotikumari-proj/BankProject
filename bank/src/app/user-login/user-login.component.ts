import { dashCaseToCamelCase } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import { PocserviceService } from '../pocservice.service';
import { User } from '../user';
import { UserStatus } from '../user-status';
import { Router } from '@angular/router';
import { Account } from '../account';
//import { UserStatus } from '../user-status';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  msg:any;
   user:User;
  address:Address;
  account:Account;
  //token:

  constructor(private y:PocserviceService, private _router:Router) {
   
    this.address=new Address(0,'','','','','');
    this.account=new Account(0,'','');
    this.user =new User(0,'','','','','','','','',this.address,this.account);
   
   }

   dash(pageName:string,user:User):void
  {
   console.log("inside user login home page"+user);
   localStorage.setItem("uname",this.user.name);
   localStorage.setItem("uaccNu",this.user.account.accountNo);
   localStorage.setItem("uBan",this.user.account.balance); 
   localStorage.setItem("uAccType",this.user.accountType);

   console.log("name type 1 is: "+user.name);
   console.log("name type 2 is: "+this.user.name);
   console.log("name type 2 is: "+this.user.accountType);
   sessionStorage.setItem("logedInUser",this.user.userId);
   sessionStorage.setItem("loggedInPassword",this.user.password);
   this._router.navigate([`${pageName}`]);
   }

  goToBankDashBoard()
  {
    this.y.callsingleselect(this.user.userId,this.user.password).
    subscribe((user:User)=>{
      this.user=user;
      if(this.user==user)
      {
        console.log("inside if");
        sessionStorage.setItem("token","userIsActive");
        this.dash('dash',user);
      }
      console.log("userid="+this.user.userId+"password="+this.user.password);
        
    },
    (err)=>{
        this.msg="failure";
        sessionStorage.clear();
    });

  }

  ngOnInit(): void {
    sessionStorage.clear();// Session will vanish one login page will load
  }

}
