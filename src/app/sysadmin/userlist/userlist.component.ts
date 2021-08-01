import { DataService } from '../../util/service/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RequestService } from 'src/app/util/service/request.service';
import { AuthenticateService } from 'src/app/util/service/authenticate.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  users: [];
  userIsAdmin: boolean = false;
  username = '';
  message: String = '';

  totalItems = 0;
  itemsPerPage = 5;
  p = 1;

  constructor(private requestService: RequestService,
              private dataService: DataService,
              private authenticateService: AuthenticateService,
              private router: Router) { }

  ngOnInit(): void {
    this.username = this.authenticateService.getAuthenticationUser();
    console.log("username: " + this.username);
    console.log("roles: " + this.authenticateService.roles);
    this.userIsAdmin = this.authenticateService.roles.indexOf('ADMIN') > -1;
    console.log("userIsAdmin: " + this.userIsAdmin);

    if (this.dataService.dataObj && this.dataService.dataObj.userForm) {
      this.message = this.dataService.dataObj.userForm.systemMsg;
    }
    this.dataService.setDataObj(null);
    this.retrieveAllUsers(1);
  }

  retrieveAllUsers(page){
    this.requestService.get('/sysadmin/userlist?page=' + page + '&size=' + this.itemsPerPage).subscribe(
      data => {
        this.p = page;
        this.users = (data as any).content;
        this.totalItems = (data as any).totalElements;
      }
    );
  }

  createUser(){
    this.dataService.setDataObj({ isCreate:true });
    this.router.navigate(['/user']);
  }

  updateUser(user){
    this.dataService.setDataObj({ isCreate:false, userForm: user });
    console.log(this.dataService.dataObj);
    this.router.navigate(['/user']);
  }

  deleteUser(id){
    if(!confirm("Are you sure to delete this user? Roles of user will be deleted permanently.")) {
      return
    }
    this.requestService.delete(`/sysadmin/deleteuser/${id}`).subscribe(
      data => {
        console.log(data);
        this.retrieveAllUsers(1);
        this.message = (data as any).systemMsg;
      }
    );
  }
}
