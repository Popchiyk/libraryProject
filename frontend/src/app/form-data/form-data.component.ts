import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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
  constructor(private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.router.params.subscribe(params=>{
      if(params['param'] === 'add' && params['name'] === 'book'){
        this.isAddBook = true;
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

}
