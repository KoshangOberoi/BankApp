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
  pb: any;
  ab: any;
  ngOnInit(): void {
    this.customerService.getByEmail(this.sessionId).subscribe(
      data =>{
        this.pb = data.pri_bal;
        this.ab = data.bal;
      },
      error => {
        console.log(error);
      }
    )
  }

  constructor(private customerService: CustomerService, private route: ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

}
