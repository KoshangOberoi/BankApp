import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/cusotmer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.css']
})
export class WelcomePageComponent implements OnInit{
  sessionId: any;
  accNo = Math.random().toString(36).substring(2,9);
  currentCustomer : Customer = {
    custEmail: '',
    password: ''
  };
  status=false;

  ngOnInit(): void {
  }

  constructor(private customerService: CustomerService, private router: Router){
  }

  registerCust(name: String, email: String, pass: String): void{
    const data = {
      name: name,
      custEmail: email,
      password: pass,
      bankAcc: this.accNo
    };
    this.customerService.register(data).subscribe(
      response => {
        console.log(this.accNo);
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  login(uemail: String, upass: String): void{
    this.customerService.getByEmail(uemail).subscribe(
      data => {
        this.currentCustomer = data;
        this.sessionId = uemail;
        if(this.currentCustomer.password == upass){
          if(this.currentCustomer.kycStatus == 1){
            this.router.navigate(['/dashboard', this.sessionId]);
          }
          else{
            this.router.navigate(['/kyc', this.sessionId]);
          }
        }
        else{
          console.log("incorrect password!!");
        }
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
