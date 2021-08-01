import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RequestService } from 'src/app/util/service/request.service';

@Component({
  selector: 'app-message-dialog',
  templateUrl: './message-dialog.component.html',
  styleUrls: ['./message-dialog.component.css']
})
export class MessageDialogComponent implements OnInit {

  messages = [];

  loginUser: String = '';

  message = {
    msgId : 0,
    type : '',
    subject : '',
    msg : '',
    username : '',
    genDt : '',
  };

  constructor(
    private requestService: RequestService,
    dialogRef: MatDialogRef<MessageDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  
  ngOnInit(): void {
    this.loginUser = this.data.loginUser;
    console.log(this.loginUser);
    this.retrieveMsg(this.loginUser);
    this.softDelReadMsg(this.loginUser);
  }

  retrieveMsg(loginUser: String){
    this.requestService.post('/msg/retrieve',this.loginUser).subscribe(
      data => {
        this.messages = data as any;
      }
    )
  };

  softDelReadMsg(loginUser: String){
    this.requestService.post('/msg/softDelReadMsg',this.loginUser).subscribe();
  };

  deleteAllMsg(loginUser: String){
    if(!confirm("Are you sure to delete all notification messages?")) {
      return
    }
    this.requestService.post('/msg/deleteAllMsg',this.loginUser).subscribe( 
    result =>
      {
        this.ngOnInit();
      });
  };

}
