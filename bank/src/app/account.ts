export class Account {

    accountId:number
    accountNo:string;
    balance:string;

    constructor(accountId:number,accountNo:string,balance:string)
    {
        this.accountId=accountId;
        this.accountNo=accountNo;
        this.balance=balance;
    }
}
