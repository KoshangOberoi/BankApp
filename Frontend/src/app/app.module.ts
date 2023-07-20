import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { KycComponent } from './components/kyc/kyc.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DepositComponent } from './components/deposit/deposit.component';
import { WithdrawComponent } from './components/withdraw/withdraw.component';
import { MiniStatementComponent } from './components/mini-statement/mini-statement.component';
import { TransferComponent } from './components/transfer/transfer.component';
import { HttpClientModule } from '@angular/common/http';
import { TranferAddPayeeComponent } from './components/tranfer-add-payee/tranfer-add-payee.component';
import { TransferManagePayeeComponent } from './components/transfer-manage-payee/transfer-manage-payee.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    KycComponent,
    DashboardComponent,
    DepositComponent,
    WithdrawComponent,
    MiniStatementComponent,
    TransferComponent,
    TranferAddPayeeComponent,
    TransferManagePayeeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
