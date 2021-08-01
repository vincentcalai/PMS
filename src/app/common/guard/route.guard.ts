import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticateService } from '../../util/service/authenticate.service';

@Injectable({
  providedIn: 'root'
})

export class RouteGuard implements CanActivate {

  constructor(private authenticateService:AuthenticateService, private router:Router){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.authenticateService.isUserLoggedIn() == true){
        return true;
      }else{
        this.router.navigate(['']);
        return false;
      }

  }

}
