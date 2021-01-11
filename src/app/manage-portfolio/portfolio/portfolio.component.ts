import { DataService } from '../../service/data.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RequestService } from '../../service/request.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {

  portfolio = {
    id : null,
    portfolioName: '',
    createdBy : '',
    createdDate : null,
    lastMdfyBy : '',
    lastMdfyDt : null,
    remarks : '',
    errMsg : '',
    systemMsg : ''
  }

  mode = null;
  MODE_CREATE_PORT = 'createPort';
  MODE_UPDATE_PORT = 'updatePort';
  id: number;
  isNameDirty: string = '';
  message: string = '';
  errorMsg: string = '';

  constructor(private http:HttpClient,
    private requestService: RequestService,
    private dataService: DataService,
    private router:Router) { }

  ngOnInit(): void {
    console.log("isCreate: "+ this.dataService.dataObj.isCreate);

    if (this.dataService.dataObj && this.dataService.dataObj.isCreate === true){
      this.mode = this.MODE_CREATE_PORT;
      console.log("portfolio name: "+ this.portfolio.portfolioName);
    }else{
      this.mode = this.MODE_UPDATE_PORT;
      this.portfolio = this.dataService.dataObj.portfolioForm;
      console.log("portfolio id: "+ this.portfolio.id);
      console.log("portfolio name: "+ this.portfolio.portfolioName);
      console.log("portfolio remarks: "+ this.portfolio.remarks);
      console.log(this.portfolio);
    }
    console.log("mode: "+ this.mode);
  }

  isModeCreate() : boolean{
    return (this.mode == this.MODE_CREATE_PORT);
  }

  onSubmit(portfolioForm,mode){
    if(mode === true){
        this.requestService.post('/portfolio/add', portfolioForm).subscribe(
        data => {
          this.portfolio = data as any;
          this.dataService.setDataObj({ portfolioForm: this.portfolio})
          this.errorMsg = this.portfolio.errMsg;
          if(!this.errorMsg){
            this.router.navigate(['portfoliolist']);
          }
        }
      );
    }else{
      this.id = this.portfolio.id;

      portfolioForm.id = this.portfolio.id;
      portfolioForm.createdBy = this.portfolio.createdBy;
      portfolioForm.createdDate = this.portfolio.createdDate;

      console.log(this.portfolio);
      console.log(portfolioForm);

      // portfolioForm = this.portfolio;
      this.requestService.put(`/portfolio/update/${this.id}`, portfolioForm).subscribe(
        data => {
          this.portfolio = data as any;
          this.dataService.setDataObj({ portfolioForm: this.portfolio})
          this.errorMsg = this.portfolio.errMsg;
          if(!this.errorMsg){
            this.router.navigate(['portfoliolist']);
          }
        }
      );
    }
  }

  viewPort(id){
    console.log("view port id: " + id);
    this.dataService.setDataObj({ portfolioForm: this.portfolio })
    this.router.navigate(['portfolio', id, 'portfolioHold']);
  }

  updatePortTrans(id){
    console.log("update port trans id: " + id);
    console.log(this.portfolio);
    this.router.navigate(['portfolio', id, 'portfolioTrans']);
  }

}
