package com.epiclancers.gettingstartedwithroomdatabase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;


public class BookViewModel extends AndroidViewModel {

    private BookDao bookDao;

    public BookViewModel(@NonNull Application application) {
        super(application);
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

}


