package com.epiclancers.gettingstartedwithroomdatabase.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);

    @Query("SELECT * FROM books_table")
    LiveData<List<Book>> getBooks();

    @Delete
    void deleteBook(Book book);
}


