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

  // handleLogin(){
  //   console.log("handleLogin username: " + this.username);
  //   if (this.authenticateService.authenticate(this.username,this.password) == true){
  //     console.log("login pass");
  //     this.dataService.setDataObj({username: this.username});
  //     this.router.navigate(['home']);
  //   }else{
  //     console.log("login fail");
  //     this.errorMsg = "Please enter a valid credential."
  //   }
  // }

  handleJWTAuthLogin(){
    console.log(this.username);
    this.authenticateService.jwtAuthenticate(this.username,this.password)
    .subscribe(
      data => {
        console.log(data);
        this.router.navigate(['home']);
        console.log("login pass");
        this.invalidLogin = false;
      },
      error => {
        console.log("login fail");
        this.errorMsg = "Please enter a valid credential. Login failed."
        this.invalidLogin = true;
      }
    )
  }

}
