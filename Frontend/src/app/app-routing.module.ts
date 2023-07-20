import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KycComponent } from './components/kyc/kyc.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { WithdrawComponent } from './components/withdraw/withdraw.component';
import { TransferComponent } from './components/transfer/transfer.component';
import { MiniStatementComponent } from './components/mini-statement/mini-statement.component';
import { DepositComponent } from './components/deposit/deposit.component';
import { TranferAddPayeeComponent } from './components/tranfer-add-payee/tranfer-add-payee.component';
import { TransferManagePayeeComponent } from './components/transfer-manage-payee/transfer-manage-payee.component';

const routes: Routes = [
  {path:"kyc/:sessionId", component:KycComponent},
  {path:"login",component:WelcomePageComponent},
  {path:"dashboard/:sessionId", component:DashboardComponent},
  {path:"Deposit/:sessionId", component:DepositComponent},
  {path:"Withdraw/:sessionId", component:WithdrawComponent},
  {path:"Transfer/:sessionId", component:TransferComponent},
  {path:"MiniStatement/:sessionId",component:MiniStatementComponent},
  {path:"Transfer/add-payee/:sessionId", component:TranferAddPayeeComponent},
  {path:"Transfer/manage-payee/:sessionId", component:TransferManagePayeeComponent},
  {path:"", redirectTo:"login", pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
