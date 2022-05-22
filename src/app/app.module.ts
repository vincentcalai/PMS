import { RouteGuard } from './common/guard/route.guard';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './common/login/login.component';
import { MenuComponent } from './common/menu/menu.component';
import { HomeComponent } from './common/home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { ErrorComponent } from './common/error/error.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatSelectModule } from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { LoadPortfolioComponent } from './data-loading/load-portfolio/load-portfolio.component';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { HttpInterceptorBasicAuthService } from './util/service/http-interceptor-basic-auth.service';
import { ProfitLossComponent } from './profit-loss/profit-loss.component';
import { DecimalPipe } from '@angular/common';
import {NgxPaginationModule} from 'ngx-pagination';
import { UserlistComponent } from './sysadmin/userlist/userlist.component';
import { UserComponent } from './sysadmin/user/user.component';
import { WatchlistListComponent } from './user-watchlist/watchlist-main/watchlist-list.component';
import { WatchlistComponent } from './user-watchlist/watchlist/watchlist.component';
import {MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import { CreateWatchlistComponent } from './user-watchlist/create-watchlist/create-watchlist.component';
import { CreateWatchlistEntryComponent } from './user-watchlist/create-watchlist-entry/create-watchlist-entry.component';
import { NotiWatchlistComponent } from './user-watchlist/noti-watchlist/noti-watchlist.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatBadgeModule} from '@angular/material/badge';
import { MessageDialogComponent } from './common/message-dialog/message-dialog.component';
import { SortPipe } from './util/pipe/sort.pipe';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSortModule } from '@angular/material/sort';
import {MatTabsModule} from '@angular/material/tabs';
import { LoadDividendComponent } from './data-loading/load-dividend/load-dividend.component';
import { PortfoliolistComponent } from './portfolio-management/manage-portfolio/portfoliolist/portfoliolist.component';
import { CreateDividendComponent } from './portfolio-management/manage-dividend/create-dividend/create-dividend.component';
import { DividendComponent } from './portfolio-management/manage-dividend/dividend/dividend.component';
import { PortfolioHoldComponent } from './portfolio-management/manage-portfolio/portfolio-hold/portfolio-hold.component';
import { PortfolioTransComponent } from './portfolio-management/manage-portfolio/portfolio-trans/portfolio-trans.component';
import { PortfolioComponent } from './portfolio-management/manage-portfolio/portfolio/portfolio.component';
import { TransactionComponent } from './portfolio-management/manage-portfolio/transaction/transaction.component';
import { PerformanceComponent } from './performance/performance.component';
import { ChartsModule } from 'ng2-charts';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import { UpdateCashBalComponent } from './performance/update-cash-bal/update-cash-bal.component';

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
    ProfitLossComponent,
    UserlistComponent,
    UserComponent,
    WatchlistListComponent,
    WatchlistComponent,
    CreateWatchlistComponent,
    CreateWatchlistEntryComponent,
    NotiWatchlistComponent,
    MessageDialogComponent,
    SortPipe,
    DividendComponent,
    CreateDividendComponent,
    LoadDividendComponent,
    PerformanceComponent,
    UpdateCashBalComponent
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
    MatIconModule,
    NgxPaginationModule,
    MatDialogModule,
    MatRadioModule,
    MatBadgeModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatExpansionModule,
    MatTableModule,
    MatTooltipModule,
    MatSortModule,
    MatTabsModule,
    ChartsModule,
    MatCardModule,
    MatGridListModule
  ],
  providers: [
    RouteGuard,
    DecimalPipe,
    {
      provide: MatDialogRef,
      useValue: {}
    },
    {provide: HTTP_INTERCEPTORS, useClass:HttpInterceptorBasicAuthService, multi: true}],
  bootstrap: [AppComponent],
  entryComponents:[WatchlistComponent]
})
export class AppModule { }
