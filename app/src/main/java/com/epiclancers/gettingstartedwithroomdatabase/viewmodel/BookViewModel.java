package com.epiclancers.gettingstartedwithroomdatabase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

import java.util.List;


public class BookViewModel extends AndroidViewModel {

    public BookDao bookDao;
    public LiveData<List<Book>> bookLiveData;

    public BookViewModel(@NonNull Application application) {
        super(application);
        BookRoomDatabase database = BookRoomDatabase.getInstance(application);
        bookDao = database.bookDao();
        bookLiveData = bookDao.getBooks();
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


