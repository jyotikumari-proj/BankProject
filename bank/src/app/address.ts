export class Address {

    addressId : number;
		houseNo : string;
		location : string;
		city : string;
		state : string;
        pin : string;
        
        constructor(addressId:number,houseNo:string,location:string,
            city:string,state:string,pin:string)
        {
            this.addressId = addressId;
		this.houseNo = houseNo;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pin = pin;
        }
}
