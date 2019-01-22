package com.epiclancers.gettingstartedwithroomdatabase.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);
}


