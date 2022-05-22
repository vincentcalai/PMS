import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { PerformanceComponent } from '../performance.component';

@Component({
  selector: 'app-update-cash-bal',
  templateUrl: './update-cash-bal.component.html',
  styleUrls: ['./update-cash-bal.component.css']
})
export class UpdateCashBalComponent implements OnInit {

  cashBal: number;

  errorMsg: string = '';

  constructor(private dialogRef: MatDialogRef<PerformanceComponent>) { }

  ngOnInit(): void {
  }

  onClose(): void {
    this.dialogRef.close();
  }


}
