import { Component, ViewEncapsulation } from '@angular/core';
import { AuthenticateService } from './service/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})



export class AppComponent {
  title = 'pms';

  constructor(public authenticateService:AuthenticateService) { }
}
