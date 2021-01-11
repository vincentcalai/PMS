import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortfolioTransComponent } from './portfolio-trans.component';

describe('PortfolioTransComponent', () => {
  let component: PortfolioTransComponent;
  let fixture: ComponentFixture<PortfolioTransComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortfolioTransComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfolioTransComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
