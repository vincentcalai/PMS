import { RouteGuard } from './guard/route.guard';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './common/login/login.component';
import { MenuComponent } from './common/menu/menu.component';
import { HomeComponent } from './common/home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { PortfoliolistComponent } from './manage-portfolio/portfoliolist/portfoliolist.component';
import { PortfolioComponent } from './manage-portfolio/portfolio/portfolio.component';
import { ErrorComponent } from './common/error/error.component';
import { PortfolioTransComponent } from './manage-portfolio/portfolio-trans/portfolio-trans.component';
import { TransactionComponent } from './manage-portfolio/transaction/transaction.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatSelectModule } from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { PortfolioHoldComponent } from './manage-portfolio/portfolio-hold/portfolio-hold.component';
import { LoadPortfolioComponent } from './load-portfolio/load-portfolio.component';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { HttpInterceptorBasicAuthService } from './service/http-interceptor-basic-auth.service';
import { ProfitLossDashboardComponent } from './profit-loss-dashboard/profit-loss-dashboard.component';
import { DecimalPipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    HomeComponent,
    PortfoliolistComponent,
    PortfolioComponent,
    ErrorComponent,
    PortfolioTransComponent,
    TransactionComponent,
    PortfolioHoldComponent,
    LoadPortfolioComponent,
    ProfitLossDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatIconModule
  ],
  providers: [
    RouteGuard,
    DecimalPipe,
    {provide: HTTP_INTERCEPTORS, useClass:HttpInterceptorBasicAuthService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
