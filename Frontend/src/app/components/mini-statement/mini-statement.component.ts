import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Transaction } from 'src/app/models/transaction.model';
import { CustomerService } from 'src/app/services/customer.service';
import { TransactionService } from 'src/app/services/transaction.service';


@Component({
  selector: 'app-mini-statement',
  templateUrl: './mini-statement.component.html',
  styleUrls: ['./mini-statement.component.css']
})
export class MiniStatementComponent implements OnInit{
  sessionId: any;
  ts: Transaction[] = [];
  x: any;
  ngOnInit(): void {
    this.customerService.getByEmail(this.sessionId).subscribe(
      data => {
        this.transactionService.miniStatement(data.custId).subscribe(
          data =>{
            this.ts = data;
            console.log(data);
        },
        error => console.log(error)
        )
      },
      error => console.log(error)
    )
  }

  constructor(private transactionService: TransactionService, private customerService: CustomerService, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }


}
