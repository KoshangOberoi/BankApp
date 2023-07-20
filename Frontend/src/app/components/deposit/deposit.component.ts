import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { Router } from '@angular/router';
import { TransactionService } from 'src/app/services/transaction.service';
import { Transaction } from 'src/app/models/transaction.model';
import { error } from 'jquery';
@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  sessionId: any;
  trans: Transaction = {
    transId: 0,
    custId: 0,
    account: "",
    operation: "",
    amount: 0,
    timestamp: new Date(0)
  };
  ngOnInit(): void {
  }
  constructor(private customerService: CustomerService, private transactionService: TransactionService, private router: Router, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }
  currentCustomer : Customer = {
    custId: 0,
    bal: 0
  };
  deposit(amt: string){
    this.customerService.getByEmail(this.sessionId).subscribe(
      data => {
        this.currentCustomer = data;
        this.customerService.deposit(this.currentCustomer.custId, parseFloat(amt)).subscribe(
          response => {
            this.trans.custId = data.custId;
            this.trans.account = data.bankAcc;
            this.trans.operation = "DEPOSIT";
            this.trans.amount = parseFloat(amt);
            this.trans.timestamp = new Date();
            this.transactionService.addTransaction(this.trans).subscribe(
              data =>{
                console.log(data);
              },
              error => {
                console.log(error);
              }
            )
            this.router.navigate(['/dashboard/'+this.sessionId]);
            console.log(response);
          },
          error => {
            console.log(error);
          });

        console.log(data);
      },
      error => {
        console.log(error);
      });
  }


}


