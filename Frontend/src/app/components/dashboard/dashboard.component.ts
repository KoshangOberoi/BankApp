import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  sessionId: any;
  ngOnInit(): void {

  }

  constructor(private customerService: CustomerService, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

}
