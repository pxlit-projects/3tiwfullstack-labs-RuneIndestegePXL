import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Article } from './Article';
import { ArticleComponent } from "./article/article.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ArticleComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise4';
  articles: Article[] = [];

  ngOnInit() {
    this.articles = [
      { id: 1, name: 'Tandenborstel', purchasePrice: 1.5, salePrice: 3.24, imageUrl: 'toothbrush.png' },
      { id: 2, name: 'Handdoek', purchasePrice: 2.5, salePrice: 4.75, imageUrl: 'towel.png' },
      { id: 3, name: 'Washandje', purchasePrice: 0.4, salePrice: 1.2, imageUrl: 'facecloth.png' },
      { id: 4, name: 'Keukenrol', purchasePrice: 1.75, salePrice: 0.65, imageUrl: 'kitchenroll.png' }
    ];
  }
}
