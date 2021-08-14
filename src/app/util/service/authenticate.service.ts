import { RequestService } from './request.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import { Router } from '@angular/router';

export const AUTH_USER = 'authenticateUser';
export const TOKEN = 'token';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  public roles : string[] = [];

  api_url: String = "http://localhost:8080";

  username: String;

  constructor(private http: HttpClient, private router: Router, 
    private requestService: RequestService) { }

  jwtAuthenticate(username, password){

    console.log("calling api..");
    return this.http.post<any>( this.api_url + "/authenticate",{
      username,
      password
    })
    .pipe(
      map(
        data => {
          sessionStorage.setItem(AUTH_USER, username);
          sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
          console.log(data);
          return data;
        }
      )
    );
  }

  getLoginUserRoles(username){
    this.requestService.post('/user/roles', username).subscribe(
      data => {
        this.roles = data as any;
      }
    );
  }

  isUserLoggedIn(){
    let user =  sessionStorage.getItem(AUTH_USER);
    return !(user === null);
  }

  getAuthenticationUser(){
    return sessionStorage.getItem(AUTH_USER);
  }

  getAuthenticationToken(){
    if(this.getAuthenticationUser()){
      return sessionStorage.getItem(TOKEN);
    }
  }

  logout(){
    if(confirm("Are you sure to logout?")) {
      console.log("logout ok");
      this.roles = null;
      sessionStorage.removeItem(AUTH_USER);
      sessionStorage.removeItem(TOKEN);
      this.router.navigate(['/']);
    }
  }
}
