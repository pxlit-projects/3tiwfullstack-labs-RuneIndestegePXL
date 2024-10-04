import { Component, Input } from '@angular/core';
import { Article } from '../Article';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  @Input() articles!: Article[];

  showDetails(article: Article) {
    alert(`Item description: ${article.name} - Sale Price: €${article.salePrice} - Purchase Price: €${article.purchasePrice}`);
  }
}
