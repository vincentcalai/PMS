import { CreateWatchlistEntryComponent } from './../create-watchlist-entry/create-watchlist-entry.component';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { RequestService } from 'src/app/service/request.service';
import { WatchlistComponent } from '../watchlist/watchlist.component';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

@Component({
  selector: 'app-noti-watchlist',
  templateUrl: './noti-watchlist.component.html',
  styleUrls: ['./noti-watchlist.component.css']
})
export class NotiWatchlistComponent implements OnInit {

  message: string = '';
  errorMsg: string = '';

  cbTrigger1 = false;
  cbTrigger2 = false;
  cbTrigger3 = false;

  cbUp5Pct = false;
  cbDown5Pct = false;
  cbUp10Pct = false;
  cbDown10Pct = false;
  cbCustomUpPct = false;
  cbCustomDownPct = false;

  form = {
    watchlist : {
      id : null,
      name: '',
      remarks : '',
      createdBy : '',
      createdDate : null,
      lastMdfyBy : '',
      lastMdfyDt : null,
      errMsg : '',
      systemMsg : ''
    },
    entry : {
      id : null,
      stockName : '',
      stockSym: '',
      stockExchg : '',
      lastPrice : '',
      change : null,
      changePct : null,
      targetPrice : null,
      premiumDisc : null,
      remarks : ''
    },
    watchlistNotification: {
      id: null,
      watchId: null,
      trigger1Ind: null,
      trigger1Price: null,
      trigger2Ind: null,
      trigger2Price: null,
      trigger3Ind: null,
      trigger3Price: null,
      up5PctInd: null,
      down5PctInd: null,
      up10PctInd: null,
      down10PctInd: null,
      customUpInd: null,
      customUpPct: null,
      customDownInd: null,
      customDownPct: null,
      discPremType: null,
      discPremPct: null,
      lastMdfyBy: null,
      lastMdfyDt: null
    },
    sysMsg : "",
    errMsg : ""
  };

  constructor(private requestService: RequestService,
              private dataService: DataService,
              private router: Router,
              public dialogRef: MatDialogRef<WatchlistComponent>) {
              }

  ngOnInit(): void {
    console.log("init notification page");
    this.form.entry = this.dataService.dataObj.entry;
    this.form.watchlist = this.dataService.dataObj.watchlist;

    this.requestService.post('/watchlist/noti/init', this.form).subscribe(data => {
      this.form = data as any;
      console.log(this.form);
      //this.form.watchlistNotification.trigger1Ind == 'Y' ?

      //convert checkbox value
      this.cbTrigger1 = this.form.watchlistNotification.trigger1Ind == 'Y' ? true : false;
      this.cbTrigger2 = this.form.watchlistNotification.trigger2Ind == 'Y' ? true : false;
      this.cbTrigger3 = this.form.watchlistNotification.trigger3Ind == 'Y' ? true : false;

      this.cbUp5Pct = this.form.watchlistNotification.up5PctInd == 'Y' ? true : false;
      this.cbDown5Pct = this.form.watchlistNotification.down5PctInd == 'Y' ? true : false;
      this.cbUp10Pct = this.form.watchlistNotification.up10PctInd == 'Y' ? true : false;
      this.cbDown10Pct = this.form.watchlistNotification.down10PctInd == 'Y' ? true : false;
      this.cbCustomUpPct = this.form.watchlistNotification.customUpInd == 'Y' ? true : false;
      this.cbCustomDownPct = this.form.watchlistNotification.customDownInd == 'Y' ? true : false;

      this.form.watchlistNotification.customDownPct = this.form.watchlistNotification.customDownPct == null ? null : Math.abs(this.form.watchlistNotification.customDownPct);
      this.form.watchlistNotification.discPremPct = this.form.watchlistNotification.discPremPct == null ? null : Math.abs(this.form.watchlistNotification.discPremPct);

    })

  }

  checkAll(event, type): void {
    if(event.checked){
      if(type === 'cbTrigger'){
        this.cbTrigger1 = true;
        this.cbTrigger2 = true;
        this.cbTrigger3 = true;
      } else{
        this.cbUp5Pct = true;
        this.cbDown5Pct = true;
        this.cbUp10Pct = true;
        this.cbDown10Pct = true;
        this.cbCustomUpPct = true;
        this.cbCustomDownPct = true;
      }
    } else{
      if(type === 'cbTrigger'){
        this.cbTrigger1 = false;
        this.cbTrigger2 = false;
        this.cbTrigger3 = false;
      } else{
        this.cbUp5Pct = false;
        this.cbDown5Pct = false;
        this.cbUp10Pct = false;
        this.cbDown10Pct = false;
        this.cbCustomUpPct = false;
        this.cbCustomDownPct = false;
      }
    }
  };

