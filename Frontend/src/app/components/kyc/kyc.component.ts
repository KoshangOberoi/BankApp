import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-kyc',
  templateUrl: './kyc.component.html',
  styleUrls: ['./kyc.component.css']
})
export class KycComponent implements OnInit{
  sessionId: any;
  currentCustomer : Customer = {
    custId: 0,
    custEmail: '',
    name: '',
    address: '',
    bal: 0,
    CIBILscore: 0,
    aadhar: '',
    pan: '',
    kycStatus: 0,
    password: ''
  };

  constructor(private customerService: CustomerService, private router: Router, private route:ActivatedRoute){
    this.sessionId = this.route.snapshot.paramMap.get('sessionId');
  }

  ngOnInit(): void {

  }

  updateStatus(aadhar: String, pan: String){
    if(aadhar == "" || pan == ""){
      return;
    }
    this.customerService.getByEmail(this.sessionId).subscribe(
      data => {
        this.currentCustomer = data;
        this.currentCustomer.aadhar = aadhar;
        this.currentCustomer.pan = pan;
        this.currentCustomer.kycStatus = 1;
        this.customerService.update(this.currentCustomer.custId, this.currentCustomer).subscribe(
          response => {
            this.router.navigate(['/login']);
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
