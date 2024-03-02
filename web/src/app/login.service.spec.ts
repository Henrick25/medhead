import { TestBed } from '@angular/core/testing';

import { AuthService } from './login.service';
import { HttpClientModule } from '@angular/common/http';

describe('LoginService', () => {
  let service: AuthService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
    }).compileComponents();

    service = TestBed.inject(AuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
