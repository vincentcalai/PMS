import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ChartType } from 'chart.js';
import { Label, MultiDataSet } from 'ng2-charts';
import { forkJoin } from 'rxjs';
import { concatMap, flatMap, map, mergeMap, tap } from 'rxjs/operators';
import { AuthenticateService } from '../util/service/authenticate.service';
import { DataService } from '../util/service/data.service';
import { RequestService } from '../util/service/request.service';
import { UpdateCashBalComponent } from './update-cash-bal/update-cash-bal.component';

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
    gphyPerformance: {
      usAllocation: 0,
      hkAllocation: 0,
      sgAllocation: 0
    },
    bankBal: 0,
    bankAndInvest: 0,
    errMsg: ''
  };
  
  
  investForm = {
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
    gphyPerformance: {
      usAllocation: 0,
      hkAllocation: 0,
      sgAllocation: 0
    },
    bankBal: 0,
    bankAndInvest: 0,
    errMsg: ''
  };

  cashSolForm = {
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
    gphyPerformance: {
      usAllocation: 0,
      hkAllocation: 0,
      sgAllocation: 0
    },
    bankBal: 0,
    bankAndInvest: 0,
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

  gphyPerformance= {
    usAllocation: 0,
    hkAllocation: 0,
    sgAllocation: 0
  }

  portfolioPerformance = {
    investAmt: 0,
    currentVal: 0,
    profit: 0,
    profitPct: 0
  };

  selectedPortfolio: string;
  absoluteVal: number;

  assetChartLabels: Label[] = ['ETF', 'Stock'];
  assetChartData: MultiDataSet = [
    []
  ];
  assetChartType: ChartType = 'doughnut';

  gphyChartLabels: Label[] = ['US', 'HK', 'SG'];
  gphyChartData: MultiDataSet = [
    []
  ];
  gphyChartType: ChartType = 'doughnut';

  cashSolChartLabels: Label[] = ['Cash', 'Investments'];
  cashSolChartData: MultiDataSet = [
    []
  ];
  cashSolChartType: ChartType = 'pie';

  doughnutChartColors: Array<any> = [ { backgroundColor: ['#6CA0DC', '#FF6961', ' #77DD77'], borderColor: 'transparent' } ];

  username: string= '';
  totalCash: number = 0;
  totalWealth: number = 0;
  
  constructor(private requestService: RequestService, 
    private dataService: DataService, 
    private dialog: MatDialog, 
    public authenticateService: AuthenticateService) { 

    }

  ngOnInit(): void {
    this.username = this.authenticateService.getAuthenticationUser();

    let initInvestAPI = this.initInvestment();
    let initCashSolAPI = this.initCashSol();

    //parallel loading of Investment and Cash Solution tabs
    forkJoin([initInvestAPI,initCashSolAPI]).subscribe(results => {
      console.log(results);
        this.investForm = results[0] as any;
        this.cashSolForm = results[1] as any;
        console.log('Second result in forkJoin: ');
        console.log(this.investForm);
        console.log(this.cashSolForm);
        
        //init investment tab
        this.portfolioPerformance = this.investForm.portfolioPerformance;
        this.etfPerformance = this.investForm.etfPerformance;
        this.stockPerformance = this.investForm.stockPerformance;
        this.gphyPerformance = this.investForm.gphyPerformance;

        this.assetChartData = [
          [this.investForm.etfPerformance.currentVal, this.investForm.stockPerformance.currentVal]
        ];
        this.gphyChartData = [
          [this.investForm.gphyPerformance.usAllocation, this.investForm.gphyPerformance.hkAllocation, this.investForm.gphyPerformance.sgAllocation]
        ];
        
        //init cash solution tab
        this.totalCash = this.cashSolForm.bankBal;
        this.totalWealth = this.cashSolForm.bankAndInvest;
        
        console.log("total cash: " + this.totalCash );
        console.log("total wealth: " + this.totalWealth );
        this.cashSolChartData = [
          [this.cashSolForm.bankBal, this.cashSolForm.bankAndInvest-this.cashSolForm.bankBal]
        ]

    });
    
  }

  initInvestment(){
    console.log("executing initInvestment");
    //init Selected Portfolio to be first in Portfolio List
    return this.requestService.post('/performance/init',this.form)
      .pipe(
        tap(res => {
          console.log('First result', res);
          this.form = res as any;

          if(this.form.portfolioList != null && this.form.portfolioList.length != 0){
            this.selectedPortfolio = this.form.portfolioList[0];
          }

          console.log("selected portfolio: " + this.selectedPortfolio);
          this.form.selectedPortfolio = this.selectedPortfolio;
        }),
        //observable of Investment tab to be in forkJoin above
        concatMap((res) => this.requestService.post('/performance/loadInvest',this.form))
      )
  }

  initCashSol(){
    //observable of Cash Solution in forkJoin above
    console.log("executing initCashSol");
    return this.requestService.post('/performance/loadCashSol',this.form);
  }

  loadInvest(selectedPortfolio: string) {
    this.form.selectedPortfolio = this.selectedPortfolio;
    this.requestService.post('/performance/loadInvest',this.form).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form);
        this.portfolioPerformance = this.form.portfolioPerformance;
        this.etfPerformance = this.form.etfPerformance;
        this.stockPerformance = this.form.stockPerformance;
        this.gphyPerformance = this.form.gphyPerformance;

        this.assetChartData = [
          [this.form.etfPerformance.currentVal, this.form.stockPerformance.currentVal]
        ];
        this.gphyChartData = [
          [this.form.gphyPerformance.usAllocation, this.form.gphyPerformance.hkAllocation, this.form.gphyPerformance.sgAllocation]
        ];
        
      }
    );
  }

  getAbsoluteVal(value): number{
    this.absoluteVal = Math.abs(value);
     return this.absoluteVal;
  }

  updateCash(totalCash){
    console.log("original total cash: " + totalCash);
    this.dataService.setDataObj({totalCash: totalCash});

    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";

    this.dialog.open(UpdateCashBalComponent, {
      width: '60%',
      height: '100%'
    }).afterClosed().subscribe( result=> {
        this.ngOnInit();
    });
  }


}
