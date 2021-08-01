import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/util/service/data.service';
import { RequestService } from 'src/app/util/service/request.service';
import { CreateWatchlistEntryComponent } from '../create-watchlist-entry/create-watchlist-entry.component';
import { NotiWatchlistComponent } from '../noti-watchlist/noti-watchlist.component';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {

  entrys = [];

  watchlist = {
    id : null,
    name: '',
    remarks : '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    errMsg : '',
    systemMsg : ''
  }

  entry = {
    stockName : '',
    stockSym: '',
    stockExchg : '',
    lastPrice : '',
    change : null,
    changePct : null,
    targetPrice : null,
    premiumDisc : null,
    remarks : ''
  }

  totalItems = 0;
  itemsPerPage = 20;
  p = 1;

  searchInput = "";
  watchId: number = null;

  sysMsg: string = '';
  errMsg: string = '';

  constructor(private router: Router,
              private dataService: DataService,
              private requestService: RequestService,
              private dialog: MatDialog,
              public dialogRef: MatDialogRef<WatchlistComponent>) {
  }

  ngOnInit(): void {
    console.log("init watchlist entry page");
    console.log(this.dataService.dataObj);
    if (this.dataService.dataObj && this.dataService.dataObj.entryForm) {
      this.entry = this.dataService.dataObj.entryForm;
      this.sysMsg = this.dataService.dataObj.entryForm.systemMsg;
    } else if (this.dataService.dataObj && this.dataService.dataObj.watchlist){
      this.sysMsg = this.dataService.dataObj.watchlist.systemMsg;
    }
    window.scroll(0,0);

    //this.dataService.setDataObj(null);
    this.watchlist = this.dataService.dataObj.watchlist;
    //console.log(this.entry);
    this.retrieveAllEntry(this.watchlist, 1);
  }

  insertEntry(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";

    this.dialog.open(CreateWatchlistEntryComponent, {
      width: '60%',
      height: '100%'
    }).afterClosed().subscribe( result=> {
        console.log("before ngOnInit");
        this.ngOnInit();
        console.log("after ngOnInit");
        console.log(this.dataService.dataObj);

        //window.scroll(0,0);
    });
  }

  retrieveAllEntry(watchlist, page){
    this.requestService.post('/watchlist/entry?page=' + page + '&size=' + this.itemsPerPage, watchlist).subscribe(
      data => {
        this.p = page;
        this.entrys = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  search(page, searchInput){
    this.watchId = this.watchlist.id;
    console.log(this.watchId);
    console.log(this.dataService.dataObj);
    this.requestService.post(`/watchlist/entry/search/${this.watchId}?page=` + page + '&size=' + this.itemsPerPage, searchInput).subscribe(
      data => {
        this.p = page;
        this.entrys = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  setNotification(entry, watchlist){
    this.dataService.setDataObj({entry: entry, watchlist: watchlist});

    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";

    this.dialog.open(NotiWatchlistComponent, {
      width: '100%',
      height: '100%'
    }).afterClosed().subscribe( result=> {
        console.log("before ngOnInit");
        console.log(this.dataService.dataObj);
        this.ngOnInit();
        console.log("after ngOnInit");
        console.log(this.dataService.dataObj);

        //window.scroll(0,0);
    });
  }

  back(){
    this.router.navigate(['/watchlistmain']);
  }
}
