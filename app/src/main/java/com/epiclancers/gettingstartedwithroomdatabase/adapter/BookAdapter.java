package com.epiclancers.gettingstartedwithroomdatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epiclancers.gettingstartedwithroomdatabase.R;
import com.epiclancers.gettingstartedwithroomdatabase.activity.MainActivity;
import com.epiclancers.gettingstartedwithroomdatabase.activity.UpdateBook;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<Book> bookList;
    Context context;
    OnDeleteClickListener onDeleteClickListener;

    public interface OnDeleteClickListener{
        public void onDelete(Book book);
    }

    public BookAdapter(List<Book> bookList, Context context,OnDeleteClickListener onDeleteClickListener) {
        this.bookList = bookList;
        this.context = context;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_book_item,viewGroup,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        Book book = bookList.get(i);
        bookViewHolder.setData(book);
    }

    public void setData(List<Book> list){
        bookList  = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        TextView bookName,authorName;
        ImageView deleteBook;
        ConstraintLayout view;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.book_name);
            authorName = itemView.findViewById(R.id.author_name);
            deleteBook = itemView.findViewById(R.id.delete_book);
            view = itemView.findViewById(R.id.cons);
        }

        public void setData(final Book book) {
            bookName.setText(book.getBook_name());
            deleteBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onDeleteClickListener!=null) onDeleteClickListener.onDelete(book);
                }
            });
            authorName.setText(book.getAuthorName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, UpdateBook.class);
                    intent.putExtra(MainActivity.KEY_BOOK_NAME , book.getBook_name());
                    intent.putExtra(MainActivity.KEY_BOOK_ID , book.getBook_id());
                    intent.putExtra(MainActivity.KEY_AUTHOR_NAME , book.getAuthorName());
                    context.startActivity(intent);
                }
            });
        }
    }

}
