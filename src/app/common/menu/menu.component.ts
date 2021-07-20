import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/service/request.service';
import { AuthenticateService } from '../../service/authenticate.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  loginUser: String;

  form = {
    msgId : 0,
    type : '',
    subject : '',
    msg : '',
    username : '',
    genDt : '',
  };

  constructor(public authenticateService:AuthenticateService,
    private requestService: RequestService,) { }

  ngOnInit(): void {
    this.loginUser = this.authenticateService.getAuthenticationUser();
  }

  displayNoti(){
    this.requestService.post('/profitloss/init',this.loginUser).subscribe(
      data => {
        this.form = data as any;
        console.log(this.form);
      }
    )
  }
}
