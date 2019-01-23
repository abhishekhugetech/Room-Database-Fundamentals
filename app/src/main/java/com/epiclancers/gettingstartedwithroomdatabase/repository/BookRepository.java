package com.epiclancers.gettingstartedwithroomdatabase.repository;

import android.app.Application;

import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

public class BookRepository {

    public BookDao bookDao;

    public BookRepository(Application application){
        BookRoomDatabase database = BookRoomDatabase.getInstance(application);
        bookDao = database.bookDao();
    }

    public void insertBook(final Book book){
        // Run this in Background Thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                bookDao.addBook(book);
            }
        });
        thread.start();
    }

    public void deleteBook(final Book book) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                bookDao.deleteBook(book);
            }
        });
        thread.start();
    }

    public void updateBook(final Book book) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                bookDao.updateBook(book);
            }
        });
        thread.start();
    }

}
