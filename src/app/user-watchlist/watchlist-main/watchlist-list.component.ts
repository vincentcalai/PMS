
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { RequestService } from 'src/app/service/request.service';
import { CreateWatchlistComponent } from '../create-watchlist/create-watchlist.component';
import { WatchlistComponent } from '../watchlist/watchlist.component';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist-list.component.html',
  styleUrls: ['./watchlist-list.component.css']
})
export class WatchlistListComponent implements OnInit {

  watchlists: [];
  message: String = '';

  totalItems = 0;
  itemsPerPage = 5;
  p = 1;

  constructor(private requestService: RequestService,
              private dataService: DataService,
              private dialog: MatDialog,
              private router: Router) { }

  ngOnInit(): void {
    this.message = "";
    console.log("init watchlist main");
    if (this.dataService.dataObj && this.dataService.dataObj.watchlistForm) {
      this.message = this.dataService.dataObj.watchlistForm.systemMsg;
      window.scroll(0,0);
    }
    this.dataService.setDataObj(null);
    this.retrieveAllWatchlist(1);
  }

  retrieveAllWatchlist(page){
    this.requestService.get('/watchlist?page=' + page + '&size=' + this.itemsPerPage).subscribe(
      data => {
        this.p = page;
        this.watchlists = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  updateWatchlist(watchlist){
    this.dataService.setDataObj({watchlist: watchlist});
    this.router.navigate(['/watchlist']);
  }

  createWatchlist(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";

    this.dialog.open(CreateWatchlistComponent, {
      width: '60%'
    }).afterClosed().subscribe( result=> {
        this.ngOnInit();
        //window.scroll(0,0);
    });
  }

  deleteWatchlist(id){
    if(!confirm("Are you sure to delete this watchlist? Entries of this watchlist will be deleted permanently.")) {
      return
    }
    this.requestService.delete(`/watchlist/deletewatchlist/${id}`).subscribe(
      data => {
        console.log(data);
        this.retrieveAllWatchlist(1);
        this.message = (data as any).systemMsg;
      }
    );
  }
}
