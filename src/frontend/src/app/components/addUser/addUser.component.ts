import { Component } from '@angular/core';
import { AdminService } from "../../services/admin.service";
import {SignUpRequest} from "../../models";

@Component({
  moduleId: module.id,
  selector: 'addUser',
  styleUrls: ['./addUser.component.css'],
  templateUrl: './addUser.component.html',
  providers: [AdminService]
})

export class AddUserComponent  {
  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;

  constructor(private adminService: AdminService)
  {
    this.username = "";
    this.password = "";
    this.firstname = "";
    this.lastname = "";
  }

  register()
  {
    this.adminService.save(new SignUpRequest(this.firstname, this.lastname, this.username, this.password)).subscribe(
      data => console.log(data),
    );
  }
}
