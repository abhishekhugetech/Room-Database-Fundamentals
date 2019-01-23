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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.adapter.BookAdapter;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;
import com.epiclancers.gettingstartedwithroomdatabase.viewmodel.BookViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements BookAdapter.OnDeleteClickListener {

    private BookViewModel viewModel;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    private BookAdapter adapter;
    public static final String KEY_BOOK_NAME = "book_name";
    public static final String KEY_AUTHOR_NAME = "author_name";
    public static final String KEY_BOOK_ID = "book_id";

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
        adapter = new BookAdapter(list,this , this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onDelete(Book book) {
        Toast.makeText(this, "Deleted the Book " + book.getBook_name(), Toast.LENGTH_SHORT).show();
        viewModel.deleteBook(book);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_books , menu);
        MenuItem item = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent( getApplicationContext() , SearchResultActivty.class);
                intent.putExtra(KEY_BOOK_NAME , query);
                startActivity(intent);
                searchView.setIconified(true);
                searchView.setIconified(true);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}


