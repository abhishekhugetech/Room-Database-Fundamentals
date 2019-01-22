package com.epiclancers.gettingstartedwithroomdatabase.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.adapter.BookAdapter;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.BookViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private BookViewModel viewModel;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        viewModel.bookLiveData.observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                adapter.setData(books);
            }
        });
    }

    private void init() {
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , AddBook.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        List<Book> list =new ArrayList<>();
        adapter = new BookAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}


