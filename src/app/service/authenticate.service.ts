import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';

export const AUTH_USER = 'authenticateUser';
export const TOKEN = 'token';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  isLogin: boolean = false;

  constructor(private http: HttpClient) { }

  // authenticate(username, password){
  //   console.log("authentication service username: " + username);
  //   if(username === "choonann" && password === "pass1234"){
  //     sessionStorage.setItem('authenticateUser', username);
  //     return true
  //   }else{
  //     return false;
  //   }
  // }

  jwtAuthenticate(username, password){

    console.log("calling api..");
    return this.http.post<any>("http://localhost:8080/authenticate",{
      username,
      password
    })
    .pipe(
      map(
        data => {
          sessionStorage.setItem(AUTH_USER, username);
          sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
          return data;
        }
      )
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
      sessionStorage.removeItem(AUTH_USER);
      sessionStorage.removeItem(TOKEN);
    }
  }
}
