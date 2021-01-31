export class Fd {
    fdId:number;
    userId:string;
    depositAmount:string;
    period:string;
    interestRate:string;
    maturityAmount:string;
    dateOfBooking:string;
    dateOfMaturity:string;


    constructor(fdId:number,userId:string,depositAmount:string,
        period:string,interestRate:string,maturityAmount:string,
        dateOfBooking:string,dateOfMaturity:string )
    {
        this.fdId=fdId;
        this.userId=userId;
        this.depositAmount=depositAmount;
        this.period=period;
        this.interestRate=interestRate;
        this.maturityAmount=maturityAmount;
        this.dateOfBooking=dateOfBooking;
        this.dateOfMaturity=dateOfMaturity;
    }

}
