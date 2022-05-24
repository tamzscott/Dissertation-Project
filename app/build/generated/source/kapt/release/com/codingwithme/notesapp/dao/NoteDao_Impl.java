package com.codingwithme.notesapp.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.codingwithme.notesapp.entities.Notes;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Notes> __insertionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __deletionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __updateAdapterOfNotes;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSpecificNote;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotes = new EntityInsertionAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Notes` (`id`,`title`,`date_time`,`note_text`,`img_path`,`web_link`,`color`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDateTime());
        }
        if (value.getNoteText() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNoteText());
        }
        if (value.getImgPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImgPath());
        }
        if (value.getWebLink() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWebLink());
        }
        if (value.getColor() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getColor());
        }
      }
    };
    this.__deletionAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Notes` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Notes` SET `id` = ?,`title` = ?,`date_time` = ?,`note_text` = ?,`img_path` = ?,`web_link` = ?,`color` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDateTime());
        }
        if (value.getNoteText() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNoteText());
        }
        if (value.getImgPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImgPath());
        }
        if (value.getWebLink() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWebLink());
        }
        if (value.getColor() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getColor());
        }
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteSpecificNote = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM notes WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNotes(final Notes note, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNotes.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteNote(final Notes note, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNotes.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateNote(final Notes note, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNotes.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteSpecificNote(final int id, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSpecificNote.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteSpecificNote.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public Object getAllNotes(final Continuation<? super List<Notes>> p0) {
    final String _sql = "SELECT * FROM notes ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "date_time");
          final int _cursorIndexOfNoteText = CursorUtil.getColumnIndexOrThrow(_cursor, "note_text");
          final int _cursorIndexOfImgPath = CursorUtil.getColumnIndexOrThrow(_cursor, "img_path");
          final int _cursorIndexOfWebLink = CursorUtil.getColumnIndexOrThrow(_cursor, "web_link");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            _item = new Notes();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpDateTime;
            _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            _item.setDateTime(_tmpDateTime);
            final String _tmpNoteText;
            _tmpNoteText = _cursor.getString(_cursorIndexOfNoteText);
            _item.setNoteText(_tmpNoteText);
            final String _tmpImgPath;
            _tmpImgPath = _cursor.getString(_cursorIndexOfImgPath);
            _item.setImgPath(_tmpImgPath);
            final String _tmpWebLink;
            _tmpWebLink = _cursor.getString(_cursorIndexOfWebLink);
            _item.setWebLink(_tmpWebLink);
            final String _tmpColor;
            _tmpColor = _cursor.getString(_cursorIndexOfColor);
            _item.setColor(_tmpColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getSpecificNote(final int id, final Continuation<? super Notes> p1) {
    final String _sql = "SELECT * FROM notes WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.execute(__db, false, new Callable<Notes>() {
      @Override
      public Notes call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "date_time");
          final int _cursorIndexOfNoteText = CursorUtil.getColumnIndexOrThrow(_cursor, "note_text");
          final int _cursorIndexOfImgPath = CursorUtil.getColumnIndexOrThrow(_cursor, "img_path");
          final int _cursorIndexOfWebLink = CursorUtil.getColumnIndexOrThrow(_cursor, "web_link");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final Notes _result;
          if(_cursor.moveToFirst()) {
            _result = new Notes();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _result.setTitle(_tmpTitle);
            final String _tmpDateTime;
            _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            _result.setDateTime(_tmpDateTime);
            final String _tmpNoteText;
            _tmpNoteText = _cursor.getString(_cursorIndexOfNoteText);
            _result.setNoteText(_tmpNoteText);
            final String _tmpImgPath;
            _tmpImgPath = _cursor.getString(_cursorIndexOfImgPath);
            _result.setImgPath(_tmpImgPath);
            final String _tmpWebLink;
            _tmpWebLink = _cursor.getString(_cursorIndexOfWebLink);
            _result.setWebLink(_tmpWebLink);
            final String _tmpColor;
            _tmpColor = _cursor.getString(_cursorIndexOfColor);
            _result.setColor(_tmpColor);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
