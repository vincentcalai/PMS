import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { DataService } from '../../util/service/data.service';
import { RequestService } from '../../util/service/request.service';
import { PerformanceComponent } from '../performance.component';

@Component({
  selector: 'app-update-other-asset',
  templateUrl: './update-other-asset.component.html',
  styleUrls: ['./update-other-asset.component.css']
})

export class UpdateOtherAssetComponent implements OnInit {

  otherAsset: number;
  readonly mapKey: string = 'key' ;

  form : {
    msg: string;
    errorMsg: string;
  }

  successMsg: string;
  errorMsg: string;

  origOtherAsset: number;

  constructor(private requestService: RequestService, 
    private dataService: DataService,
    private dialogRef: MatDialogRef<PerformanceComponent>) { }

  ngOnInit(): void {
    this.origOtherAsset = this.dataService.dataObj.otherAsset;
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onUpdate(otherAsset): void {
    otherAsset = Math.round(otherAsset * 100) / 100;

    const map = {};
    map[this.mapKey] = otherAsset;
    console.log(map);
    this.requestService.post('/performance/updateOtherAsset', map).subscribe(
      data => {
        this.form = data as any;
        this.successMsg = this.form.msg; 
        this.errorMsg = this.form.errorMsg;
        if(this.successMsg && !this.errorMsg){
          this.origOtherAsset = otherAsset;
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
