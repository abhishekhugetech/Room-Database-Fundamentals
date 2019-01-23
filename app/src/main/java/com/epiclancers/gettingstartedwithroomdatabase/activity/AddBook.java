package com.epiclancers.gettingstartedwithroomdatabase.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.BookViewModel;

public class AddBook extends AppCompatActivity {

    BookViewModel bookViewModel;
    EditText bookName,authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        init();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookName.getText().toString().isEmpty() || authorName.getText().toString().isEmpty()){
                    Toast.makeText(AddBook.this, "Please fill both the Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                bookViewModel.repository.insertBook(new Book(bookName.getText().toString(),authorName.getText().toString()));
                Toast.makeText(getApplicationContext() , "Book Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void init() {
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
    }

}
