import { RequestService } from '../../util/service/request.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../../util/service/data.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-portfolio-trans',
  templateUrl: './portfolio-trans.component.html',
  styleUrls: ['./portfolio-trans.component.css']
})
export class PortfolioTransComponent implements OnInit {
  transactions =[];
  mktExchgs = [];
  portId : number;
  addTransInd: boolean = false;
  sysMsg: string = '';
  errMsg: string = '';
  currency: Map<string,string>;

  searchInput = "";

  totalItems = 0;
  itemsPerPage = 10;
  p = 1;

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
    errMsg: ''
  }

  currentStockHold: number;

  columnSortBy: string;
  orderDesc: boolean = true;

  GEN_TRANS_REPORT_URL: string = "/genTransReport"

  constructor(
    private requestService:RequestService,
    private dataService:DataService,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location
  ) {
    this.portId = route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.portfolio = this.dataService.dataObj.portfolioForm;
    if (this.dataService.dataObj && this.dataService.dataObj.transaction) {
      this.sysMsg = this.dataService.dataObj.transaction.systemMsg;
      this.errMsg = this.dataService.dataObj.transaction.errMsg;
    }
    this.retrieveAllTrans(this.portId, this.p);
    this.currency = this.getCurr();
    this.dataService.setDataObj({ isCreate: false, portfolioForm: this.portfolio, currency: this.currency, transaction: null });
  }

  checkCurr(stockExchg){
    return this.currency.get(stockExchg) + '$';
  }

  getCurr() : Map<string,string> {
    let map = new Map();
    this.requestService.get('/portfolio/transaction/mktexchg').subscribe(
      data => {
        this.mktExchgs = data as any;
        for (const mktExchg of this.mktExchgs) {
            map.set(mktExchg.mktExchgName,mktExchg.curr)
         }
      }
    );
    return map;
  }

  retrieveAllTrans(portId, page){
    this.requestService.get(`/portfolio/transaction/${portId}?page=` + page + '&size=' + this.itemsPerPage).subscribe(
      data => {
        this.p = page;
        this.transactions = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  addPortfolioTransaction(){
    this.router.navigate(['portfolio', this.portId, 'transaction']);
  }

  sellPortfolioTrans(trans){
    this.dataService.dataObj.transaction = trans;
    this.router.navigate(['portfolio', this.portId, 'transaction']);
  }

  deletePortfolioTrans(id){
    if(!confirm("Are you sure to delete this transaction record?")) {
      return
    }
    this.requestService.delete(`/portfolio/transaction/delete/${id}`).subscribe(
      data => {
        this.transaction = data as any;
        this.sysMsg = this.transaction.systemMsg;
        this.retrieveAllTrans(this.portId,this.p);
      }
    );
  }

  genTransReport(id){
    this.requestService.downloadFile(id, this.GEN_TRANS_REPORT_URL);
  }

  search(portId, page, searchInput){
    this.requestService.post(`/portfolio/transaction/search/${portId}?page=` + page + '&size=' + this.itemsPerPage, searchInput).subscribe(
      data => {
        this.p = page;
        this.transactions = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  back(){
    this.dataService.setDataObj({ isCreate: false, portfolioForm: this.portfolio });
    this.router.navigate(['/portfolio',this.portfolio.id]);
  }

}