  onSubmit(entryForm){
    this.errorMsg = "";
    //convert checkbox value
    this.form.watchlistNotification.trigger1Ind = (this.cbTrigger1)? 'Y': 'N';
    this.form.watchlistNotification.trigger2Ind = (this.cbTrigger2)? 'Y': 'N';
    this.form.watchlistNotification.trigger3Ind = (this.cbTrigger3)? 'Y': 'N';

    this.form.watchlistNotification.up5PctInd = (this.cbUp5Pct) ? 'Y': 'N';
    this.form.watchlistNotification.down5PctInd = (this.cbDown5Pct) ? 'Y': 'N';
    this.form.watchlistNotification.up10PctInd = (this.cbUp10Pct) ? 'Y': 'N';
    this.form.watchlistNotification.down10PctInd = (this.cbDown10Pct) ? 'Y': 'N';
    this.form.watchlistNotification.customUpInd = (this.cbCustomUpPct) ? 'Y': 'N';
    this.form.watchlistNotification.customDownInd = (this.cbCustomDownPct) ? 'Y': 'N';

    console.log(this.form);
    this.validateForm(entryForm);
    if(!this.errorMsg){
      console.log("calling submit api...");
      console.log(entryForm);
      this.requestService.post('/watchlist/noti/update', this.form).subscribe(data => {
        console.log("done update noti..");
        this.form = data as any;
        console.log(this.form);

        this.form.watchlist.systemMsg = this.form.sysMsg;
        this.dataService.setDataObj({watchlist: this.form.watchlist});

        this.dialogRef.close();
      })
    }
  }

  deleteEntry(entry){
    if(confirm("Are you sure to delete this entry from this watchlist? All notification settings will be deleted.")){
      this.form.entry = entry;

      this.requestService.post('/watchlist/entry/delete', this.form).subscribe(data => {
        console.log("done delete");
        console.log(this.form);
        this.form.watchlist = data as any;
        this.dataService.setDataObj({watchlist: this.form.watchlist});
        console.log(this.dataService.dataObj);
        this.dialogRef.close();
      })
    }
  }

  onClose(){
    this.dialogRef.close();
  }

  validateForm(entryForm) {
    //checkbox ind 'Y' but input is null
    if(entryForm.trigger1Ind === true && entryForm.trigger1Price === null){
      this.errorMsg = "1st Trigger Price is empty. Please input a trigger price."
    } else if(entryForm.trigger2Ind === true && entryForm.trigger2Price === null){
      this.errorMsg = "2nd Trigger Price is empty. Please input a trigger price."
    } else if(entryForm.trigger3Ind === true && entryForm.trigger3Price === null){
      this.errorMsg = "3rd Trigger Price is empty. Please input a trigger price."
    } else if(entryForm.customUpInd === true && entryForm.customUpPct === null){
      this.errorMsg = "Custom (Up %) is empty. Please input a value."
    } else if(entryForm.customDownInd === true && entryForm.customDownPct === null){
      this.errorMsg = "Custom (Down %) is empty. Please input a value."
    } else if(entryForm.discPremType === "D" && entryForm.discPremPct === null){
      this.errorMsg = "Discount % is empty. Please input a value."
    } else if(entryForm.discPremType === "P" && entryForm.discPremPct === null){
      this.errorMsg = "Premium % is empty. Please input a value."
    }

    //invalid selection of trigger price
    else if(entryForm.trigger3Ind === true && (entryForm.trigger1Ind !== true || entryForm.trigger2Ind !== true)){
      this.errorMsg = "Invalid Trigger Price selected. Please select 1st or 2nd trigger price."
    } else if(entryForm.trigger2Ind === true && entryForm.trigger1Ind !== true){
      this.errorMsg = "Invalid Trigger Price selected. Please select 1st trigger price."
    }

    //invalid trigger price
    else if((entryForm.trigger1Ind === true && entryForm.trigger2Ind === true)
        && entryForm.trigger2Price >= entryForm.trigger1Price){
      this.errorMsg = "Invalid Trigger Price. 2nd Trigger Price must be lower than 1st Trigger Price."
    } else if((entryForm.trigger2Ind === true && entryForm.trigger3Ind === true)
        && entryForm.trigger3Price >= entryForm.trigger2Price){
      this.errorMsg = "Invalid Trigger Price. 3rd Trigger Price must be lower than 2nd Trigger Price."
    }

  }
}



