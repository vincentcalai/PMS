import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from '../../service/authenticate.service';
import { DataService } from '../../service/data.service';

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

  constructor(private authenticateService:AuthenticateService,
    private dataService: DataService,
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
