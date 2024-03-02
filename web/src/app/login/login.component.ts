// login.component.ts
import { Component } from '@angular/core';
import { AuthService } from '../login.service';
import { Router } from '@angular/router';
import { SessionService } from '../session.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  username!: string;
  password!: string;
  public form = this.fb.group({
    name: ['', [Validators.required]],
    password: ['', [Validators.required]],
  });
  constructor(
    private router: Router,
    private session: SessionService,
    private authService: AuthService,
    private fb: FormBuilder
  ) {}

  onSubmit(): void {
    this.authService
      .login(this.form.value.name!, this.form.value.password!)
      .subscribe(
        (data) => {
          console.log('Connexion réussie', data);
          this.session.next(data.token);
          this.router.navigate(['/reservations']);
        },
        (error) => {
          console.error('Erreur de connexion', error);
        }
      );
  }
}
