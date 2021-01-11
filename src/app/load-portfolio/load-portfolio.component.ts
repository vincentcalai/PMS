import { RequestService } from './../service/request.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import * as fileSaver from 'file-saver';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-load-portfolio',
  templateUrl: './load-portfolio.component.html',
  styleUrls: ['./load-portfolio.component.css']
})
export class LoadPortfolioComponent implements OnInit {

  files:[];

  form = {
    fileUploadList: [],
    portfolioList: [],
    portfolioName : ''
  };

  selectedPort:string = '';

  errMsg:string = '';
  sysMsg:string = '';

  fileToUpload: File = null;

  UPLOADED_FILE_URL:string = "/downloadFile";
  LOG_FILE_URL: string = "/downloadLogFile";


  @ViewChild('inputFile') inputFile: any;

  constructor(private requestService:RequestService) { }

  ngOnInit(): void {
    this.initPage();
  }

  getUploadList(){
    console.log("portfolioName: " + this.form.portfolioName);
    this.requestService.post('/loadportfolio/getUploadList',this.form).subscribe(
      data => {
        this.form.fileUploadList = data as any;
        console.log(this.form.fileUploadList);
      }
    )
  }

  initPage(){
    this.errMsg = '';
    this.sysMsg = '';
    console.log("portfolioName init: " + this.form.portfolioName);
    this.requestService.post('/loadportfolio/init',this.form).subscribe(
      data => {
        this.form.portfolioList = data as any;
        console.log(this.form.portfolioList);
      }
    )
    this.getUploadList();
  }

  downloadTemplate(){
    this.requestService.downloadTmplt('LoadPortfolioTemplate.xlsx')
  }

  downloadUploadedFile(fileId){
    this.requestService.downloadFile(fileId, this.UPLOADED_FILE_URL);
  }

  downloadLogFile(fileId){
    this.requestService.downloadFile(fileId, this.LOG_FILE_URL);
  }

  selectFile(files: FileList) {
    this.fileToUpload = files.item(0);
  }

  delete(): void {
    console.log(this.form.fileUploadList);
    var checklist = this.form.fileUploadList.filter(r => r.selectInd);
    console.log(checklist);

    if (!checklist || checklist.length == 0) {
      alert('Please select at least one item!');
      return;
    }

    var obj = {
      deleteList: checklist
    }

    console.log(obj);

    if (confirm("Are you sure to delete the selected records?")){
      this.requestService.post('/loadportfolio/delete', obj).subscribe(data => {
        this.getUploadList();
      })
    }
  }

  checkAll(event, checkInd, arr): void {
    if (!arr || arr.length == 0) {
      return;
    }

    arr.forEach(x => x[checkInd] = event.checked)
  };

  submit(selectedPort){
    if(!this.fileToUpload){
      this.errMsg = 'Please attached a file to upload.'
      return;
    }

    if(selectedPort === ''){
      this.errMsg = 'Please select a Portfolio to upload.'
      return;
    }

    this.form.portfolioName = selectedPort;
    console.log("selectedPort: " + selectedPort);
    this.requestService.uploadFile(this.fileToUpload, '/loadportfolio/uploadFile', this.form).subscribe(
      event => {
        if (event.type == HttpEventType.UploadProgress) {

        } else if (event instanceof HttpResponse) {
          console.log(event);
          var obj = JSON.parse(event.body as any);
          this.errMsg = obj.errMsg;
          this.sysMsg = obj.sysMsg;
          console.log(JSON.stringify(obj));
          console.log("errMsg: " + obj.errMsg);
          console.log('File is completely loaded successfully');
        }
      },
      (err) => {
        console.log("Upload Error:", err);
      }, () => {
        console.log("Upload done");
      }
    );

    this.fileToUpload = undefined;
    this.inputFile.nativeElement.value = '';
  }

}
