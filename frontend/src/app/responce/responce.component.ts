import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Author } from '../entity/author';
import { Book } from '../entity/book';
import { DataproviderService } from '../services/dataprovider.service';

@Component({
  selector: 'app-responce',
  templateUrl: './responce.component.html',
  styleUrls: ['./responce.component.css']
})
export class ResponceComponent implements OnInit {

  book?:Book[];
  author?:Author[];
  isHaveBook?:boolean;
  isTableAuthor?:boolean;
  isTableBook?:boolean;
  isHaveAuthor?:boolean;
  constructor(private service:DataproviderService,private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.router.params.subscribe(param=>{
      if(param['name'] == 'book'){
        this.isTableBook=true;
        this.getAllBook();
      }
      if(param['name'] == 'author'){
        this.isTableAuthor=true;
        this.getAllAuthor();
      }
    })
    
  }

  getAllBook(){
    this.service.getAllBook().subscribe(data =>{
      this.book = data;
      if(this.book.length === 0){
        this.isHaveBook = false;
      }else{
        this.isHaveBook = true;
      }
    })
  }

  deleteBook(id:number){
    this.service.deleteBook(id).subscribe(()=>{
      location.reload();
    },
    (err:HttpErrorResponse)=>{
      window.alert(err.message)
    }
    )
  }

  getAllAuthor(){
    this.service.getAllAuthor().subscribe(data=>{
      this.author = data;
      if(this.author.length ===0){
        this.isHaveAuthor = false;
      }else{
        this.isHaveAuthor = true;
      }
    })
  }

  deleteAuthor(id:number){
    this.service.deleteAuthor(id).subscribe(()=>{
      location.reload();
    },
    (err:HttpErrorResponse)=>{
      window.alert(err.message)
    }
    )
  }

}
