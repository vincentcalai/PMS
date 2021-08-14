
import { ProfitLossComponent } from './profit-loss/profit-loss.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { RouteGuard } from './common/guard/route.guard';
import { ErrorComponent } from './common/error/error.component';
import { LoadPortfolioComponent } from './data-loading/load-portfolio/load-portfolio.component';
import { UserlistComponent } from './sysadmin/userlist/userlist.component';
import { UserComponent } from './sysadmin/user/user.component';
import { WatchlistListComponent } from './user-watchlist/watchlist-main/watchlist-list.component';
import { WatchlistComponent } from './user-watchlist/watchlist/watchlist.component';
import { LoadDividendComponent } from './data-loading/load-dividend/load-dividend.component';
import { CreateDividendComponent } from './portfolio-management/manage-dividend/create-dividend/create-dividend.component';
import { DividendComponent } from './portfolio-management/manage-dividend/dividend/dividend.component';
import { PortfolioHoldComponent } from './portfolio-management/manage-portfolio/portfolio-hold/portfolio-hold.component';
import { PortfolioTransComponent } from './portfolio-management/manage-portfolio/portfolio-trans/portfolio-trans.component';
import { PortfolioComponent } from './portfolio-management/manage-portfolio/portfolio/portfolio.component';
import { PortfoliolistComponent } from './portfolio-management/manage-portfolio/portfoliolist/portfoliolist.component';
import { TransactionComponent } from './portfolio-management/manage-portfolio/transaction/transaction.component';


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
  { path: 'div', component: DividendComponent, canActivate:[RouteGuard] },
  { path: 'creatediv/:id', component: CreateDividendComponent, canActivate:[RouteGuard] },
  { path: 'loaddiv', component: LoadDividendComponent, canActivate:[RouteGuard] },
  { path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
