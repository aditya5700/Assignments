import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingDetailsComponent } from './components/booking-details/booking-details.component';
import { FlightSearchComponent } from './components/flight-search/flight-search.component';
import { AboutComponent } from './components/home/about/about.component';
import { ContactComponent } from './components/home/contact/contact.component';
import { GalleryComponent } from './components/home/gallery/gallery.component';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/pages/profile/dashboard/dashboard.component';
import { ManageBookingComponent } from './components/pages/profile/manage-booking/manage-booking.component';
import { ProfileComponent } from './components/pages/profile/profile.component';
import { UserComponent } from './components/pages/profile/user/user.component';
import { PaymentComponent } from './components/payment/payment.component';
import { SucessComponent } from './components/sucess/sucess.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'flights', component: FlightSearchComponent },
  { path: 'about', component: AboutComponent },
  { path: 'gallery', component: GalleryComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'booking', component: BookingDetailsComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'success', component: SucessComponent },

  {
    path: 'profile/user',
    component: ProfileComponent,
    children: [
      {
        path: '',
        component: UserComponent,
      },
    ],
  },
  {
    path: 'profile/manageBooking',
    component: ProfileComponent,
    children: [
      {
        path: '',
        component: ManageBookingComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
