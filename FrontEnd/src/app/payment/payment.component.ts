import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
    paymentForm!:FormGroup;
    showSuccessMessage:number=-1;
    showError:boolean=false;

    constructor(private fb: FormBuilder, private router: Router, private userService:UserService) { }

    ngOnInit() {
      this.paymentForm = this.fb.group({
        cardNumber: ['', Validators.required],
        month: ['', Validators.required],
        year: [null, Validators.required],
        customerName: [null, Validators.required],
        securityCode: ['', Validators.required],
      });
    }

    onSubmit() {
      if (this.paymentForm.valid) {
        // Access form values using this.myForm.value
        const formData = this.paymentForm.value;
        this.userService.createUser(formData)
        .subscribe(
          (response:number) => {
            if(response==1){
              this.showSuccessMessage = response;
              setTimeout(() => {
                this.showSuccessMessage = -1;
                this.router.navigate(['/login']);
              }, 1000);
            }
          },
          (error:any) => {
            alert('Error creating User');
            // Handle error (e.g., show an error message)
          }
        );
    } else {
      this.showError = true;
      setTimeout(() => {
        this.showError = false;
      }, 1000);
    }
  }
}
