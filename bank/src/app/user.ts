import { Address } from "./address";
import{Account} from "./account";


export class User {

     id:number;
     userId:string;
     name:string;
     password:string;
     aadhar:string;
     pan:string; 
     accountType:string;
     mobile:string;
	 userType:string;
     address:Address;
     account:Account;

    
     
     constructor( id:number,userId:string,name:string, password:string,aadhar:string,
        pan:string,accountType:string,mobile:string, userType:string,address:Address,
        account:Account)
     {
          this.id=id;
          this.userId=userId;
          this.name=name;
          this.password=password;
          this.aadhar=aadhar;
          this.pan=pan;
          this.accountType=accountType;
          this.mobile=mobile;
          this.userType=userType;
          this.address=address;
          this.account=account;
     }

}
