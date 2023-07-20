import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';



@Component({
  selector: 'add-payee',
  templateUrl: './tranfer-add-payee.component.html',
  styleUrls: ['./tranfer-add-payee.component.css']
})
export class TranferAddPayeeComponent implements OnInit{
  valid: boolean;
  Bank = new Map();
  currentCustomer : Customer = {};
  sessionId: any;
  ngOnInit(): void {

  }

  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
    this.Bank.set("DFSX", "HDFC");
    this.Bank.set("MWEB", "ICICI");
    this.Bank.set("GHIJ", "CANARA");
    this.Bank.set("NVCT", "HSBC");
    this.valid = false;
  }
  validate(ifsc: String){
    if(ifsc.length<4 || !this.Bank.has(ifsc.substring(0,4)))return;
    this.valid=true;
  }
  addPayee(name: any, acc: any){
    if(!this.valid)return;
    this.customerService.getByEmail(this.sessionId).subscribe(
      data =>{
        this.currentCustomer = data;
        this.customerService.addPayee(acc, this.currentCustomer.custId).subscribe(
          response => {
            console.log(response);
          }
        )
        console.log(this.currentCustomer);
      },
      error => {
        console.log(error);
      }
    )
  }
}
