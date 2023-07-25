import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';
import { Transaction } from 'src/app/models/transaction.model';
import { TransactionService } from 'src/app/services/transaction.service';
@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit{
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
  currentCustomer : Customer = {
    custId: 0,
    bal: 0,
    pri_bal: 0
  };

  constructor(private customerService: CustomerService, private transactionService: TransactionService, private router: Router, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

  withdraw(amt: string){
    this.customerService.getByEmail(this.sessionId).subscribe(
      data => {
        this.currentCustomer = data;
        this.customerService.withdraw(this.currentCustomer.custId, parseFloat(amt)).subscribe(
          response => {
            if(parseInt(localStorage.getItem('count') as string) >= 5){
              data.bal = (data.bal as number) - 1.02*parseFloat(amt);
              console.log(localStorage.getItem('count'));
              if(data.bal < 0){
                this.customerService.update(this.currentCustomer.custId, this.currentCustomer);
              }
              else{
                data.pri_bal = (data.pri_bal as number) - parseFloat(amt);
                this.customerService.update(this.currentCustomer.custId, data).subscribe(
                  response =>{
                    console.log(response);
                  },
                  error =>{
                    console.log(error);
                  }
                );
              }
            }
            this.trans.custId = data.custId;
            this.trans.account = data.bankAcc;
            this.trans.operation = "WITHDRAW";
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
