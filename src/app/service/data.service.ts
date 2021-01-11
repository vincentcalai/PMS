import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  public dataObj: any;

  constructor() { }

  public setDataObj(data): void{
    this.dataObj = data;
  }

}
