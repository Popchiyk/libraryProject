import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../entity/author';
import { Book } from '../entity/book';
import { DataproviderService } from '../services/dataprovider.service';

@Component({
  selector: 'app-form-data',
  templateUrl: './form-data.component.html',
  styleUrls: ['./form-data.component.css']
})
export class FormDataComponent implements OnInit {

  isAddBook?:boolean;
  isAddAuthor?:boolean;
  isUpdateAuthor?:boolean;
  isUpdateBook?:boolean;
  authorList?:Author[];
  bookAdd:Book;
  formAddBook:FormGroup;
  constructor(private router:ActivatedRoute,private service:DataproviderService,private formbuilder:FormBuilder,private _router:Router) {
    this.formAddBook = formbuilder.group({
    date:['',[Validators.required]],
    genre:['',[Validators.required,Validators.minLength(4),Validators.maxLength(10)]],
    name:['',[Validators.required,Validators.minLength(3),Validators.maxLength(15)]],
    author:['',[Validators.required]]
    })

    this.bookAdd={
      name : "",
      id_author : new Author,
      genre: "",
      dateOfPublication : new Date,
      id : 0
    }
   }
  ngOnInit(): void {
    this.router.params.subscribe(params=>{
      if(params['param'] === 'add' && params['name'] === 'book'){
        this.isAddBook = true;
        this.getAllAuthor();
      }else{
        this.isAddBook = false;
      }
      if(params['param'] === 'add' && params['name'] === 'author'){
        this.isAddAuthor = true;
      }else{
        this.isAddAuthor = false;
      }
      if(params['param'] === 'update' && params['name'] === 'author'){
        this.isUpdateAuthor = true;
      }else{
        this.isUpdateAuthor = false;
      }
      if(params['param'] === 'update' && params['name'] === 'book'){
        this.isUpdateBook = true;
      }else{
        this.isUpdateBook = false;
      }
    })
  }

  getAllAuthor(){
    this.service.getAllAuthor().subscribe(data=>{
      this.authorList = data;
    })
  }

  addBook(){
    this.bookAdd.dateOfPublication = this.formAddBook.get('date')?.value;
    this.bookAdd.genre =  this.formAddBook.get('genre')?.value;
    this.bookAdd.name =  this.formAddBook.get('name')?.value;
    this.bookAdd.id_author.id =  this.formAddBook.get('author')?.value;
    console.log(this.bookAdd)
    this.service.addBook(this.bookAdd).subscribe(data=>{
      this._router.navigate(['/table/book'])
    })
  }

}
