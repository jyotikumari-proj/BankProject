import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{HomeComponent} from '../app/home/home.component';
import { RegistrationComponent } from '../app/registration/registration.component';
import{UserLoginComponent} from '../app/user-login/user-login.component';
import{DashComponent} from '../app/dash/dash.component';
import{FdComponent}from '../app/fd/fd.component';

const routes: Routes = [
  {path: 'registration' , component: RegistrationComponent },
  {path:'userLogin', component:UserLoginComponent },
  {path:'login', component:UserLoginComponent },
  {path:'dash', component:DashComponent},
  {path:'fd',component:FdComponent},
  {path:'dash2',component:DashComponent},
  
];

//export const routing: NgModule = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
 }
