import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ResponceComponent } from './responce/responce.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormDataComponent } from './form-data/form-data.component';

const routes: Routes = [
{ path: "", component:NavbarComponent ,pathMatch:'full'},
{ path: "table/:name", component:ResponceComponent},
{ path: ":param/:name", component:FormDataComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ResponceComponent,
    NavbarComponent,
    FormDataComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
