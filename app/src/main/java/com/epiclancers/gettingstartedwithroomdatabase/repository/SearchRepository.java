package com.epiclancers.gettingstartedwithroomdatabase.repository;

import android.app.Application;

import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.SearchViewModel;

public class SearchRepository {

    public BookDao bookDao;

    public SearchRepository(Application application){
        BookRoomDatabase database = BookRoomDatabase.getInstance(application);
        bookDao = database.bookDao();
    }

}
