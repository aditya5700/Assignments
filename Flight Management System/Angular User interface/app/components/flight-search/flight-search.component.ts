import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FlightDetails } from 'src/app/model/flight-details';
import { FlightDetailsService } from 'src/app/services/flight-details-service.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css'],
  // encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .dark-modal .modal-content {
        background-color: #292b2c;
        color: white;
      }
      .dark-modal .close {
        color: white;
      }
      .light-blue-backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class FlightSearchComponent implements OnInit {
  public flightDetails: FlightDetails[] = [];
  public flightForm!: FormGroup;
  loggedIn = false;
  flight!: any;

  constructor(
    private flightService: FlightDetailsService,
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private modalService: NgbModal
  ) {}

  searchFlight(flightForm: any) {
    console.log(flightForm);
    console.log(flightForm.value);
    return flightForm;
  }
  ngOnInit(): void {
    this.flightForm = this.formBuilder.group({
      source: ['', Validators.required],
      destination: ['', Validators.required],
      departureDate: ['', Validators.required],
    });

    this.loggedIn = this.loginService.isLoggedIn();

    this.flightService.getFlightDetails().subscribe((data: FlightDetails[]) => {
      this.flightDetails = data;
    });
  }
  getFlight() {
    if (this.flightForm.valid) {
      this.flightService
        .getFlightDetailsBySourceAndDestinationAndDepartureDate(
          this.flightForm.value.source,
          this.flightForm.value.destination,
          this.flightForm.value.departureDate
        )
        .subscribe((data: FlightDetails[]) => {
          this.flightDetails = data;
          console.log(this.flightDetails);
          console.log(this.flightForm.value.departureDate.type);
        });
    } else {
      this.flightService
        .getFlightDetails()
        .subscribe((data: FlightDetails[]) => {
          this.flightDetails = data;
        });
    }
  }

  get source() {
    return this.flightForm.get('source');
  }

  get destination() {
    return this.flightForm.get('destination');
  }

  get departureDate() {
    return this.flightForm.get('departureDate');
  }

  openLogin(content: any) {
    this.modalService.open(content, { size: 'lg' });
  }

  setFlightDetails(flight: any) {
    this.flightService.setFlightDetails(flight);
  }
}
