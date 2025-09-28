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
import com.railway.qrscanner.data.model.Vendor;
import java.lang.Class;
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
public final class VendorDao_Impl implements VendorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Vendor> __insertionAdapterOfVendor;

  private final EntityDeletionOrUpdateAdapter<Vendor> __deletionAdapterOfVendor;

  private final EntityDeletionOrUpdateAdapter<Vendor> __updateAdapterOfVendor;

  public VendorDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVendor = new EntityInsertionAdapter<Vendor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `vendors` (`id`,`vendorCode`,`name`,`address`,`contactPerson`,`phone`,`email`,`certificationStatus`,`qualityRating`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vendor entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getVendorCode() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getVendorCode());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAddress());
        }
        if (entity.getContactPerson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getContactPerson());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getEmail());
        }
        if (entity.getCertificationStatus() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCertificationStatus());
        }
        statement.bindDouble(9, entity.getQualityRating());
        if (entity.getCreatedAt() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedAt());
        }
      }
    };
    this.__deletionAdapterOfVendor = new EntityDeletionOrUpdateAdapter<Vendor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `vendors` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vendor entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfVendor = new EntityDeletionOrUpdateAdapter<Vendor>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `vendors` SET `id` = ?,`vendorCode` = ?,`name` = ?,`address` = ?,`contactPerson` = ?,`phone` = ?,`email` = ?,`certificationStatus` = ?,`qualityRating` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vendor entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getVendorCode() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getVendorCode());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAddress());
        }
        if (entity.getContactPerson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getContactPerson());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getEmail());
        }
        if (entity.getCertificationStatus() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCertificationStatus());
        }
        statement.bindDouble(9, entity.getQualityRating());
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
  public Object insertVendor(final Vendor vendor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVendor.insert(vendor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertVendors(final List<Vendor> vendors,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVendor.insert(vendors);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteVendor(final Vendor vendor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfVendor.handle(vendor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateVendor(final Vendor vendor, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfVendor.handle(vendor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Vendor>> getAllVendors() {
    final String _sql = "SELECT * FROM vendors";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"vendors"}, new Callable<List<Vendor>>() {
      @Override
      @NonNull
      public List<Vendor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVendorCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorCode");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCertificationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "certificationStatus");
          final int _cursorIndexOfQualityRating = CursorUtil.getColumnIndexOrThrow(_cursor, "qualityRating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Vendor> _result = new ArrayList<Vendor>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vendor _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpVendorCode;
            if (_cursor.isNull(_cursorIndexOfVendorCode)) {
              _tmpVendorCode = null;
            } else {
              _tmpVendorCode = _cursor.getString(_cursorIndexOfVendorCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpCertificationStatus;
            if (_cursor.isNull(_cursorIndexOfCertificationStatus)) {
              _tmpCertificationStatus = null;
            } else {
              _tmpCertificationStatus = _cursor.getString(_cursorIndexOfCertificationStatus);
            }
            final double _tmpQualityRating;
            _tmpQualityRating = _cursor.getDouble(_cursorIndexOfQualityRating);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Vendor(_tmpId,_tmpVendorCode,_tmpName,_tmpAddress,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpCertificationStatus,_tmpQualityRating,_tmpCreatedAt);
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
  public Object getVendorById(final int id, final Continuation<? super Vendor> $completion) {
    final String _sql = "SELECT * FROM vendors WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Vendor>() {
      @Override
      @Nullable
      public Vendor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVendorCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorCode");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCertificationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "certificationStatus");
          final int _cursorIndexOfQualityRating = CursorUtil.getColumnIndexOrThrow(_cursor, "qualityRating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Vendor _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpVendorCode;
            if (_cursor.isNull(_cursorIndexOfVendorCode)) {
              _tmpVendorCode = null;
            } else {
              _tmpVendorCode = _cursor.getString(_cursorIndexOfVendorCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpCertificationStatus;
            if (_cursor.isNull(_cursorIndexOfCertificationStatus)) {
              _tmpCertificationStatus = null;
            } else {
              _tmpCertificationStatus = _cursor.getString(_cursorIndexOfCertificationStatus);
            }
            final double _tmpQualityRating;
            _tmpQualityRating = _cursor.getDouble(_cursorIndexOfQualityRating);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _result = new Vendor(_tmpId,_tmpVendorCode,_tmpName,_tmpAddress,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpCertificationStatus,_tmpQualityRating,_tmpCreatedAt);
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
  public Object getVendorByCode(final String vendorCode,
      final Continuation<? super Vendor> $completion) {
    final String _sql = "SELECT * FROM vendors WHERE vendorCode = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (vendorCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, vendorCode);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Vendor>() {
      @Override
      @Nullable
      public Vendor call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfVendorCode = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorCode");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCertificationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "certificationStatus");
          final int _cursorIndexOfQualityRating = CursorUtil.getColumnIndexOrThrow(_cursor, "qualityRating");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Vendor _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpVendorCode;
            if (_cursor.isNull(_cursorIndexOfVendorCode)) {
              _tmpVendorCode = null;
            } else {
              _tmpVendorCode = _cursor.getString(_cursorIndexOfVendorCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpCertificationStatus;
            if (_cursor.isNull(_cursorIndexOfCertificationStatus)) {
              _tmpCertificationStatus = null;
            } else {
              _tmpCertificationStatus = _cursor.getString(_cursorIndexOfCertificationStatus);
            }
            final double _tmpQualityRating;
            _tmpQualityRating = _cursor.getDouble(_cursorIndexOfQualityRating);
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _result = new Vendor(_tmpId,_tmpVendorCode,_tmpName,_tmpAddress,_tmpContactPerson,_tmpPhone,_tmpEmail,_tmpCertificationStatus,_tmpQualityRating,_tmpCreatedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
