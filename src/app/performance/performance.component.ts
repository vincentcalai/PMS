import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ChartType } from 'chart.js';
import { Label, MultiDataSet } from 'ng2-charts';
import { forkJoin } from 'rxjs';
import { concatMap, flatMap, map, mergeMap, tap } from 'rxjs/operators';
import { AuthenticateService } from '../util/service/authenticate.service';
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
  
  constructor(private requestService: RequestService, private dialog: MatDialog, public authenticateService: AuthenticateService) { }

  ngOnInit(): void {
    this.username = this.authenticateService.getAuthenticationUser();
    //init investment tab
    this.initInvestment();
    //init cash solution tab
    this.initCashSol();
  }

  initInvestment(){
    this.requestService.post('/performance/init',this.form)
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
        concatMap((res) => this.requestService.post('/performance/loadPerfTab',this.form))
      )
      .subscribe(res => {
        this.form = res as any;
            console.log('Second result' + this.form);
            console.log(this.form);
            
            this.portfolioPerformance = this.form.portfolioPerformance;
            this.etfPerformance = this.form.etfPerformance;
            this.stockPerformance = this.form.stockPerformance;
            this.gphyPerformance = this.form.gphyPerformance;
            //this.totalCash = this.form.bankBal;

            this.assetChartData = [
              [this.form.etfPerformance.currentVal, this.form.stockPerformance.currentVal]
            ];
            this.gphyChartData = [
              [this.form.gphyPerformance.usAllocation, this.form.gphyPerformance.hkAllocation, this.form.gphyPerformance.sgAllocation]
            ];

      });
  }

  initCashSol(){
    this.requestService.post('/performance/loadCashSol',this.form).subscribe(
      data => {
        this.form = data as any;
        this.totalCash = this.form.bankBal;
        this.totalWealth = this.form.bankAndInvest;
        
        console.log("total cash: " + this.totalCash );
        console.log("total wealth: " + this.totalWealth );
        this.cashSolChartData = [
          [this.form.bankBal, this.form.bankAndInvest-this.form.bankBal]
        ]
        console.log(this.form);
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
        this.gphyPerformance = this.form.gphyPerformance;
        //this.totalCash = this.form.bankBal;

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

  updateCash(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";

    this.dialog.open(UpdateCashBalComponent, {
      width: '60%',
      height: '100%'
    }).afterClosed().subscribe( result=> {
        console.log("before ngOnInit");
        this.initCashSol();
        console.log("after ngOnInit");
        //console.log(this.dataService.dataObj);

        //window.scroll(0,0);
    });
  }


}
