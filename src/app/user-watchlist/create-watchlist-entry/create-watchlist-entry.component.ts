import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { RequestService } from 'src/app/service/request.service';
import { WatchlistComponent } from '../watchlist/watchlist.component';

@Component({
  selector: 'app-create-watchlist-entry',
  templateUrl: './create-watchlist-entry.component.html',
  styleUrls: ['./create-watchlist-entry.component.css']
})
export class CreateWatchlistEntryComponent implements OnInit {

  watchlist = {
    id : null,
    name: '',
    remarks : '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null
  }
  
  entry = {
    id : null,
    watchId: null,
    stockName: '',
    stockSym: '',
    stockExchg: '',
    lastPrice: null,
    change: null,
    changePct: null,
    targetPrice: null,
    premiumDisc: null,
    remarks : '',
    lastMdfyBy : '',
    lastMdfyDt : null,
    errMsg : '',
    systemMsg : ''
  }

  message: string = '';
  errorMsg: string = '';

  watchId: number = null;

  constructor(private requestService: RequestService,
              private dataService: DataService,
              private router: Router,
              public dialogRef: MatDialogRef<WatchlistComponent>) { }

  ngOnInit(): void {
  }

  onSubmit(entryForm){
    console.log("onsubmit");
    console.log(this.dataService.dataObj);
    if(this.dataService.dataObj.watchlist && this.dataService.dataObj.watchlist.id){
      this.watchlist = this.dataService.dataObj.watchlist;
      this.watchId = this.dataService.dataObj.watchlist.id;
    } 
    entryForm.watchId = this.watchId;

    this.requestService.post('/watchlist/entry/add', entryForm).subscribe(
      data => {
        console.log("entryForm: ");
        console.log(entryForm);
        this.entry = data as any;
        this.dataService.setDataObj({ watchlist: this.watchlist, entryForm: this.entry});
        this.errorMsg = this.entry.errMsg;
        if(!this.entry.errMsg){
          this.dialogRef.close();
        }
      }
    );
  }

  onClose(): void {
    this.dialogRef.close();
  }

  retrieveStockInfo(entryForm){
    console.log(entryForm);
    this.requestService.post('/watchlist/entry/retrieveStockInfo', entryForm).subscribe(
      data => {
        this.entry = data as any;
      }
    );
  }
}
