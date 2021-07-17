import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { WatchlistListComponent } from './watchlist-list.component';

describe('WatchlistComponent', () => {
  let component: WatchlistListComponent;
  let fixture: ComponentFixture<WatchlistListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WatchlistListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WatchlistListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
