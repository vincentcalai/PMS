import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { DataService } from '../../util/service/data.service';
import { RequestService } from '../../util/service/request.service';
import { PerformanceComponent } from '../performance.component';

@Component({
  selector: 'app-update-cash-bal',
  templateUrl: './update-cash-bal.component.html',
  styleUrls: ['./update-cash-bal.component.css']
})
export class UpdateCashBalComponent implements OnInit {

  cashBal: number;
  readonly mapKey: string = 'key' ;

  form:{
    msg: string;
    errorMsg: string;
  }
  
  successMsg: string;
  errorMsg: string;

  origCashBal: number;

  constructor(private requestService: RequestService, 
    private dataService: DataService,
    private dialogRef: MatDialogRef<PerformanceComponent>) { }

  ngOnInit(): void {
    this.origCashBal = this.dataService.dataObj.totalCash;
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onUpdate(cashBal): void {
    cashBal = Math.round(cashBal * 100) / 100;

    const map = {};
    map[this.mapKey] = cashBal;
    console.log(map);
    this.requestService.post('/performance/updateCashBal', map).subscribe(
      data => {
        this.form = data as any;
        this.successMsg = this.form.msg; 
        this.errorMsg = this.form.errorMsg;
        if(this.successMsg && !this.errorMsg){
          this.origCashBal = cashBal;
        }
      }
    );
  }

  onlyNumAllowed(event) : boolean{
    const charCode = (event.which)?event.which: event.keyCode;
    if((charCode > 31 && charCode < 48 || charCode > 57) && charCode != 46){
      return false;
    }
    return true;
  }

}
