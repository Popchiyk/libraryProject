import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../entity/book';

@Injectable({
  providedIn: 'root'
})

export class DataproviderService {
  ip = "http://localhost:8080/api/v1/";
  constructor(private http:HttpClient) { }
  
  public getAllBook():Observable<Book[]> {
    return this.http.get<Book[]>(this.ip+"book/")
  }
}
