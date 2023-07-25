import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';
import { error } from 'jquery';



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
    if(ifsc.length<4 || !this.Bank.has(ifsc.toUpperCase().substring(0,4))){
      alert("Invalid IFSC");
      return;
    }
    this.valid=true;
  }
  addPayee(name: any, acc: any){
    if(!this.valid)return;
    this.customerService.getByEmail(this.sessionId).subscribe(
      data =>{
        this.currentCustomer = data;
        this.customerService.getByAcc(acc.toUpperCase()).subscribe(
          data =>{
            if(data.name?.toUpperCase() != name.toUpperCase()){
              alert("Payee name dosen't match with the holders name");
            }
            else{
              this.customerService.addPayee(acc, this.currentCustomer.custId).subscribe(
                response => {
                  this.valid = false;
                  alert("Payee added successfully");
                  console.log(response);
                },
                error => {
                  this.valid = false;
                  alert("Can't add payee!");
                }
              )
            }
          },
          error =>{
            alert("Account doesn't exist!");
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
