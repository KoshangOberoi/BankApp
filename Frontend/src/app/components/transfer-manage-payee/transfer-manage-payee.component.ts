import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { error } from 'jquery';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'manage-payee',
  templateUrl: './transfer-manage-payee.component.html',
  styleUrls: ['./transfer-manage-payee.component.css']
})
export class TransferManagePayeeComponent implements OnInit{
  sessionId: any;
  payees: Customer[] = [];
  custId: any;
  hasPayees: boolean = true;
  ngOnInit(): void {
    this.customerService.getPayee(this.sessionId).subscribe(
      response => {
        this.payees = response;
        this.hasPayees = this.payees.length > 0;
        console.log(this.payees);
      },
      error => {
        console.log(error);
      }
    )
  }

  constructor(private customerService: CustomerService, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

  remove(payeeId: any){
    this.customerService.getByEmail(this.sessionId).subscribe(
      customerData => {
        this.custId = customerData.custId;
        this.customerService.removePayee(this.custId, payeeId).subscribe(
          data => {
            this.payees =  this.payees.filter(payee => payee.custId !== payeeId);
            this.hasPayees = this.payees.length > 0;
            alert("Payee removed");
            console.log(data);
          },
          error => {
            console.log(error);
          }
        );
      },
      error => console.log(error)
    );
  }

}

