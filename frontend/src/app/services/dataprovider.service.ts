import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../entity/book';
import { Author } from '../entity/author';

@Injectable({
  providedIn: 'root'
})

export class DataproviderService {
  localhost = "http://localhost:8080/api/v1/";
  constructor(private http:HttpClient) { }
  
  public getAllBook():Observable<Book[]> {
    return this.http.get<Book[]>(this.localhost+"book/")
  }

  public deleteBook(id:number):Observable<void>{
    return this.http.delete<void>(this.localhost+"book/"+id)
  }

  public deleteAuthor(id:number):Observable<void>{
    return this.http.delete<void>(this.localhost+"author/"+id)
  }

  public getAllAuthor():Observable<Author[]>{
    return this.http.get<Author[]>(this.localhost+"author/")
  }
}
