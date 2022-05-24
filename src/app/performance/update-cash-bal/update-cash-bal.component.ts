import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
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
  }
  
  successMsg: string;
  errorMsg: string;

  constructor(private requestService: RequestService, private dialogRef: MatDialogRef<PerformanceComponent>) { }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onUpdate(cashBal): void {
    const map = {};
    map[this.mapKey] = cashBal;
    console.log(map);
    this.requestService.post('/performance/updateCashBal', map).subscribe(
      data => {
        this.form = data as any;
        this.successMsg = this.form.msg; 
        console.log(this.successMsg);
        console.log(this.form);
      }
    );
  }

}
