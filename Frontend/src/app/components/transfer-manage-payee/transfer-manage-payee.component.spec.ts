import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferManagePayeeComponent } from './transfer-manage-payee.component';

describe('TransferManagePayeeComponent', () => {
  let component: TransferManagePayeeComponent;
  let fixture: ComponentFixture<TransferManagePayeeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TransferManagePayeeComponent]
    });
    fixture = TestBed.createComponent(TransferManagePayeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
