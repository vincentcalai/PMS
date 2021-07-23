import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DataService } from 'src/app/service/data.service';
import { RequestService } from 'src/app/service/request.service';
import { AuthenticateService } from '../../service/authenticate.service';
import { MessageDialogComponent } from '../message-dialog/message-dialog.component';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  loginUser: String = "";
  msgCount: number = 0;

  constructor(public authenticateService:AuthenticateService,
    private dataService: DataService,
    private requestService: RequestService,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.loginUser = this.authenticateService.getAuthenticationUser();
    this.retrieveUserMsgCnt(this.loginUser);
  }

  displayNoti(){
    console.log("displaying " + this.loginUser + "'s notification messages");

    const dialogRef = this.dialog.open(MessageDialogComponent, {
      width: '100%',
      height: '60%',
      data: {loginUser: this.loginUser}
    }).afterClosed().subscribe( result=> {
      this.ngOnInit();
      window.scroll(0,0);
    });;
  }

  retrieveUserMsgCnt(username: String) {
    this.requestService.post('/msg/retrievecnt', username).subscribe(
      data => {
        this.msgCount = data as any;
        console.log(this.msgCount);
      }
    )
  }
}
