package com.railway.qrscanner.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.railway.qrscanner.data.model.Location;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;

  private final EntityDeletionOrUpdateAdapter<Location> __deletionAdapterOfLocation;

  private final EntityDeletionOrUpdateAdapter<Location> __updateAdapterOfLocation;

  public LocationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `locations` (`id`,`zone`,`division`,`section`,`stationCode`,`chainage`,`trackNumber`,`gpsLatitude`,`gpsLongitude`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Location entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getZone() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getZone());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDivision());
        }
        if (entity.getSection() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSection());
        }
        if (entity.getStationCode() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStationCode());
        }
        if (entity.getChainage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getChainage());
        }
        if (entity.getTrackNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTrackNumber());
        }
        if (entity.getGpsLatitude() == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.getGpsLatitude());
        }
        if (entity.getGpsLongitude() == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.getGpsLongitude());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedAt());
        }
      }
    };
    this.__deletionAdapterOfLocation = new EntityDeletionOrUpdateAdapter<Location>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `locations` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Location entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfLocation = new EntityDeletionOrUpdateAdapter<Location>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `locations` SET `id` = ?,`zone` = ?,`division` = ?,`section` = ?,`stationCode` = ?,`chainage` = ?,`trackNumber` = ?,`gpsLatitude` = ?,`gpsLongitude` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Location entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getZone() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getZone());
        }
        if (entity.getDivision() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDivision());
        }
        if (entity.getSection() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSection());
        }
        if (entity.getStationCode() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStationCode());
        }
        if (entity.getChainage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getChainage());
        }
        if (entity.getTrackNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTrackNumber());
        }
        if (entity.getGpsLatitude() == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.getGpsLatitude());
        }
        if (entity.getGpsLongitude() == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.getGpsLongitude());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedAt());
        }
        statement.bindLong(11, entity.getId());
      }
    };
  }

  @Override
  public Object insertLocation(final Location location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocation.insert(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertLocations(final List<Location> locations,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocation.insert(locations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLocation(final Location location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLocation.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLocation(final Location location,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLocation.handle(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Location>> getAllLocations() {
    final String _sql = "SELECT * FROM locations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<Location>>() {
      @Override
      @NonNull
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfZone = CursorUtil.getColumnIndexOrThrow(_cursor, "zone");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfSection = CursorUtil.getColumnIndexOrThrow(_cursor, "section");
          final int _cursorIndexOfStationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "stationCode");
          final int _cursorIndexOfChainage = CursorUtil.getColumnIndexOrThrow(_cursor, "chainage");
          final int _cursorIndexOfTrackNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackNumber");
          final int _cursorIndexOfGpsLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLatitude");
          final int _cursorIndexOfGpsLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLongitude");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Location _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpZone;
            if (_cursor.isNull(_cursorIndexOfZone)) {
              _tmpZone = null;
            } else {
              _tmpZone = _cursor.getString(_cursorIndexOfZone);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpSection;
            if (_cursor.isNull(_cursorIndexOfSection)) {
              _tmpSection = null;
            } else {
              _tmpSection = _cursor.getString(_cursorIndexOfSection);
            }
            final String _tmpStationCode;
            if (_cursor.isNull(_cursorIndexOfStationCode)) {
              _tmpStationCode = null;
            } else {
              _tmpStationCode = _cursor.getString(_cursorIndexOfStationCode);
            }
            final String _tmpChainage;
            if (_cursor.isNull(_cursorIndexOfChainage)) {
              _tmpChainage = null;
            } else {
              _tmpChainage = _cursor.getString(_cursorIndexOfChainage);
            }
            final String _tmpTrackNumber;
            if (_cursor.isNull(_cursorIndexOfTrackNumber)) {
              _tmpTrackNumber = null;
            } else {
              _tmpTrackNumber = _cursor.getString(_cursorIndexOfTrackNumber);
            }
            final Double _tmpGpsLatitude;
            if (_cursor.isNull(_cursorIndexOfGpsLatitude)) {
              _tmpGpsLatitude = null;
            } else {
              _tmpGpsLatitude = _cursor.getDouble(_cursorIndexOfGpsLatitude);
            }
            final Double _tmpGpsLongitude;
            if (_cursor.isNull(_cursorIndexOfGpsLongitude)) {
              _tmpGpsLongitude = null;
            } else {
              _tmpGpsLongitude = _cursor.getDouble(_cursorIndexOfGpsLongitude);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Location(_tmpId,_tmpZone,_tmpDivision,_tmpSection,_tmpStationCode,_tmpChainage,_tmpTrackNumber,_tmpGpsLatitude,_tmpGpsLongitude,_tmpCreatedAt);
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
    });
  }

  @Override
  public Object getLocationById(final int id, final Continuation<? super Location> $completion) {
    final String _sql = "SELECT * FROM locations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Location>() {
      @Override
      @Nullable
      public Location call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfZone = CursorUtil.getColumnIndexOrThrow(_cursor, "zone");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfSection = CursorUtil.getColumnIndexOrThrow(_cursor, "section");
          final int _cursorIndexOfStationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "stationCode");
          final int _cursorIndexOfChainage = CursorUtil.getColumnIndexOrThrow(_cursor, "chainage");
          final int _cursorIndexOfTrackNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackNumber");
          final int _cursorIndexOfGpsLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLatitude");
          final int _cursorIndexOfGpsLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLongitude");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Location _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpZone;
            if (_cursor.isNull(_cursorIndexOfZone)) {
              _tmpZone = null;
            } else {
              _tmpZone = _cursor.getString(_cursorIndexOfZone);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpSection;
            if (_cursor.isNull(_cursorIndexOfSection)) {
              _tmpSection = null;
            } else {
              _tmpSection = _cursor.getString(_cursorIndexOfSection);
            }
            final String _tmpStationCode;
            if (_cursor.isNull(_cursorIndexOfStationCode)) {
              _tmpStationCode = null;
            } else {
              _tmpStationCode = _cursor.getString(_cursorIndexOfStationCode);
            }
            final String _tmpChainage;
            if (_cursor.isNull(_cursorIndexOfChainage)) {
              _tmpChainage = null;
            } else {
              _tmpChainage = _cursor.getString(_cursorIndexOfChainage);
            }
            final String _tmpTrackNumber;
            if (_cursor.isNull(_cursorIndexOfTrackNumber)) {
              _tmpTrackNumber = null;
            } else {
              _tmpTrackNumber = _cursor.getString(_cursorIndexOfTrackNumber);
            }
            final Double _tmpGpsLatitude;
            if (_cursor.isNull(_cursorIndexOfGpsLatitude)) {
              _tmpGpsLatitude = null;
            } else {
              _tmpGpsLatitude = _cursor.getDouble(_cursorIndexOfGpsLatitude);
            }
            final Double _tmpGpsLongitude;
            if (_cursor.isNull(_cursorIndexOfGpsLongitude)) {
              _tmpGpsLongitude = null;
            } else {
              _tmpGpsLongitude = _cursor.getDouble(_cursorIndexOfGpsLongitude);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _result = new Location(_tmpId,_tmpZone,_tmpDivision,_tmpSection,_tmpStationCode,_tmpChainage,_tmpTrackNumber,_tmpGpsLatitude,_tmpGpsLongitude,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Location>> getLocationsByZone(final String zone) {
    final String _sql = "SELECT * FROM locations WHERE zone = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (zone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, zone);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<Location>>() {
      @Override
      @NonNull
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfZone = CursorUtil.getColumnIndexOrThrow(_cursor, "zone");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfSection = CursorUtil.getColumnIndexOrThrow(_cursor, "section");
          final int _cursorIndexOfStationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "stationCode");
          final int _cursorIndexOfChainage = CursorUtil.getColumnIndexOrThrow(_cursor, "chainage");
          final int _cursorIndexOfTrackNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackNumber");
          final int _cursorIndexOfGpsLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLatitude");
          final int _cursorIndexOfGpsLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLongitude");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Location _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpZone;
            if (_cursor.isNull(_cursorIndexOfZone)) {
              _tmpZone = null;
            } else {
              _tmpZone = _cursor.getString(_cursorIndexOfZone);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpSection;
            if (_cursor.isNull(_cursorIndexOfSection)) {
              _tmpSection = null;
            } else {
              _tmpSection = _cursor.getString(_cursorIndexOfSection);
            }
            final String _tmpStationCode;
            if (_cursor.isNull(_cursorIndexOfStationCode)) {
              _tmpStationCode = null;
            } else {
              _tmpStationCode = _cursor.getString(_cursorIndexOfStationCode);
            }
            final String _tmpChainage;
            if (_cursor.isNull(_cursorIndexOfChainage)) {
              _tmpChainage = null;
            } else {
              _tmpChainage = _cursor.getString(_cursorIndexOfChainage);
            }
            final String _tmpTrackNumber;
            if (_cursor.isNull(_cursorIndexOfTrackNumber)) {
              _tmpTrackNumber = null;
            } else {
              _tmpTrackNumber = _cursor.getString(_cursorIndexOfTrackNumber);
            }
            final Double _tmpGpsLatitude;
            if (_cursor.isNull(_cursorIndexOfGpsLatitude)) {
              _tmpGpsLatitude = null;
            } else {
              _tmpGpsLatitude = _cursor.getDouble(_cursorIndexOfGpsLatitude);
            }
            final Double _tmpGpsLongitude;
            if (_cursor.isNull(_cursorIndexOfGpsLongitude)) {
              _tmpGpsLongitude = null;
            } else {
              _tmpGpsLongitude = _cursor.getDouble(_cursorIndexOfGpsLongitude);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Location(_tmpId,_tmpZone,_tmpDivision,_tmpSection,_tmpStationCode,_tmpChainage,_tmpTrackNumber,_tmpGpsLatitude,_tmpGpsLongitude,_tmpCreatedAt);
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
    });
  }

  @Override
  public Flow<List<Location>> getLocationsByDivision(final String division) {
    final String _sql = "SELECT * FROM locations WHERE division = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (division == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, division);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"locations"}, new Callable<List<Location>>() {
      @Override
      @NonNull
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfZone = CursorUtil.getColumnIndexOrThrow(_cursor, "zone");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "division");
          final int _cursorIndexOfSection = CursorUtil.getColumnIndexOrThrow(_cursor, "section");
          final int _cursorIndexOfStationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "stationCode");
          final int _cursorIndexOfChainage = CursorUtil.getColumnIndexOrThrow(_cursor, "chainage");
          final int _cursorIndexOfTrackNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackNumber");
          final int _cursorIndexOfGpsLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLatitude");
          final int _cursorIndexOfGpsLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "gpsLongitude");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Location _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpZone;
            if (_cursor.isNull(_cursorIndexOfZone)) {
              _tmpZone = null;
            } else {
              _tmpZone = _cursor.getString(_cursorIndexOfZone);
            }
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            final String _tmpSection;
            if (_cursor.isNull(_cursorIndexOfSection)) {
              _tmpSection = null;
            } else {
              _tmpSection = _cursor.getString(_cursorIndexOfSection);
            }
            final String _tmpStationCode;
            if (_cursor.isNull(_cursorIndexOfStationCode)) {
              _tmpStationCode = null;
            } else {
              _tmpStationCode = _cursor.getString(_cursorIndexOfStationCode);
            }
            final String _tmpChainage;
            if (_cursor.isNull(_cursorIndexOfChainage)) {
              _tmpChainage = null;
            } else {
              _tmpChainage = _cursor.getString(_cursorIndexOfChainage);
            }
            final String _tmpTrackNumber;
            if (_cursor.isNull(_cursorIndexOfTrackNumber)) {
              _tmpTrackNumber = null;
            } else {
              _tmpTrackNumber = _cursor.getString(_cursorIndexOfTrackNumber);
            }
            final Double _tmpGpsLatitude;
            if (_cursor.isNull(_cursorIndexOfGpsLatitude)) {
              _tmpGpsLatitude = null;
            } else {
              _tmpGpsLatitude = _cursor.getDouble(_cursorIndexOfGpsLatitude);
            }
            final Double _tmpGpsLongitude;
            if (_cursor.isNull(_cursorIndexOfGpsLongitude)) {
              _tmpGpsLongitude = null;
            } else {
              _tmpGpsLongitude = _cursor.getDouble(_cursorIndexOfGpsLongitude);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Location(_tmpId,_tmpZone,_tmpDivision,_tmpSection,_tmpStationCode,_tmpChainage,_tmpTrackNumber,_tmpGpsLatitude,_tmpGpsLongitude,_tmpCreatedAt);
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
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
