import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadDividendComponent } from './load-dividend.component';

describe('LoadDividendComponent', () => {
  let component: LoadDividendComponent;
  let fixture: ComponentFixture<LoadDividendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoadDividendComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadDividendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
