import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SkillsFormComponent } from "./skills-form/skills-form.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SkillsFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exercise3';
}
