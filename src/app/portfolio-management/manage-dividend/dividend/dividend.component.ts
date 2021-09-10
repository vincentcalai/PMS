import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/util/service/data.service';
import { RequestService } from 'src/app/util/service/request.service';
import {MatAccordion} from '@angular/material/expansion';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSort, MatSortModule} from '@angular/material/sort';

@Component({
  selector: 'app-dividend',
  templateUrl: './dividend.component.html',
  styleUrls: ['./dividend.component.css']
})

export class DividendComponent implements OnInit {

  id: number;
  totalDividend: string;
  totalYearDividend = new Map();

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : ''
  };

  divDet = { 
      id: '',
      divId: '', 
      portId: '',
      stockName: '',
      stockSym: '',
      stockExchg: '',
      exDate: '',
      noOfShare: '',
      adjVal: '',
      divPayout: '',
      sgdDivPayout: ''
  };
    
  form = {
    portfolioList: [],
    selectedPortfolio : this.portfolio,
    divDetList: new Map([['', []]]),
    totalDiv: '',
    totalDivDetList: new Map([['', 0]]),
    sysMsg: '',
    errMsg: ''
  };

  mktExchgs = [];
  currency: Map<string,string>;
  divDetList: [];
  columnsToDisplay = ['id', 'stockName', 'stockSym', 'stockExchg', 'noOfShare','exDate' ,'adjDiv', 'divPayout', 'sgdDivPayout'];
  

  constructor(private requestService: RequestService, 
    private dataService: DataService,
    private router: Router) { }

  ngOnInit(): void {
    
    if(this.dataService.dataObj && this.dataService.dataObj.sysMsg && this.dataService.dataObj.portfolio){
      this.form.sysMsg = this.dataService.dataObj.sysMsg;
      this.form.selectedPortfolio = this.dataService.dataObj.portfolio
    }
    
    this.currency = this.getCurr();
    this.initPage();
    
  }

  initPage(){
    this.requestService.post('/dividend/init',this.form).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form.selectedPortfolio.id);
        if(this.form.selectedPortfolio.id){
          this.retrievePortfolioDiv(this.form);
        }
      }
    )
  }

  getCurr() : Map<string,string> {
    let map = new Map();
    this.requestService.get('/portfolio/hold/mktexchg').subscribe(
      data => {
        this.mktExchgs = data as any;
        for (const mktExchg of this.mktExchgs) {
            map.set(mktExchg.mktExchgName,mktExchg.curr)
         }
      }
    );
    return map;
  }

  checkCurr(stockExchg){
    return this.currency.get(stockExchg) + '$';
  }

  compareFn(c1: any, c2:any): boolean {     
    return c1 && c2 ? c1.id === c2.id : c1 === c2;  
  }

  createDiv(form){
    if (form.selectedPortfolio.id == null){
      this.form.errMsg = "Please select a portfolio."
    } else {
      this.dataService.setDataObj({ portfolioForm: form.selectedPortfolio });
      this.router.navigate(['creatediv', form.selectedPortfolio.id]);
    }
  }

  retrievePortfolioDiv(form){
    if(form.selectedPortfolio.id){
      this.requestService.post('/dividend/retrievePortDiv', form).subscribe(
        data => {
          this.form = data as any;
          console.log(this.form);
          if(this.form.totalDiv != null){
            this.totalDividend = "SGD$" + this.form.totalDiv;
          } else{
            this.totalDividend = "SGD$0";
          }
        
          for (let [key,value] of Object.entries(this.form.totalDivDetList)) {
            this.totalYearDividend.set(key, "SGD$" + value);        
          } 
        }
      );
    }
  }

}
