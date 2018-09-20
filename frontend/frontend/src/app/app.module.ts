import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {AuthService} from "./auth.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import { PortalComponent } from './portal/portal.component';
import {AuthInterceptor} from "./interceptors/auth.interceptor";
import {AuthGuard} from "./guards/auth.guard";
import { HomeComponent } from './home/home.component';
import { DictionaryListComponent } from './dictionary-list/dictionary-list.component';
import {DictionaryService} from "./dictionary.service";
import { DictionaryControlsComponent } from './dictionary-controls/dictionary-controls.component';
import { DictionaryCreateFormComponent } from './dictionary-create-form/dictionary-create-form.component';
import { DictionaryEditFormComponent } from './dictionary-edit-form/dictionary-edit-form.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';
import { LeftMenuComponent } from './left-menu/left-menu.component';
import { DictionaryHomeComponent } from './dictionary-home/dictionary-home.component';
import {LeftMenuService} from "./left-menu.service";
import { DictionaryComponent } from './dictionary/dictionary.component';
import { DictionaryFilterComponent } from './dictionary-filter/dictionary-filter.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'portal',
    component: PortalComponent,
    children: [
      { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
      { path: 'dictionary', component: DictionaryComponent, children: [
          { path: 'degree', component: DictionaryListComponent, canActivate: [AuthGuard] },
          { path: 'degree/create', component: DictionaryCreateFormComponent, canActivate: [AuthGuard] },
          { path: 'degree/:id', component: DictionaryDetailComponent, canActivate: [AuthGuard] },
          { path: 'degree/:id/edit', component: DictionaryEditFormComponent, canActivate: [AuthGuard] },
          { path: 'degree/:id/view', component: DictionaryDetailComponent, canActivate: [AuthGuard] },

          { path: 'rank', component: DictionaryListComponent, canActivate: [AuthGuard] },
          { path: 'rank/create', component: DictionaryCreateFormComponent, canActivate: [AuthGuard] },
          { path: 'rank/:id', component: DictionaryDetailComponent, canActivate: [AuthGuard] },
          { path: 'rank/:id/edit', component: DictionaryEditFormComponent, canActivate: [AuthGuard] },

          { path: 'position', component: DictionaryListComponent, canActivate: [AuthGuard] },
          { path: 'position/create', component: DictionaryCreateFormComponent, canActivate: [AuthGuard] },
          { path: 'position/:id', component: DictionaryDetailComponent, canActivate: [AuthGuard] },
          { path: 'position/:id/edit', component: DictionaryEditFormComponent, canActivate: [AuthGuard] }
        ], canActivate: [AuthGuard] },
    ],
    canActivate: [AuthGuard]
  },
  {path: 'login', component: LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PortalComponent,
    HomeComponent,
    DictionaryListComponent,
    DictionaryControlsComponent,
    DictionaryCreateFormComponent,
    DictionaryEditFormComponent,
    DictionaryDetailComponent,
    LeftMenuComponent,
    DictionaryHomeComponent,
    DictionaryComponent,
    DictionaryFilterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    AuthGuard,
    DictionaryService,
    LeftMenuService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
