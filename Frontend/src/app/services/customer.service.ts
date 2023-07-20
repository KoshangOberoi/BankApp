import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/cusotmer.model';

const baseUrl = 'http://localhost:8282/api/v1/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(baseUrl);
  }

  getById(custId: any): Observable<Customer> {
    return this.http.get(`${baseUrl}/${custId}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(custId: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${custId}`, data);
  }
  register(data: any): Observable<Customer>{
    return this.http.post(baseUrl+"/new", data);
  }
  getByEmail(custEmail: any): Observable<Customer>{
    return this.http.get(`${baseUrl+"/email/"+custEmail}`);
  }
  deposit(custId: any, amt:any){
    return this.http.put(`${baseUrl+"/deposit/"+custId+"/"+amt}`, null);
  }
  withdraw(custId: any, amt:any){
    return this.http.put(`${baseUrl+"/withdraw/"+custId+"/"+amt}`, null);
  }
  addPayee(bankAcc: any, custId: any){
    return this.http.put(`${baseUrl+"/add-payee/"+custId+"/"+bankAcc}`, null);
  }
  getPayee(custEmail: any): Observable<Customer[]>{
    return this.http.get<Customer[]>(`${baseUrl+"/get-payee/"+custEmail}`);
  }
  deleteById(custId: any): Observable<any>{
    return this.http.delete(`${baseUrl+"/"+custId}`);
  }
  removePayee(custId: any, payeeId: any): Observable<any>{
    return this.http.put(`${baseUrl+"/remove-payee/"+custId+"/"+payeeId}`, null);
  }
}
