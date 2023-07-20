import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranferAddPayeeComponent } from './tranfer-add-payee.component';

describe('TranferAddPayeeComponent', () => {
  let component: TranferAddPayeeComponent;
  let fixture: ComponentFixture<TranferAddPayeeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TranferAddPayeeComponent]
    });
    fixture = TestBed.createComponent(TranferAddPayeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
