package com.epiclancers.gettingstartedwithroomdatabase.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.BookViewModel;


public class MainActivity extends AppCompatActivity {

    private BookViewModel viewModel;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewModel = ViewModelProviders.of(this).get(BookViewModel.class);

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
    }
}


