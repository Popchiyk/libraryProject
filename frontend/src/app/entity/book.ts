import { Author } from "./author";

export class Book{
    id!: number;
    name!:string;
    id_author!:Author;
    genre!:string;
    dateOfPublication!:string;
}
