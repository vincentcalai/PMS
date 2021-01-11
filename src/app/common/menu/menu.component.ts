import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../../service/authenticate.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  constructor(public authenticateService:AuthenticateService) { }

  ngOnInit(): void {
  }

}
