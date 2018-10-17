package com.example.vikesh.purefragments.models;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ListItemDao_Impl implements ListItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfImages;

  private final EntityInsertionAdapter __insertionAdapterOfImages_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfImages;

  public ListItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImages = new EntityInsertionAdapter<Images>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Images`(`albumId`,`id`,`title`,`url`,`thumbnailUrl`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Images value) {
        stmt.bindLong(1, value.getAlbumId());
        stmt.bindLong(2, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrl());
        }
        if (value.getThumbnailUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getThumbnailUrl());
        }
      }
    };
    this.__insertionAdapterOfImages_1 = new EntityInsertionAdapter<Images>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Images`(`albumId`,`id`,`title`,`url`,`thumbnailUrl`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Images value) {
        stmt.bindLong(1, value.getAlbumId());
        stmt.bindLong(2, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrl());
        }
        if (value.getThumbnailUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getThumbnailUrl());
        }
      }
    };
    this.__deletionAdapterOfImages = new EntityDeletionOrUpdateAdapter<Images>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Images` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Images value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Long insertImage(Images item) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfImages.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAllImages(List<Images> images) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfImages_1.insert(images);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteImage(Images image) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfImages.handle(image);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Images>> getAllImages() {
    final String _sql = "SELECT * FROM Images";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Images>>() {
      private Observer _observer;

      @Override
      protected List<Images> compute() {
        if (_observer == null) {
          _observer = new Observer("Images") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfAlbumId = _cursor.getColumnIndexOrThrow("albumId");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfUrl = _cursor.getColumnIndexOrThrow("url");
          final int _cursorIndexOfThumbnailUrl = _cursor.getColumnIndexOrThrow("thumbnailUrl");
          final List<Images> _result = new ArrayList<Images>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Images _item;
            final int _tmpAlbumId;
            _tmpAlbumId = _cursor.getInt(_cursorIndexOfAlbumId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpThumbnailUrl;
            _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            _item = new Images(_tmpAlbumId,_tmpId,_tmpTitle,_tmpUrl,_tmpThumbnailUrl);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Images> getImageById(int id) {
    final String _sql = "SELECT * FROM Images WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<Images>() {
      private Observer _observer;

      @Override
      protected Images compute() {
        if (_observer == null) {
          _observer = new Observer("Images") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfAlbumId = _cursor.getColumnIndexOrThrow("albumId");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
          final int _cursorIndexOfUrl = _cursor.getColumnIndexOrThrow("url");
          final int _cursorIndexOfThumbnailUrl = _cursor.getColumnIndexOrThrow("thumbnailUrl");
          final Images _result;
          if(_cursor.moveToFirst()) {
            final int _tmpAlbumId;
            _tmpAlbumId = _cursor.getInt(_cursorIndexOfAlbumId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpThumbnailUrl;
            _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
            _result = new Images(_tmpAlbumId,_tmpId,_tmpTitle,_tmpUrl,_tmpThumbnailUrl);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
