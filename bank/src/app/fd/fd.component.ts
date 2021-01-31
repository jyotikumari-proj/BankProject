import { Component, OnInit } from '@angular/core';
import { PocserviceService } from '../pocservice.service';
import { Fd } from '../fd';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fd',
  templateUrl: './fd.component.html',
  styleUrls: ['./fd.component.css']
})
export class FdComponent implements OnInit {
  userId:any;
  password:any;
  name:any;
  accountNo:any;
  balance:any;
  fixedDeposit:Fd;
  year: any=0;
  month:any=0;
  day:any=0;
  msg:any;
  msg2:any;

  constructor(private y:PocserviceService,private router: Router) {
    this.fixedDeposit=new Fd(0,'','','','','','','');
    }

    checkDepositAmount()
    {
      console.log("inside checkDepositAmount method");
      console.log("deposit amount="+this.fixedDeposit.depositAmount);
      console.log("customer balance="+this.balance);
     
      var da: number = +this.fixedDeposit.depositAmount;
      var bal: number = +this.balance;

      console.log("int deposit amount="+da);
      console.log("int customer balance="+bal);
      console.log("return ="+(da<=bal));
      if(da<=bal)
      {
        console.log("inside if call submit method");
        this.submit(); 
      }
      else
      {
        console.log("inside else");
           this.msg="Deposit Amount should be less than or equal to a/c balance amount";
           this.msg2="";
      }
    }
    
    submit()
    {
      console.log("inside submit method");
      console.log("year is: "+this.year+" month is: "+this.month+" day s: "+this.day);
      this.fixedDeposit.period=this.year+"-"+this.month+"-"+this.day;
      this.fixedDeposit.interestRate="5";
      this.fixedDeposit.userId=this.userId;
      console.log("Period is : "+ this.fixedDeposit.period);
      this.y.callFd(this.fixedDeposit).subscribe(
        (data:Fd)=>{ 
            console.log("inside subscriber");
            this.msg="your FD is successfully booked";
            this.msg2="Matured Amount is :"+data.maturityAmount;
            console.log("msg="+this.msg);
            console.log("msg2="+data.maturityAmount);
            console.log("object fd id"+data.fdId);
            console.log("object deposi amount"+data.depositAmount);
            console.log("object data"+JSON.stringify(data));
            
        }, 
          (err)=>{JSON.stringify(err)} 
        );
    }


  ngOnInit(): void {
    var sessionToken=sessionStorage.getItem("token");
    console.log("inside fd page"+sessionToken);
      if (sessionToken=="userIsActive") {
        console.log("Yeee Usee is acive "+sessionToken);
      } else {
        console.log("Session is not active "+sessionToken);
        this.router.navigate([`/login`]);
      }
  this.userId=sessionStorage.getItem("logedInUser");
  this.password= sessionStorage.getItem("loggedInPassword");
  console.log("fd page userid="+this.userId);

  this.name=localStorage.getItem("uname");
  this.accountNo=localStorage.getItem("uaccNu");
  this.balance=localStorage.getItem("uBan");
  console.log("fd balance:"+this.balance);
  
  }

}
