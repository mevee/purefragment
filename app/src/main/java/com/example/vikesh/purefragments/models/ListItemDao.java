package com.example.vikesh.purefragments.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface ListItemDao {

    @Query("SELECT * FROM Images")
    LiveData<List<Images>> getAllImages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertImage(Images item);

    @Insert
    void insertAllImages(List<Images> images);

    @Query("SELECT * FROM Images WHERE id =:id")
    LiveData<Images> getImageById(int id);

    @Delete
    void deleteImage(Images image);

//    @Ignore
//    void deleteAllImage();

}
