import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCashBalComponent } from './update-cash-bal.component';

describe('UpdateCashBalComponent', () => {
  let component: UpdateCashBalComponent;
  let fixture: ComponentFixture<UpdateCashBalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCashBalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCashBalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
