import { Component, OnInit } from '@angular/core';
import { BookingService } from '../booking.service';
import { SharedService } from '../shared.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  receivedData:any;
  userId!:number;
  selectedDate: string | null = null;
  selectedTime: string | null = null;
  bookingStatus!:number;
  showSuccessMessage = false;
  showFailedMessage = false;
  slotFree : boolean = false;

  constructor(private bookingService: BookingService, private sharedService : SharedService, private router : Router) {}

  ngOnInit(): void {
    this.receivedData = this.sharedService.getData();
    this.userId = this.receivedData.userId;
  }

  onDateChange(event: Event) {
    const input = event.target as HTMLInputElement;
    this.selectedDate = input.value;
  }

  openDatePicker() {
    const datePicker = document.getElementById('datePicker') as HTMLInputElement;
    datePicker.click();
  }

  submit() {
    const formData = {
      date: this.selectedDate,
      time: this.selectedTime,
      userId: this.userId
    };

    this.bookingService.verifySlotFree(formData).subscribe(
      (response) =>{
        this.slotFree = response;
        if(this.slotFree){
          this.sharedService.setBookingData(formData);
          this.router.navigate(['/payment']);
        }
        else {
          this.showFailedMessage=true;
             setTimeout(() => {
              this.showFailedMessage = false;
            }, 1000);
        }
      }
    )
      // this.bookingService.slotBook(formData).subscribe(
      //   (response) => {
      //     this.bookingStatus = response;
      //     if(this.bookingStatus==1){
      //       this.showSuccessMessage=true;
      //       setTimeout(() => {
      //         this.showSuccessMessage = false;
      //         this.router.navigate(['/payment']);
      //       }, 1000);
      //     }
      //     if(this.bookingStatus==0){
      //       this.showFailedMessage=true;
      //       setTimeout(() => {
      //         this.showFailedMessage = false;
      //       }, 1000);
      //     }
      //   },
      //   (error) => {
      //     alert("error")
      //   }
      // ); 
  }
}
