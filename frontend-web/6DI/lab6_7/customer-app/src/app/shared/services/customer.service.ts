import { inject, Injectable } from '@angular/core';
import { Customer } from '../models/customer.model';
import { Filter } from '../models/filter.model';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {
  api: string = 'api/customers';
  http: HttpClient = inject(HttpClient);

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.api);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.api, customer);
  }

  filterCustomers(filter: Filter): Observable<Customer[]> {
    return this.getCustomers().pipe(
      map(customers =>
        customers.filter(customer => 
          (!filter.name || customer.name.toLowerCase().includes(filter.name.toLowerCase())) &&
          (!filter.city || customer.city.toLowerCase().includes(filter.city.toLowerCase())) &&
          (filter.vat === undefined || customer.vat === filter.vat)
        )
      )
  
    );
  }

}