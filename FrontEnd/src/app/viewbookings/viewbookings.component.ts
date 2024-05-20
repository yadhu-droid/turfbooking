import { Component, OnInit } from '@angular/core';
import { BookingService } from '../booking.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-viewbookings',
  templateUrl: './viewbookings.component.html',
  styleUrls: ['./viewbookings.component.css']
})
export class ViewbookingsComponent implements OnInit {
userId!:number;
receivedData:any;
bookingDetails:any;

constructor(private bookingService:BookingService, private sharedService : SharedService){}

ngOnInit() {
    this.receivedData = this.sharedService.getData();
    this.userId = this.receivedData.userId;
    this.bookingService.getBookingDetails(this.userId).subscribe(
      (response) => {
        this.bookingDetails = response;
        console.log(this.bookingDetails)
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
}

}
