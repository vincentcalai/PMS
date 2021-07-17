import { RequestService } from '../service/request.service';
import { Component, OnInit } from '@angular/core';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-profit-loss',
  templateUrl: './profit-loss.component.html',
  styleUrls: ['./profit-loss.component.css']
})
export class ProfitLossComponent implements OnInit {

  form = {
    portfolioList: [],
    currList: [],
    selectedPortfolio : '',
    selectedPnlType: '',
    selectedCurr: '',
    unrealisedList: [],
    realisedList: [],
    unrealisedTotalList: null,
    realisedTotalList:null,
    errMsg: ''
  };

  pnlTypes = ["ALL", "REALISED", "UNREALISED"];

  absolutePL: number = null;
  selectedCurr: string = '';
  selectedPnlType: string = '';
  selectedPortfolio: string = '';

  realTotalCost: string = '';
  realTotalSoldValue: string = '';
  realConvTotalProfitLoss: string = '';
  realProfitLossPct: string = '';

  unrealTotalShareValue: string = '';
  unrealTotalMktValue: string = '';
  unrealConvTotalProfitLoss: string = '';
  unrealProfitLossPct: string = '';

  constructor(private requestService: RequestService,
    private decimalPipe: DecimalPipe) { }

  ngOnInit(): void {
    this.initPage();
  }

  initPage(){
    this.requestService.post('/profitloss/init',this.form).subscribe(
      data => {
        this.form = data as any;
        this.form.selectedPnlType = "ALL";
        this.form.selectedCurr = "SGD";
        console.log(this.form);
      }
    )

  }

  retrieve(form){
    console.log(form);
    this.requestService.post('/profitloss/retrieve',this.form).subscribe(
      data => {
        this.form = data as any;
        this.selectedCurr = this.form.selectedCurr;
        this.selectedPnlType = this.form.selectedPnlType;
        this.selectedPortfolio = this.form.selectedPortfolio;

        if(this.form.unrealisedTotalList){
          this.unrealTotalShareValue = this.selectedCurr +  "$" + this.decimalPipe.transform(this.form.unrealisedTotalList.totalAmt, '1.2-2');
          this.unrealTotalMktValue = this.selectedCurr +  "$" + this.decimalPipe.transform(this.form.unrealisedTotalList.mktValue, '1.2-2');
          this.unrealProfitLossPct = this.decimalPipe.transform(this.form.unrealisedTotalList.profitLossPct, '1.2-2') + "%";

          if(this.form.unrealisedTotalList.convProfitLoss > 0){
            this.unrealConvTotalProfitLoss = "+" + this.selectedCurr +  "$" + this.decimalPipe.transform(this.getAbsolutePL(this.form.unrealisedTotalList.convProfitLoss), '1.2-2');
          } else{
            this.unrealConvTotalProfitLoss = "-" + this.selectedCurr +  "$" + this.decimalPipe.transform(this.getAbsolutePL(this.form.unrealisedTotalList.convProfitLoss), '1.2-2');
          }

        }

        if(this.form.realisedTotalList){
          this.realTotalCost = this.selectedCurr +  "$" + this.decimalPipe.transform(this.form.realisedTotalList.totalCost, '1.2-2');
          this.realTotalSoldValue = this.selectedCurr +  "$" + this.decimalPipe.transform(this.form.realisedTotalList.totalSoldAmt, '1.2-2');
          this.realProfitLossPct = this.decimalPipe.transform(this.form.realisedTotalList.profitLossPct, '1.2-2') + "%";
          if(this.form.realisedTotalList.convProfitLoss > 0){
            this.realConvTotalProfitLoss = "+" + this.selectedCurr +  "$" + this.decimalPipe.transform(this.getAbsolutePL(this.form.realisedTotalList.convProfitLoss), '1.2-2');
          } else{
            this.realConvTotalProfitLoss = "-" + this.selectedCurr +  "$" + this.decimalPipe.transform(this.getAbsolutePL(this.form.realisedTotalList.convProfitLoss), '1.2-2');
          }
        }

        console.log(this.form);
      }
    )
  }

  getAbsolutePL(profitLoss): number{
    this.absolutePL = Math.abs(profitLoss);
     return this.absolutePL;
  }

  checkCurr(stockExchg){
    if(stockExchg === 'NYSE' || stockExchg === 'NASDAQ'){
      return 'USD$';
    }else if (stockExchg === 'HKEX'){
      return 'HKD$';
    }else if (stockExchg === 'SGX'){
      return 'SGD$';
    }else{
      return '$';
    }
  }
}
