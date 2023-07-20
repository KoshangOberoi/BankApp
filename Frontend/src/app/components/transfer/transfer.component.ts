import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit{
  sessionId: any;
  ngOnInit(): void {
  }
  constructor(private customerService: CustomerService, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

}
