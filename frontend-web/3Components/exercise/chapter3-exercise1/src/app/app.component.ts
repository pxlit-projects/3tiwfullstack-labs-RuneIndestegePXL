import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LogoComponentComponent } from "./src/core/logo/logo-component/logo-component.component";
import { NewsletterComponent } from "./newsletter/newsletter.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LogoComponentComponent, NewsletterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'chapter3-exercise1';
}
