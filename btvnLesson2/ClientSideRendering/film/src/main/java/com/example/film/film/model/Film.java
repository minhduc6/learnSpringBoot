package com.example.film.film.model;

public class Film {

       private String nameFilm;
       private String author;
       private long year;

       public Film() {
       }

       public Film(String nameFilm, String author, long year) {
              this.nameFilm = nameFilm;
              this.author = author;
              this.year = year;
       }

       public String getNameFilm() {
              return nameFilm;
       }

       public void setNameFilm(String nameFilm) {
              this.nameFilm = nameFilm;
       }

       public String getAuthor() {
              return author;
       }

       public void setAuthor(String author) {
              this.author = author;
       }

       public long getYear() {
              return year;
       }

       public void setYear(long year) {
              this.year = year;
       }

       

       

       
       
}
