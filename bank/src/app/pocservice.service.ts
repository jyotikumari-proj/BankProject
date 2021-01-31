import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import { User } from './user';
import { UserStatus } from './user-status';
import { Fd } from './fd';

@Injectable({
  providedIn: 'root'
})
export class PocserviceService {

  constructor(private x:HttpClient) { }

  callws(u:User):Observable<User>
  {
    let url="http://localhost:5252/register";
    console.log("text msg");
     return this.x.post<User>(url,u);
  
  }

  callsingleselect(userId:String,password:String):Observable<User>
{
  console.log("inside service"+"userid="+userId+"password="+password);
  let url="http://localhost:5252/login?userId="+userId+"&password="+password;
  console.log("url="+url); //bc period
  return this.x.get<User>(url);
}


  callFd(fixedDeposit:Fd):Observable<Fd>
  {
    console.log("inside service fd"+fixedDeposit);
    let url="http://localhost:5252/fd";
    return this.x.post<Fd>(url,fixedDeposit);
  }

  multiselect(userId:string):Observable<Fd[]>
  {
    let url="http://localhost:5252/fdstatement?userId="+userId; 
    console.log(url);
     return this.x.get<Fd[]>(url);
  }

  updateBalance(userId:string):Observable<User>
  {
    let url="http://localhost:5252/userById?userId="+userId; 
    console.log(url);
    return this.x.get<User>(url);
  }

}
