package com.epiclancers.gettingstartedwithroomdatabase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.epiclancers.gettingstartedwithroomdatabase.repository.SearchRepository;
import com.epiclancers.gettingstartedwithroomdatabase.room.BookRoomDatabase;
import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    public LiveData<List<Book>> bookLiveData;
    private SearchRepository searchRepository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        searchRepository = new SearchRepository(application);
    }

    public void setBookLiveData(String q){
        bookLiveData = searchRepository.bookDao.getBooksByQuery("%"+q+"%");
    }

}