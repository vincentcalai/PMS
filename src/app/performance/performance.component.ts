import { Component, OnInit } from '@angular/core';
import { RequestService } from '../util/service/request.service';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.css']
})
export class PerformanceComponent implements OnInit {

  form = {
    portfolioList: [],
    selectedPortfolio : '',
    portfolioPerformance: {
      investAmt: 0,
      currentVal: 0,
      profit: 0,
      profitPct: 0
    },
    etfPerformance: {
      name: "Stock Equity",
      investAmt: 0,
      currentVal: 0,
      profit: 0,
      profitPct: 0
    },
    stockPerformance: {
      name: "Stock Equity",
      investAmt: 0,
      currentVal: 0,
      profit: 0,
      profitPct: 0
    },
    errMsg: ''
  };

  etfPerformance = {
    name: "ETF",
    investAmt: 0,
    currentVal: 0,
    profit: 0,
    profitPct: 0
  };

  stockPerformance = {
    name: "Stock Equity",
    investAmt: 0,
    currentVal: 0,
    profit: 0,
    profitPct: 0
  };

  portfolioPerformance = {
    investAmt: 0,
    currentVal: 0,
    profit: 0,
    profitPct: 0
  };

  selectedPortfolio: string;
  absoluteVal: number;

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.initPage();
  }

  initPage(){
    this.requestService.post('/performance/init',this.form).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form);
        if(this.form.portfolioList != null && this.form.portfolioList.length != 0){
          this.selectedPortfolio = this.form.portfolioList[0];
        }
        this.loadPerfTab(this.selectedPortfolio);
      }
    );
  }

  loadPerfTab(selectedPortfolio: string) {
    this.form.selectedPortfolio = this.selectedPortfolio;
    this.requestService.post('/performance/loadPerfTab',this.form).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form);
        this.portfolioPerformance = this.form.portfolioPerformance;
        this.etfPerformance = this.form.etfPerformance;
        this.stockPerformance = this.form.stockPerformance;
        console.log(this.portfolioPerformance);
      }
    );
  }

  getAbsoluteVal(value): number{
    this.absoluteVal = Math.abs(value);
     return this.absoluteVal;
  }


}
