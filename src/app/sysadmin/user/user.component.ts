import { AuthenticateService } from './../../service/authenticate.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { RequestService } from 'src/app/service/request.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user = {
    id : null,
    username : '',
    password : '',
    confirmPassword: '',
    roles: '',
    email: '',
    contactNo: '',
    createdDt: null,
    selectedRoles: [],
    errMsg : '',
    systemMsg : ''
  };

  mode = null;
  MODE_CREATE_USER = 'createUser';
  MODE_UPDATE_USER = 'updateUser';

  rolesList = ['ADMIN', 'USER'];

  message: string = '';
  errorMsg: string = '';

  constructor(private http:HttpClient,
    private requestService: RequestService,
    private dataService: DataService,
    private router:Router) { }

  ngOnInit(): void {
    if (this.dataService.dataObj && this.dataService.dataObj.isCreate === true){
      this.mode = this.MODE_CREATE_USER;
    }else{
      this.mode = this.MODE_UPDATE_USER;
      this.user = this.dataService.dataObj.userForm;
      //this.user.selectedRoles = this.user.roles
      var rolesArray = this.user.roles.split(", ");
      this.user.selectedRoles = rolesArray;
    }
  }

  onSubmit(userForm, mode){
    console.log(userForm);
    if(mode === this.MODE_CREATE_USER){
      this.requestService.post('/sysadmin/createuser', userForm).subscribe(
        data => {
          this.user = data as any;
          console.log(data);
          this.dataService.setDataObj({userForm: this.user});
          window.scrollTo(0, 0);
          if(!this.user.errMsg){
            this.router.navigate(['/userlist']);
          }
        }
      );
    } else {
      this.requestService.post(`/sysadmin/updateuser/${this.user.id}`, userForm).subscribe(
        data => {
          this.user = data as any;
          console.log(data);
          this.dataService.setDataObj({userForm: this.user});
          window.scrollTo(0, 0);
          if(!this.user.errMsg){
            this.router.navigate(['/userlist']);
          }
        }
      );
    }

  }


}
