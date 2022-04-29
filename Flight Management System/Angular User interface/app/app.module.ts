import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NavbarComponent } from './components/pages/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FlightSearchComponent } from './components/flight-search/flight-search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './components/pages/registration/registration.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './components/pages/login/login.component';
import { NgToastModule } from 'ng-angular-popup';
import { AboutComponent } from './components/home/about/about.component';
import { GalleryComponent } from './components/home/gallery/gallery.component';
import { FooterComponent } from './components/home/footer/footer.component';
import { ContactComponent } from './components/home/contact/contact.component';
import { BookingDetailsComponent } from './components/booking-details/booking-details.component';
import { ProfileComponent } from './components/pages/profile/profile.component';
import { SidenavComponent } from './components/pages/profile/sidenav/sidenav.component';
import { ManageBookingComponent } from './components/pages/profile/manage-booking/manage-booking.component';
import { DashboardComponent } from './components/pages/profile/dashboard/dashboard.component';
import { UserComponent } from './components/pages/profile/user/user.component';
import { PaymentComponent } from './components/payment/payment.component';
import { BookingDetailsService } from './services/booking-details.service';
import { SucessComponent } from './components/sucess/sucess.component';
import { AuthGuard } from './auth.guard';
import { AuthInterceptor } from './services/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FlightSearchComponent,
    RegistrationComponent,
    LoginComponent,
    AboutComponent,
    GalleryComponent,
    FooterComponent,
    ContactComponent,
    BookingDetailsComponent,
    ProfileComponent,
    SidenavComponent,
    ManageBookingComponent,
    DashboardComponent,
    UserComponent,
    PaymentComponent,
    SucessComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    NgToastModule,
  ],
  providers: [BookingDetailsService],
  bootstrap: [AppComponent],
})
export class AppModule {}
