import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Article } from './Article';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise4';
  articles: Article[] = [];

  ngOnInit() {
    this.articles = [
      { id: 1, name: 'Tandenborstel', purchasePrice: 1.5, salePrice: 3.24, imageUrl: 'assets/images/toothbrush.png' },
      { id: 2, name: 'Handdoek', purchasePrice: 2.5, salePrice: 4.75, imageUrl: 'assets/images/towel.png' },
      { id: 3, name: 'Washandje', purchasePrice: 0.4, salePrice: 1.2, imageUrl: 'assets/images/facecloth.png' },
      { id: 4, name: 'Keukenrol', purchasePrice: 1.75, salePrice: 0.65, imageUrl: 'assets/images/kitchenroll.png' }
    ];
  }
}
