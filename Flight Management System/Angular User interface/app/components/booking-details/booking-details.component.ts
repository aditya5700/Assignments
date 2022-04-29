import { DatePipe } from '@angular/common';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { BookingDetails } from 'src/app/model/booking-details';
import { Passenger } from 'src/app/model/passenger';
import { BookingDetailsService } from 'src/app/services/booking-details.service';

import { FlightDetailsService } from 'src/app/services/flight-details-service.service';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css'],
  providers: [DatePipe],
})
export class BookingDetailsComponent implements OnInit {
  flight!: any;
  fare!: number;
  totalFare!: number;
  passenger = new Passenger();
  dataArray: Passenger[] = [];

  index!: number;
  date!: Date;
  passengerForm!: FormGroup;

  constructor(
    private flightService: FlightDetailsService,
    public datepipe: DatePipe,
    private bookingService: BookingDetailsService,
    private formBuilder: FormBuilder,
    private toast: NgToastService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.flight = this.flightService.getFlights();
    this.fare = this.flight.fare;
    this.passenger = new Passenger();
    this.dataArray.push(this.passenger);
  }

  addForm() {
    this.passenger = new Passenger();
    this.dataArray.push(this.passenger);
  }

  removeForm(index: number) {
    this.dataArray.splice(index, 1);
  }

  // this.router.navigate(['/payment']);

  onSubmit() {
    console.log(this.dataArray);
    this.totalFare = this.fare * this.dataArray.length;
    this.bookingService.setBooking(this.flight, this.totalFare, this.dataArray);
    this.router.navigate(['/payment']);
  }
}
