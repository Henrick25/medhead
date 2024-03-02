import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchHospitalComponent } from './search-hospital/search-hospital.component';
import { GestionReservationComponent } from './gestion-reservation/gestion-reservation.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth-guard.service';

const routes: Routes = [
  { path: 'hopital', component: SearchHospitalComponent },
  {
    path: 'reservations',
    component: GestionReservationComponent,
    canActivate: [AuthGuard],
  },

  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
