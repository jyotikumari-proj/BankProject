import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fd } from '../fd';
import { PocserviceService } from '../pocservice.service';
import { User } from '../user';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css']
})
export class DashComponent implements OnInit {
  name :any;
  accountNo:any;
  balance : any;
  accountType: any;
  userId:any;
  fixedDeposit:Fd;
  fdList:Fd[]=[];
  msg:any;
  isDataLoded:any=false;
        
  constructor(private y:PocserviceService,private router: Router) { 
     this.fixedDeposit=new Fd(0,'','','','','','','');
  }

  fdStatement():void
  {
    console.log("inside fd statement");
    this.y.multiselect(this.userId).
    subscribe(
      (o:Fd[])=>{
        if(o.length == 0)
        this.msg="such type not present";
        else
        {
            this.fdList=o;
            this.isDataLoded=true;
            console.log("success");
            this.msg="got some rows";
            console.log(this.msg);
            console.log("Final data="+JSON.stringify(o));
        }
      },
    (err)=>{ this.msg="fail"});
  }
  
  ngOnInit(): void {
  var sessionToken=sessionStorage.getItem("token");
  console.log("Hiiiiiii"+sessionToken);
    if (sessionToken=="userIsActive") {
      console.log("Yeee Usee is acive "+sessionToken);
    } else {
      console.log("Session is not active "+sessionToken);
      this.router.navigate([`/login`]);
    }
  this.name=localStorage.getItem("uname");
  this.accountNo=localStorage.getItem("uaccNu");
  this.balance= localStorage.getItem("uBan");
  this.accountType= localStorage.getItem("uAccType");
  this.userId=sessionStorage.getItem("logedInUser");
  console.log(this.accountType);
  this.getUserById(this.userId);
  }

  getUserById(uId:string): void {
    //Server call , u can 
    console.log("inside getUserById inside ngonit");
    this.y.updateBalance(this.userId).
    subscribe(
      (u:User)=>{
        console.log("ngonit msg success");
        console.log("updated balance"+u.account.balance);
        localStorage.setItem("uBan",u.account.balance);
        this.balance= localStorage.getItem("uBan");
      },
    (err)=>{ this.msg="fail"});
  }

}
