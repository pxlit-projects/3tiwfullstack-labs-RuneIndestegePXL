import { Component, EventEmitter, Output } from '@angular/core';
import { Filter } from '../../shared/models/filter.model';
import { FormsModule } from '@angular/forms'; 

@Component({
  selector: 'app-filter-component',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './filter.component.html',
  styleUrl: './filter.component.css'
})
export class FilterComponent {
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
