import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfitLossDashboardComponent } from './profit-loss-dashboard.component';

describe('ProfitLossDashboardComponent', () => {
  let component: ProfitLossDashboardComponent;
  let fixture: ComponentFixture<ProfitLossDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfitLossDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfitLossDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
