package com.epiclancers.gettingstartedwithroomdatabase.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "books_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int book_id;
    public String book_name;
    @ColumnInfo(name = "author_name")
    public String authorName;

    @Ignore
    public Book(String book_name, String authorName) {
        this.book_name = book_name;
        this.authorName = authorName;
    }

    public Book(int book_id, String book_name, String authorName) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.authorName = authorName;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}



