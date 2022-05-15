import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.css']
})
export class PerformanceComponent implements OnInit {

  form = {
    portfolioList: [],
    selectedPortfolio : '',
    errMsg: ''
  };
  requestService: any;

  constructor() { }

  ngOnInit(): void {
    this.initPage();
  }

  initPage(){
    this.requestService.post('/profitloss/init',this.form).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form);
      }
    )

  }

}
