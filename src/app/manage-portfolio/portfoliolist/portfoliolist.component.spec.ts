import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortfoliolistComponent } from './portfoliolist.component';

describe('PortfoliolistComponent', () => {
  let component: PortfoliolistComponent;
  let fixture: ComponentFixture<PortfoliolistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortfoliolistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfoliolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
