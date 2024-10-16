import { Component, EventEmitter, inject, Output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Customer } from '../../../shared/models/customer.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-customer',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './add-customer.component.html',
  styleUrl: './add-customer.component.css'
})
export class AddCustomerComponent {
  onSubmit() {
    const newCustomer: Customer = {
      ...this.customerForm.value
    };
    this.addCustomer.emit(newCustomer);
  }

  fb: FormBuilder = inject(FormBuilder);
  @Output() addCustomer = new EventEmitter<Customer>();
  customerForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    avatar: ['default.png',[Validators.required]],
    city: ['', Validators.required],
    address: ['', Validators.required],
    country: ['', Validators.required],
    vat: ['', [Validators.required, Validators.min(0)]]
  });
}
