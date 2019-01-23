package com.epiclancers.gettingstartedwithroomdatabase.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.adapter.BookAdapter;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivty extends AppCompatActivity  {

    SearchViewModel model;
    RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_activty);
        String bookName = getIntent().getStringExtra(MainActivity.KEY_BOOK_NAME);
        init();
        model = ViewModelProviders.of(this).get(SearchViewModel.class);
        model.setBookLiveData(bookName);
        model.bookLiveData.observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                adapter.setData(books);
            }
        });
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        List<Book> list =new ArrayList<>();
        adapter = new BookAdapter(list,this , null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
