import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/util/service/data.service';
import { RequestService } from 'src/app/util/service/request.service';
import { AuthenticateService } from '../../util/service/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  errorMsg: string = "";
  invalidLogin: boolean = false;
  msgCount: number = 0;


  constructor(private authenticateService:AuthenticateService,
    private dataService: DataService,
    private requestService: RequestService,
    private router:Router) { }

  ngOnInit(): void {
  }

  handleJWTAuthLogin(){
    this.authenticateService.jwtAuthenticate(this.username,this.password)
    .subscribe(
      data => {
        console.log(data);
        this.router.navigate(['home']);
        console.log("login pass");
        this.invalidLogin = false;
        if(!this.invalidLogin){
          this.authenticateService.getLoginUserRoles(this.username);
        }
      },
      error => {
        console.log("login fail");
        this.errorMsg = "Please enter a valid credential. Login failed."
        this.invalidLogin = true;
      }
    )
  }  

}
