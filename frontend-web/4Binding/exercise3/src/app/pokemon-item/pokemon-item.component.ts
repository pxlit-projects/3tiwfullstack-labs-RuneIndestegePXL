import { Component, Input } from '@angular/core';
import { Pokemon } from '../Pokemon';
import { CommonModule } from '@angular/common';  // Import CommonModule


@Component({
  selector: 'app-pokemon-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pokemon-item.component.html',
  styleUrl: './pokemon-item.component.css'
})
export class PokemonItemComponent {
  @Input() pokemon!: Pokemon

  getColor(type: string): string {
    switch (type) {
      case 'grass':
        return 'green';
      case 'fire':
        return 'red';
      case 'water':
        return 'blue';
      default:
        return 'gray';
    }
  }
}
