import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { Transaction } from 'src/app/models/transaction.model';
import { TransactionService } from 'src/app/services/transaction.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  sessionId: any;
  payees!: Customer[];
  payeeSelected: Customer = {};
  currentCustomer: Customer = {};
  trans: Transaction = {};
  ngOnInit(): void {
    this.customerService.getPayee(this.sessionId).subscribe(
      response => {
        this.payees = response;
        console.log(this.payees);
      },
      error => {
        console.log(error);
      }
    )
  }
  constructor(private customerService: CustomerService, private transactionService: TransactionService, private router: Router, private route: ActivatedRoute) {
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

  transfer(payee: string, amt: string): void {
    this.customerService.getByEmail(this.sessionId).subscribe(
      data => {
        this.currentCustomer = data;
        this.customerService.getByEmail(payee).subscribe(
          data => {
            this.payeeSelected = data;
            console.log(data);
            this.customerService.withdraw(this.currentCustomer.custId, parseFloat(amt)).subscribe(
              response => {
                console.log(response);
                this.customerService.deposit(this.payeeSelected.custId, parseFloat(amt)).subscribe(
                  response => {
                    console.log(response);
                    this.trans.custId = this.currentCustomer.custId;
                    this.trans.account = this.currentCustomer.bankAcc;
                    this.trans.operation = "WITHDRAW";
                    this.trans.amount = parseFloat(amt);
                    this.trans.timestamp = new Date();
                    this.transactionService.addTransaction(this.trans).subscribe(
                      data => {
                        console.log(data);
                      },
                      error => {
                        console.log(error);
                      }
                    )
                    this.trans.custId = this.payeeSelected.custId;
                    this.trans.account = this.payeeSelected.bankAcc;
                    this.trans.operation = "DEPOSIT";
                    this.trans.amount = parseFloat(amt);
                    this.trans.timestamp = new Date();
                    this.transactionService.addTransaction(this.trans).subscribe(
                      data => {
                        console.log(data);
                      },
                      error => {
                        console.log(error);
                      }
                    )
                    alert("Money transferred successfully");
                    this.router.navigate(['/dashboard/' + this.sessionId]);
                  },
                  error => {
                    this.customerService.update(this.currentCustomer.custId, this.currentCustomer).subscribe(
                      data => console.log(data),
                      error => {
                        console.log("Update failed!!");
                        console.log(error);
                      }
                    )
                    console.log(error);
                  }
                )
              },
              error => {
                console.log(error);
              });
          },
          error => {
            console.log(error);
          }
        )

      },
      error => {
        console.log(error);
      }
    )
  }
}
