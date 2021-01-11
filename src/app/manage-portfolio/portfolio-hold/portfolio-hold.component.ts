import { DataService } from '../../service/data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestService } from '../../service/request.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portfolio-hold',
  templateUrl: './portfolio-hold.component.html',
  styleUrls: ['./portfolio-hold.component.css']
})
export class PortfolioHoldComponent implements OnInit {
  stock = {
    id : null,
    stockName: '',
    stockSym: '',
    stockExchg: '',
    totalShare: null,
    avgPrice: null,
    totalAmt: null,
    lastTransPrice: 0,
    mktValue: 0,
    profitLoss: 0,
    profitLossPct: 0,
    lastTransBy : '',
    lastTransDt : null
  }

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : ''
  }

  stocks:[];
  mktExchgs = [];
  currency: Map<string,string>;

  portId: number;
  absolutePL: number;
  currentStockHold: number;

  GEN_HOLD_REPORT_URL: string = "/genHoldReport";

  constructor(private requestService:RequestService,
    private dataService: DataService,
    private route:ActivatedRoute,
    private router:Router
    ) {
      this.portId = route.snapshot.params['id'];
    }

  ngOnInit(): void {
    this.portfolio = this.dataService.dataObj.portfolioForm;
    this.currency = this.getCurr();
    this.requestService.get(`/portfolio/hold/${this.portId}`).subscribe(
      data => {
        this.stocks = data as any;
        console.log(this.stocks);
        return this.stocks;
      }
    );
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

  getAbsolutePL(profitLoss): number{
    this.absolutePL = Math.abs(profitLoss);
     return this.absolutePL;
  }

  // checkCurr(stockExchg){
  //   if(stockExchg === 'NYSE' || stockExchg === 'NASDAQ'){
  //     return 'USD$';
  //   }else if (stockExchg === 'HKEX'){
  //     return 'HKD$';
  //   }else if (stockExchg === 'SGX'){
  //     return 'SGD$';
  //   }else{
  //     return '$';
  //   }
  // }

  checkCurr(stockExchg){
    return this.currency.get(stockExchg) + '$';
  }

  sellPortfolioTrans(stock){
    this.dataService.dataObj.transaction = stock;
    this.dataService.dataObj.transaction.transPrice = stock.lastTransPrice;
    console.log("stock:");
    console.log(this.dataService.dataObj.transaction);
    this.router.navigate(['portfolio', this.portId, 'transaction']);
  }

  genHoldReport(id){
    this.requestService.downloadFile(id, this.GEN_HOLD_REPORT_URL);
  }

}
