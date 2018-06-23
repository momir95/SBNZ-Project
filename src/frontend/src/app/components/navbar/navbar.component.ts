import { Component, NgModule, OnInit } from '@angular/core';
import {LoggedUtils} from "../../utils/logged.utils";
import { AuthenticationService } from "../../services/authentication.service";
import { Link } from "../../models";
import { Router }    from '@angular/router';

@Component({
  moduleId: module.id,
  selector: 'navbar',
  templateUrl: 'navbar.component.html'
})
export class NavbarComponent implements OnInit
{

  links: Link[];
  currentRole:string;

  constructor(private authenticationService: AuthenticationService, private _router: Router)
  {
    this.logout();
  }

  ngOnInit() {
    this.authenticationService.getRoleEmitter().subscribe((value:string) => this.changeRole(value));
  }

  private changeRole(role: string)
  {
    this.currentRole = role;
    this.links = [];
    console.log('Promenio roluu');
    if (this.currentRole == "ROLE_ADMIN") {
      this.presetAdmin();
      this._router.navigate(['/findMedicalRecord']);
    }
    else if (this.currentRole == "ROLE_DOCTOR") {
      this.presetDoctor();
      this._router.navigate(['/findMedicalRecord']);

    }
  }


  addLink(link: Link)
  {
    this.links.push(link);
  }

  presetAdmin()
  {
    this.addLink({text: "Find MR", routerLink: "/findMedicalRecord"});
    this.addLink({text: "Create MR", routerLink: "/createMedicalRecord"});
    this.addLink({text: "Create cure", routerLink: "/createCure"});
    this.addLink({text: "Create ingredient", routerLink: "/createIngredient"});
    this.addLink({text: "Create disease", routerLink: "/createDisease"});
    this.addLink({text: "Add doctor", routerLink: "/addDoctor"});
    this.addLink({text: "Report", routerLink: "/report"});
    this.addLink({text: "Logout", routerLink:"/" });
    //this._router.navigate(['/adminPage']);
  }

  presetDoctor()
  {
    this.addLink({text: "Find MR", routerLink: "/findMedicalRecord"});
    this.addLink({text: "Create MR", routerLink: "/createMedicalRecord"});
    this.addLink({text: "Report", routerLink: "/report"});
    this.addLink({text: "Logout", routerLink:"/" });
    //this._router.navigate(['/adminPage']);
  }


  logout()
  {
    this.links = [];
    this.addLink({text: "Login", routerLink: "/"});
    //this.addLink({text: "All logs", routerLink: "/allLogs"});
    //this.addLink({text: "Add user", routerLink: "/addUser"});
    LoggedUtils.clearLocalStorage();
  }
}
