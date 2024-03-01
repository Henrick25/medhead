import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { SearchHospitalComponent } from './search-hospital/search-hospital.component';
import { RouterModule } from '@angular/router'; // Importation de RouterModule
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { GoogleMapsModule } from '@angular/google-maps';
import { ReservationFormComponent } from './reservation/reservation.component';
import { ReactiveFormsModule } from '@angular/forms';
import { GestionReservationComponent } from './gestion-reservation/gestion-reservation.component'; // Importez ReactiveFormsModule

@NgModule({
  declarations: [
    AppComponent,
    SearchHospitalComponent,
    ReservationFormComponent,
    GestionReservationComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    GoogleMapsModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
