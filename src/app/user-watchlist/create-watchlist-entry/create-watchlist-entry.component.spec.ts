import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateWatchlistEntryComponent } from './create-watchlist-entry.component';

describe('CreateWatchlistEntryComponent', () => {
  let component: CreateWatchlistEntryComponent;
  let fixture: ComponentFixture<CreateWatchlistEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateWatchlistEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateWatchlistEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
