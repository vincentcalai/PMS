
import { ProfitLossComponent } from './profit-loss/profit-loss.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { RouteGuard } from './common/guard/route.guard';
import { PortfoliolistComponent } from './manage-portfolio/portfoliolist/portfoliolist.component';
import { PortfolioComponent } from './manage-portfolio/portfolio/portfolio.component';
import { ErrorComponent } from './common/error/error.component';
import { PortfolioTransComponent } from './manage-portfolio/portfolio-trans/portfolio-trans.component';
import { TransactionComponent } from './manage-portfolio/transaction/transaction.component';
import { PortfolioHoldComponent } from './manage-portfolio/portfolio-hold/portfolio-hold.component';
import { LoadPortfolioComponent } from './load-portfolio/load-portfolio.component';
import { UserlistComponent } from './sysadmin/userlist/userlist.component';
import { UserComponent } from './sysadmin/user/user.component';
import { WatchlistListComponent } from './user-watchlist/watchlist-main/watchlist-list.component';
import { WatchlistComponent } from './user-watchlist/watchlist/watchlist.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate:[RouteGuard] },
  { path: 'user', component: UserComponent, canActivate:[RouteGuard] },
  { path: 'userlist', component: UserlistComponent, canActivate:[RouteGuard] },
  { path: 'portfolio', component: PortfolioComponent, canActivate:[RouteGuard] },
  { path: 'portfolio/:id', component: PortfolioComponent, canActivate:[RouteGuard] },
  { path: 'portfoliolist', component: PortfoliolistComponent, canActivate:[RouteGuard] },
  { path: 'portfolio/:id/portfolioHold', component: PortfolioHoldComponent, canActivate:[RouteGuard] },
  { path: 'portfolio/:id/portfolioTrans', component: PortfolioTransComponent, canActivate:[RouteGuard] },
  { path: 'portfolio/:id/transaction', component: TransactionComponent, canActivate:[RouteGuard] },
  { path: 'loadportfolio', component: LoadPortfolioComponent, canActivate:[RouteGuard] },
  { path: 'profitloss', component: ProfitLossComponent, canActivate:[RouteGuard] },
  { path: 'watchlistmain', component: WatchlistListComponent, canActivate:[RouteGuard] },
  { path: 'watchlist', component: WatchlistComponent, canActivate:[RouteGuard] },
  { path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
