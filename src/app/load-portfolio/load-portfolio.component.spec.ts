import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadPortfolioComponent } from './load-portfolio.component';

describe('LoadPortfolioComponent', () => {
  let component: LoadPortfolioComponent;
  let fixture: ComponentFixture<LoadPortfolioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoadPortfolioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadPortfolioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
