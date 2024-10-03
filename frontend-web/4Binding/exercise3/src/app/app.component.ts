import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Pokemon } from './Pokemon';
import { PokemonItemComponent } from "./pokemon-item/pokemon-item.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PokemonItemComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'exercise3';
  pokemons: Pokemon[] = [
    { id: 1, name: "Bulbasaur", type: "grass", icon: "bulbasaur.png" },
    { id: 2, name: "Ivysaur", type: "grass", icon: "ivysaur.png" },
    { id: 3, name: "Venusaur", type: "grass", icon: "venusaur.png" },
    { id: 4, name: "Charmander", type: "fire", icon: "charmander.png" },
    { id: 5, name: "Charmeleon", type: "fire", icon: "charmeleon.png" },
    { id: 6, name: "Charizard", type: "fire", icon: "charizard.png" },
    { id: 7, name: "Squirtle", type: "water", icon: "squirtle.png" },
    { id: 8, name: "Wartortle", type: "water", icon: "wartortle.png" },
    { id: 9, name: "Blastoise", type: "water", icon: "blastoise.png" }
 ];
 trackByPokemon(index: number, pokemon: Pokemon): number {
  return pokemon.id;
}
 
}
