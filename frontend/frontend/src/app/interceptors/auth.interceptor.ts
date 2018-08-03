import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor} from "@angular/common/http";
import {HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/index";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>,
            next: HttpHandler) : Observable<HttpEvent<any>> {
    const idToken = localStorage.getItem('id_token');
    if(idToken) {
      const cloned = req.clone({
        headers: req.headers.set(
          'Authorization',
          `Bearer ${idToken}`
        )
      });
      return next.handle(cloned);
    } else {
      return next.handle(req);
    }
  }
}
