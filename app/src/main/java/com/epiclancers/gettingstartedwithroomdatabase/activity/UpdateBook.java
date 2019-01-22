package com.epiclancers.gettingstartedwithroomdatabase.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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

public class UpdateBook extends AppCompatActivity {

    BookViewModel bookViewModel;
    EditText bookName,authorName;
    private int book_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        init();

        final String book_name = getIntent().getStringExtra(MainActivity.KEY_BOOK_NAME);
        final String author_name = getIntent().getStringExtra(MainActivity.KEY_AUTHOR_NAME);
        book_id = getIntent().getIntExtra(MainActivity.KEY_BOOK_ID,-1);
        bookName.setText(book_name);
        authorName.setText(author_name);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updated_bookName = bookName.getText().toString();
                String updated_authorName = authorName.getText().toString();
                if (!updated_authorName.isEmpty() && !updated_bookName.isEmpty()){
                    if (!book_name.equals(updated_bookName) || !author_name.equals(updated_authorName)){
                        bookViewModel.updateBook(new Book(book_id,updated_bookName,updated_authorName));
                        Toast.makeText(UpdateBook.this, "Book was Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }

    private void init() {
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
    }



}
