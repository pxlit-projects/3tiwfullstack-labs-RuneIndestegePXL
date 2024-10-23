import { Component, OnInit } from '@angular/core';
import { CustomerItemComponent } from "../customer-item/customer-item.component";
import { Customer } from '../../../shared/models/customer.model';
import { Filter } from '../../../shared/models/filter.model';
import { FilterComponent } from '../../filter/filter.component';
import { AddCustomerComponent } from "../add-customer/add-customer.component";
import { CustomerService } from '../../../shared/services/customer.service';
import { map, Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [FilterComponent, CustomerItemComponent, AddCustomerComponent, CommonModule],
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})

export class CustomerListComponent implements OnInit {
  filteredData$!: Observable<Customer[]>;

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    this.filteredData$ = this.customerService.getCustomers()
  }

  handleFilter(filter: Filter): void {
    this.filteredData$ = this.customerService.filterCustomers(filter);
  }

  processAdd(customer: Customer): void {
    this.customerService.addCustomer(customer).subscribe({
      next: () => this.fetchData(),
    });
  }
  
  trackByName(index: number, item: Customer): string {

    return item.name;

  }
/* @for(item of (filteredData$ | async); track item.name){
      <app-customer-item [customer]="item"></app-customer-item>
    } */
}
