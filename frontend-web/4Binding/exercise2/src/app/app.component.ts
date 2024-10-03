import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'exercise2';
  var1: number = 0;
  var2: number = 0;
  var3!: number;
  multiply() {
    this.var3 = Number(this.var1) + Number(this.var2);
  }
}
