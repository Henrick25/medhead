import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  private $token = new BehaviorSubject<string>('');
  isLogged = false;

  constructor() {}
  getToken(): Observable<string> {
    return this.$token.asObservable();
  }
  next(token: string) {
    this.isLogged = true;
    this.$token.next(token);
  }
}
