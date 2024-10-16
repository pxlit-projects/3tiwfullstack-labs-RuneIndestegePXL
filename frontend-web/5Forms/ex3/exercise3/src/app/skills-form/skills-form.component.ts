import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-skills-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './skills-form.component.html',
  styleUrl: './skills-form.component.css'
})
export class SkillsFormComponent {
  skillsForm: FormGroup;
  constructor(private fb: FormBuilder) {
    this.skillsForm = this.fb.group({
      skills: this.fb.array([this.createSkillGroup()])
    });
  }

  get skills(): FormArray {
    return this.skillsForm.get('skills') as FormArray;
  }

  createSkillGroup(): FormGroup {
    return this.fb.group({
      skillName: ['', Validators.required],
      experienceLevel: ['', Validators.required]
    });
  }

  addSkill(): void {
    this.skills.push(this.createSkillGroup());
  }

  removeSkill(index: number): void {
    this.skills.removeAt(index);
  }

  onSubmit(): void {
    if (this.skillsForm.valid) {
      console.log(this.skillsForm.value.skills);
    }
  }

}
