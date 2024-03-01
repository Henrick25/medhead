import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // Pour les appels HTTP
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // Pour les formulaires
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule, // Déjà présent pour les tests de routage
        HttpClientTestingModule, // Ajouté pour les tests de services HTTP
        FormsModule, // Ajoutez si votre composant utilise des formulaires basés sur des templates
        ReactiveFormsModule, // Ajoutez si votre composant utilise des formulaires réactifs
      ],
      declarations: [AppComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Medhead'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('Medhead');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain(
      'Bienvenue sur Medhead'
    );
  });
});
