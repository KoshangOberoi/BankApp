import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiniStatementComponent } from './mini-statement.component';

describe('MiniStatementComponent', () => {
  let component: MiniStatementComponent;
  let fixture: ComponentFixture<MiniStatementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MiniStatementComponent]
    });
    fixture = TestBed.createComponent(MiniStatementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
