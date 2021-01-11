import { RequestService } from '../../service/request.service';
import { DataService } from '../../service/data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portfoliolist',
  templateUrl: './portfoliolist.component.html',
  styleUrls: ['./portfoliolist.component.css']
})

export class PortfoliolistComponent implements OnInit {

  portfolios: [];
  message: String = '';

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : '',
    systemMsg: ''
  }

  constructor(
    private requestService: RequestService,
    private dataService:DataService,
    private router: Router) { }

  ngOnInit(): void {
    if (this.dataService.dataObj && this.dataService.dataObj.portfolioForm) {
      this.message = this.dataService.dataObj.portfolioForm.systemMsg;
    }
    this.retrieveAllPortfolio();
    this.dataService.setDataObj(null);
  }

  retrieveAllPortfolio(){
    this.requestService.get('/portfolio').subscribe(
      data => {
        this.portfolios = data as any;
        return this.portfolios;
      }
    );
  }

  addPortfolio(){
    this.dataService.setDataObj({isCreate : true, portfolioForm : null});
    this.router.navigate(['portfolio']);
  }

  updatePortfolio(portfolio){
    this.dataService.setDataObj({isCreate : false, portfolioForm : portfolio});
    this.router.navigate(['portfolio', portfolio.id]);
  }

  deletePortfolio(id){
    if(!confirm("Are you sure to delete this portfolio? All transactions for this portfolio will be deleted.")) {
      return
    }
    this.requestService.delete(`/portfolio/delete/${id}`).subscribe(
      data => {
        this.portfolio = data as any;
        console.log(this.portfolio.systemMsg);
        this.message = this.portfolio.systemMsg;
        this.retrieveAllPortfolio();
      }
    );
  }
}
