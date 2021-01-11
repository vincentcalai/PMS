
import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor{

  constructor(
    private authenticateService:AuthenticateService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler){

    let basicAuthHeaderString = this.authenticateService.getAuthenticationToken();
    let username = this.authenticateService.getAuthenticationUser();

    if(basicAuthHeaderString && username){
      request = request.clone({
        setHeaders: {
          Authorization : basicAuthHeaderString
        }
      })
    }
      return next.handle(request);


  }
}
