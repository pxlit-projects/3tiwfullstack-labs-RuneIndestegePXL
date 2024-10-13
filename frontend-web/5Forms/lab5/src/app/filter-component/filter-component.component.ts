import { Component, EventEmitter, Output } from '@angular/core';
import { Filter } from '../../shared/models/filter.model';

@Component({
  selector: 'app-filter-component',
  standalone: true,
  imports: [],
  templateUrl: './filter-component.component.html',
  styleUrl: './filter-component.component.css'
})
export class FilterComponentComponent {
  onSubmit(form: any) {
    if (form.valid) {
      this.filter.name = this.filter.name.toLowerCase();
      this.filter.city = this.filter.city.toLowerCase();
      this.filterChanged.emit(this.filter);
    }
  }

  filter: Filter = { name: '', city: '', vat: undefined };

  @Output() filterChanged = new EventEmitter<Filter>();
  
}
