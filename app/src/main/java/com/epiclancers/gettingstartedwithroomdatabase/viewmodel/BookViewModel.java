package com.epiclancers.gettingstartedwithroomdatabase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.epiclancers.gettingstartedwithroomdatabase.repository.BookRepository;
import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

import java.util.List;


public class BookViewModel extends AndroidViewModel {

    public LiveData<List<Book>> bookLiveData;
    public BookRepository repository;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        bookLiveData = repository.bookDao.getBooks();
    }
}


