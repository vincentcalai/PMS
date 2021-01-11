import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortfolioHoldComponent } from './portfolio-hold.component';

describe('PortfolioHoldComponent', () => {
  let component: PortfolioHoldComponent;
  let fixture: ComponentFixture<PortfolioHoldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortfolioHoldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfolioHoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
