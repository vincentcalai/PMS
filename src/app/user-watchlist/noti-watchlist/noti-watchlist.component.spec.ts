import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotiWatchlistComponent } from './noti-watchlist.component';

describe('NotiWatchlistComponent', () => {
  let component: NotiWatchlistComponent;
  let fixture: ComponentFixture<NotiWatchlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotiWatchlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotiWatchlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
