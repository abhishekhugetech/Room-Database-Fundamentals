package com.epiclancers.gettingstartedwithroomdatabase.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.epiclancers.gettingstartedwithroomdatabase.room.dao.BookDao;
import com.epiclancers.gettingstartedwithroomdatabase.room.entity.Book;

@Database( entities = Book.class , version = 1)
public abstract class BookRoomDatabase extends RoomDatabase {

    public abstract BookDao bookDao();

    private static BookRoomDatabase roomDatabase;

    public static BookRoomDatabase getInstance(Context context){
        if (roomDatabase==null){
            roomDatabase = Room.databaseBuilder( context , BookRoomDatabase.class ,
                    "books_database.db")
                                .build();
        }
        return roomDatabase;
    }

}


