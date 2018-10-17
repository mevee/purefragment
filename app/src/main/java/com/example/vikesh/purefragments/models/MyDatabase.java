package com.example.vikesh.purefragments.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Images.class},version=1)
public abstract class MyDatabase extends RoomDatabase {


    public abstract ListItemDao ImagesDao();
//
//    AppDatabase db = Room.databaseBuilder(), AppDatabase.class,
//            "database-name"
//    ).build();
}
