import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Book } from '../entity/book';
import { DataproviderService } from '../services/dataprovider.service';

@Component({
  selector: 'app-responce',
  templateUrl: './responce.component.html',
  styleUrls: ['./responce.component.css']
})
export class ResponceComponent implements OnInit {

  book?:Book[];
  isHaveBook?:boolean;
  constructor(private service:DataproviderService) { }

  ngOnInit(): void {
    this.getAllBook();
  }

  getAllBook(){
    this.service.getAllBook().subscribe(data =>{
      this.book = data;
      if(this.book.length === 0){
        this.isHaveBook = false;
      }else{
        this.isHaveBook = true;
      }
      console.log(this.isHaveBook)
    })
  }

  deleteBook(id:number){
    this.service.deleteBook(id).subscribe(()=>{
      console.log(true)
    },
    (err:HttpErrorResponse)=>{
      console.log(err.message)
    }
    )
  }

}
