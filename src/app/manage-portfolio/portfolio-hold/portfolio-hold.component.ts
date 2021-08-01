import { DataService } from '../../util/service/data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestService } from '../../util/service/request.service';
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

  totalItems = 0;
  itemsPerPage = 10;
  p = 1;

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
    this.retrieveAllHolds(this.portId, this.p);
  }

  retrieveAllHolds(portId, page){
    this.requestService.get(`/portfolio/hold/${portId}?page=` + page + '&size=' + this.itemsPerPage).subscribe(
      data => {
        this.p = page;
        this.stocks = (data as any).content;
        this.totalItems = (data as any).totalElements;
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
