import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import * as jwt_decode from "jwt-decode";
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(email: string, password: string) {
    return this
      .http
      .post(
        'http://localhost:8080/api/auth/sign-in',
        {email, password}
        )
      .pipe(
        map(res => {
          this.setSession(res);
        })
      );
  }

  private setSession(authResult) {
    const decryptedJwt = jwt_decode(authResult.accessToken);
    const expiresAt = moment().add(decryptedJwt.exp);
    localStorage.setItem('id_token', authResult.accessToken);
    localStorage.setItem('expires_at', JSON.stringify(expiresAt.valueOf()));
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
  }

  public isLoggedIn() {
    return moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem('expires_at');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }
}
