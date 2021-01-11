import { DataService } from '../../service/data.service';
import { RequestService } from '../../service/request.service';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : ''
  }

  transaction = {
    id : null,
    portId : null,
    stockName: '',
    stockSymbol: '',
    stockExchg: '',
    noOfShare: null,
    transPrice: null,
    totalAmt: null,
    action: '',
    createdBy : '',
    createdDt : null,
    remarks : '',
    systemMsg: '',
    errMsg:''
  }

  mktExchgs = [];

  ACTION_BUY = 'BUY';
  ACTION_SELL = 'SELL'
  actions = ['BUY','SELL'];
  isActionBuy: boolean = true;

  portId : number;
  totalAmtValue : number;

  currentStockHold: number;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private requestService: RequestService,
    private dataService: DataService,
    private location: Location
  ) {
    this.portId = route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.retrieveMktExchg();
    if (this.dataService.dataObj && this.dataService.dataObj.transaction) {
      this.transaction = this.dataService.dataObj.transaction;
      this.transaction.action = this.ACTION_SELL;
      this.isActionBuy = false;
      this.retrieveStockHold(this.transaction);
    } else{
      this.transaction.action = this.ACTION_BUY;
      this.isActionBuy = true;
    }
    console.log(this.transaction);
  }

  retrieveMktExchg(){
    this.requestService.get('/portfolio/transaction/mktexchg').subscribe(
      data => {
        this.mktExchgs = data as any;
        return this.mktExchgs;
      }
    );
  }

  retrieveStockHold(transaction){
    console.log("transaction:");
    console.log(this.transaction);
    this.requestService.post('/portfolio/transaction/stockhold', this.transaction).subscribe(
      data => {
        console.log(data);
        this.currentStockHold = data as any;
        this.transaction.noOfShare = this.currentStockHold;
        return this.currentStockHold;
      }
    );
  }

  retrieveStockInfo(transForm){

    console.log(transForm);
    this.requestService.post('/portfolio/retrieveStockInfo', transForm).subscribe(
      data => {
        this.transaction = data as any;
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

  calTotalAmt(transForm){
    this.totalAmtValue = transForm.value.noOfShare * transForm.value.transPrice;
  }

  onSubmit(transForm){
    transForm.stockSymbol = transForm.stockSymbol.trim();
    this.requestService.post(`/portfolio/transaction/add/${this.portId}`, transForm).subscribe(
      data => {
        this.transaction = data as any;
        if(!this.transaction.errMsg){
          this.dataService.setDataObj({addTransInd : true, portfolioForm: this.dataService.dataObj.portfolioForm, transaction:  this.transaction});
          this.router.navigate(['portfolio', this.portId, 'portfolioTrans']);
        }
      }
    );
  }

  cancel(){
    //this.router.navigate(['portfolio', this.portId, 'portfolioTrans']);
    this.location.back();
  }

}
