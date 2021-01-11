import { AuthenticateService } from './../../service/authenticate.service';
import { RequestService } from '../../service/request.service';
import { DataService } from '../../service/data.service';
import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string = '';

  indexes = [];
  forexes = [];

  form ={
    indexList: [],
    forexList :[]
  }

  index = {
    id: null,
    idxSym : '',
    idxName: '',
    last: null,
    change: null,
    changePct: null,
    lastUpdatedDt: null
  }

  forex = {
    id: null,
    forexName:'',
    forexSymbol: '',
    forexDesc: '',
    rate: null,
    change: null,
    changePct: null,
    lastUpdatedDt: null
  }

  constructor(private requestService:RequestService, private dataService:DataService,
    private authenticateService:AuthenticateService) { }

  ngOnInit(): void {
    this.requestService.get('/home').subscribe(
      data => {
        this.form = data as any;
        this.indexes = this.form.indexList;
        this.forexes = this.form.forexList;
      }
    );
    this.username = this.authenticateService.getAuthenticationUser();
    //this.username = this.dataService.dataObj.username;
  }

}
