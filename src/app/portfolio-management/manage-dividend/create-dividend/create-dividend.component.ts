import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { DataService } from 'src/app/util/service/data.service';
import { RequestService } from 'src/app/util/service/request.service';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-dividend',
  templateUrl: './create-dividend.component.html',
  styleUrls: ['./create-dividend.component.css']
})
export class CreateDividendComponent implements OnInit {

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : ''
  }

  div = {
    id : null,
    portId : null,
    stockName: '',
    stockSym: '',
    stockExchg: '',
    noOfShare: null,
    datePurchase: null,
    dateSold: null,
    currHoldInd: false,
    sysMsg: '',
    errMsg:''
  }
  portId: number;
  maxDate: Date;
  dateValidationError: boolean = false;

  constructor(
    private router: Router,
    private requestService: RequestService,
    private dataService: DataService,
    private location: Location
  ) {
    this.maxDate = new Date();
  }

  ngOnInit(): void {
    this.portfolio = this.dataService.dataObj.portfolioForm;
  }

  retrieveStockInfo(divForm){
    this.requestService.post('/dividend/retrieveStockInfo', divForm).subscribe(
      data => {
        this.div = data as any;
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


  onSubmit(divForm){
    //Date Validation - purchase date must not be later than sold date
    if(divForm.dateSold < divForm.datePurchase || divForm.datePurchase > divForm.dateSold){
      this.dateValidationError = true;
      console.log( this.dateValidationError );
      return;
    }

    divForm.stockSym = divForm.stockSym.trim();
    divForm.portId = this.portfolio.id;

    this.requestService.post('/dividend/add', divForm).subscribe(
      data => {
        this.div = data as any;
        if(!this.div.errMsg){
          this.dataService.setDataObj({sysMsg: this.div.sysMsg, portfolio: this.portfolio});
          this.router.navigate(['div']);
        }
      }
    );
  }

  cancel(){
    this.location.back();
  }


}
