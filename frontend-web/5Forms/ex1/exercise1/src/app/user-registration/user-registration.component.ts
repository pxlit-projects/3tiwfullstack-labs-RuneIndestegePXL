import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-registration',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-registration.component.html',
  styleUrl: './user-registration.component.css'
})

export class UserRegistrationComponent {
  fullName: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  ngSubmit!: NgForm;

  onSubmit(form: NgForm) {
    if (form.valid && this.password === this.confirmPassword) {
      console.log({
        fullName: this.fullName,
        email: this.email,
        password: this.password,
        confirmPassword: this.confirmPassword
      });
    } else {
      console.error('Form is invalid or passwords do not match');
    }

  }
}
