import { DataService } from '../../util/service/data.service';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { RequestService } from 'src/app/util/service/request.service';
import { WatchlistComponent } from '../watchlist/watchlist.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-watchlist',
  templateUrl: './create-watchlist.component.html',
  styleUrls: ['./create-watchlist.component.css']
})
export class CreateWatchlistComponent implements OnInit {

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

  message: string = '';
  errorMsg: string = '';

  constructor(private requestService: RequestService,
              private dataService: DataService,
              private router: Router,
              public dialogRef: MatDialogRef<WatchlistComponent>) { }

  ngOnInit(): void {
  }


  onSubmit(watchlistForm){
    this.requestService.post('/watchlist/add', watchlistForm).subscribe(
      data => {
        console.log(watchlistForm);
        this.watchlist = data as any;
        this.dataService.setDataObj({ watchlistForm: this.watchlist});
        this.errorMsg = this.watchlist.errMsg;
        if(!this.watchlist.errMsg){
          this.dialogRef.close();
          //parent.location.reload();
          //this.router.navigate(['watchlistmain']);
        }
      }
    );
  }

  onClose(): void {
    this.dialogRef.close();
  }
}
