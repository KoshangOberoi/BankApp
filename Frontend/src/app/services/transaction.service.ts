import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../models/transaction.model';

const baseUrl = 'http://localhost:8282/api/v1/transactions';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(baseUrl);
  }
  miniStatement(custId: any): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(baseUrl+"/"+custId);
  }
  addTransaction(t: Transaction): Observable<Transaction>{
    return this.http.post<Transaction>(baseUrl, t);
  }
}
