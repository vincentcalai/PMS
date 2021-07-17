import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfitLossComponent } from './profit-loss.component';

describe('ProfitLossDashboardComponent', () => {
  let component: ProfitLossComponent;
  let fixture: ComponentFixture<ProfitLossComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfitLossComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfitLossComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
