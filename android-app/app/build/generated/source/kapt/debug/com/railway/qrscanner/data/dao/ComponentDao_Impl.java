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
import com.railway.qrscanner.data.model.Component;
import com.railway.qrscanner.data.model.ComponentStatus;
import com.railway.qrscanner.data.model.ComponentType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
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
public final class ComponentDao_Impl implements ComponentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Component> __insertionAdapterOfComponent;

  private final EntityDeletionOrUpdateAdapter<Component> __deletionAdapterOfComponent;

  private final EntityDeletionOrUpdateAdapter<Component> __updateAdapterOfComponent;

  public ComponentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfComponent = new EntityInsertionAdapter<Component>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `components` (`serialId`,`componentType`,`materialSpecification`,`batchNumber`,`lotNumber`,`poNumber`,`manufacturingDate`,`dispatchDate`,`receivingDate`,`installationDate`,`warrantyStartDate`,`warrantyEndDate`,`currentStatus`,`qrCodePath`,`vendorId`,`locationId`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Component entity) {
        if (entity.getSerialId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getSerialId());
        }
        statement.bindString(2, __ComponentType_enumToString(entity.getComponentType()));
        if (entity.getMaterialSpecification() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMaterialSpecification());
        }
        if (entity.getBatchNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBatchNumber());
        }
        if (entity.getLotNumber() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLotNumber());
        }
        if (entity.getPoNumber() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPoNumber());
        }
        if (entity.getManufacturingDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getManufacturingDate());
        }
        if (entity.getDispatchDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDispatchDate());
        }
        if (entity.getReceivingDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getReceivingDate());
        }
        if (entity.getInstallationDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getInstallationDate());
        }
        if (entity.getWarrantyStartDate() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getWarrantyStartDate());
        }
        if (entity.getWarrantyEndDate() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getWarrantyEndDate());
        }
        statement.bindString(13, __ComponentStatus_enumToString(entity.getCurrentStatus()));
        if (entity.getQrCodePath() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getQrCodePath());
        }
        statement.bindLong(15, entity.getVendorId());
        if (entity.getLocationId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindLong(16, entity.getLocationId());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getUpdatedAt());
        }
      }
    };
    this.__deletionAdapterOfComponent = new EntityDeletionOrUpdateAdapter<Component>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `components` WHERE `serialId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Component entity) {
        if (entity.getSerialId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getSerialId());
        }
      }
    };
    this.__updateAdapterOfComponent = new EntityDeletionOrUpdateAdapter<Component>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `components` SET `serialId` = ?,`componentType` = ?,`materialSpecification` = ?,`batchNumber` = ?,`lotNumber` = ?,`poNumber` = ?,`manufacturingDate` = ?,`dispatchDate` = ?,`receivingDate` = ?,`installationDate` = ?,`warrantyStartDate` = ?,`warrantyEndDate` = ?,`currentStatus` = ?,`qrCodePath` = ?,`vendorId` = ?,`locationId` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `serialId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Component entity) {
        if (entity.getSerialId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getSerialId());
        }
        statement.bindString(2, __ComponentType_enumToString(entity.getComponentType()));
        if (entity.getMaterialSpecification() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMaterialSpecification());
        }
        if (entity.getBatchNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBatchNumber());
        }
        if (entity.getLotNumber() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLotNumber());
        }
        if (entity.getPoNumber() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPoNumber());
        }
        if (entity.getManufacturingDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getManufacturingDate());
        }
        if (entity.getDispatchDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDispatchDate());
        }
        if (entity.getReceivingDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getReceivingDate());
        }
        if (entity.getInstallationDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getInstallationDate());
        }
        if (entity.getWarrantyStartDate() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getWarrantyStartDate());
        }
        if (entity.getWarrantyEndDate() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getWarrantyEndDate());
        }
        statement.bindString(13, __ComponentStatus_enumToString(entity.getCurrentStatus()));
        if (entity.getQrCodePath() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getQrCodePath());
        }
        statement.bindLong(15, entity.getVendorId());
        if (entity.getLocationId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindLong(16, entity.getLocationId());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getUpdatedAt());
        }
        if (entity.getSerialId() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getSerialId());
        }
      }
    };
  }

  @Override
  public Object insertComponent(final Component component,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfComponent.insert(component);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertComponents(final List<Component> components,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfComponent.insert(components);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteComponent(final Component component,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfComponent.handle(component);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateComponent(final Component component,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfComponent.handle(component);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Component>> getAllComponents() {
    final String _sql = "SELECT * FROM components";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"components"}, new Callable<List<Component>>() {
      @Override
      @NonNull
      public List<Component> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Component> _result = new ArrayList<Component>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Component _item;
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getComponentBySerialId(final String serialId,
      final Continuation<? super Component> $completion) {
    final String _sql = "SELECT * FROM components WHERE serialId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (serialId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, serialId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Component>() {
      @Override
      @Nullable
      public Component call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Component _result;
          if (_cursor.moveToFirst()) {
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _result = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Component>> getComponentsByType(final String type) {
    final String _sql = "SELECT * FROM components WHERE componentType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"components"}, new Callable<List<Component>>() {
      @Override
      @NonNull
      public List<Component> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Component> _result = new ArrayList<Component>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Component _item;
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Component>> getComponentsByStatus(final String status) {
    final String _sql = "SELECT * FROM components WHERE currentStatus = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"components"}, new Callable<List<Component>>() {
      @Override
      @NonNull
      public List<Component> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Component> _result = new ArrayList<Component>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Component _item;
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Component>> getComponentsByVendor(final int vendorId) {
    final String _sql = "SELECT * FROM components WHERE vendorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, vendorId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"components"}, new Callable<List<Component>>() {
      @Override
      @NonNull
      public List<Component> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Component> _result = new ArrayList<Component>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Component _item;
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getComponentCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM components";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Object getComponentCountByType(final String type,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM components WHERE componentType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Object getFirstComponent(final Continuation<? super Component> $completion) {
    final String _sql = "SELECT * FROM components LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Component>() {
      @Override
      @Nullable
      public Component call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSerialId = CursorUtil.getColumnIndexOrThrow(_cursor, "serialId");
          final int _cursorIndexOfComponentType = CursorUtil.getColumnIndexOrThrow(_cursor, "componentType");
          final int _cursorIndexOfMaterialSpecification = CursorUtil.getColumnIndexOrThrow(_cursor, "materialSpecification");
          final int _cursorIndexOfBatchNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "batchNumber");
          final int _cursorIndexOfLotNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "lotNumber");
          final int _cursorIndexOfPoNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "poNumber");
          final int _cursorIndexOfManufacturingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturingDate");
          final int _cursorIndexOfDispatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dispatchDate");
          final int _cursorIndexOfReceivingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "receivingDate");
          final int _cursorIndexOfInstallationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "installationDate");
          final int _cursorIndexOfWarrantyStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyStartDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfCurrentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStatus");
          final int _cursorIndexOfQrCodePath = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodePath");
          final int _cursorIndexOfVendorId = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorId");
          final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "locationId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Component _result;
          if (_cursor.moveToFirst()) {
            final String _tmpSerialId;
            if (_cursor.isNull(_cursorIndexOfSerialId)) {
              _tmpSerialId = null;
            } else {
              _tmpSerialId = _cursor.getString(_cursorIndexOfSerialId);
            }
            final ComponentType _tmpComponentType;
            _tmpComponentType = __ComponentType_stringToEnum(_cursor.getString(_cursorIndexOfComponentType));
            final String _tmpMaterialSpecification;
            if (_cursor.isNull(_cursorIndexOfMaterialSpecification)) {
              _tmpMaterialSpecification = null;
            } else {
              _tmpMaterialSpecification = _cursor.getString(_cursorIndexOfMaterialSpecification);
            }
            final String _tmpBatchNumber;
            if (_cursor.isNull(_cursorIndexOfBatchNumber)) {
              _tmpBatchNumber = null;
            } else {
              _tmpBatchNumber = _cursor.getString(_cursorIndexOfBatchNumber);
            }
            final String _tmpLotNumber;
            if (_cursor.isNull(_cursorIndexOfLotNumber)) {
              _tmpLotNumber = null;
            } else {
              _tmpLotNumber = _cursor.getString(_cursorIndexOfLotNumber);
            }
            final String _tmpPoNumber;
            if (_cursor.isNull(_cursorIndexOfPoNumber)) {
              _tmpPoNumber = null;
            } else {
              _tmpPoNumber = _cursor.getString(_cursorIndexOfPoNumber);
            }
            final String _tmpManufacturingDate;
            if (_cursor.isNull(_cursorIndexOfManufacturingDate)) {
              _tmpManufacturingDate = null;
            } else {
              _tmpManufacturingDate = _cursor.getString(_cursorIndexOfManufacturingDate);
            }
            final String _tmpDispatchDate;
            if (_cursor.isNull(_cursorIndexOfDispatchDate)) {
              _tmpDispatchDate = null;
            } else {
              _tmpDispatchDate = _cursor.getString(_cursorIndexOfDispatchDate);
            }
            final String _tmpReceivingDate;
            if (_cursor.isNull(_cursorIndexOfReceivingDate)) {
              _tmpReceivingDate = null;
            } else {
              _tmpReceivingDate = _cursor.getString(_cursorIndexOfReceivingDate);
            }
            final String _tmpInstallationDate;
            if (_cursor.isNull(_cursorIndexOfInstallationDate)) {
              _tmpInstallationDate = null;
            } else {
              _tmpInstallationDate = _cursor.getString(_cursorIndexOfInstallationDate);
            }
            final String _tmpWarrantyStartDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyStartDate)) {
              _tmpWarrantyStartDate = null;
            } else {
              _tmpWarrantyStartDate = _cursor.getString(_cursorIndexOfWarrantyStartDate);
            }
            final String _tmpWarrantyEndDate;
            if (_cursor.isNull(_cursorIndexOfWarrantyEndDate)) {
              _tmpWarrantyEndDate = null;
            } else {
              _tmpWarrantyEndDate = _cursor.getString(_cursorIndexOfWarrantyEndDate);
            }
            final ComponentStatus _tmpCurrentStatus;
            _tmpCurrentStatus = __ComponentStatus_stringToEnum(_cursor.getString(_cursorIndexOfCurrentStatus));
            final String _tmpQrCodePath;
            if (_cursor.isNull(_cursorIndexOfQrCodePath)) {
              _tmpQrCodePath = null;
            } else {
              _tmpQrCodePath = _cursor.getString(_cursorIndexOfQrCodePath);
            }
            final int _tmpVendorId;
            _tmpVendorId = _cursor.getInt(_cursorIndexOfVendorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _result = new Component(_tmpSerialId,_tmpComponentType,_tmpMaterialSpecification,_tmpBatchNumber,_tmpLotNumber,_tmpPoNumber,_tmpManufacturingDate,_tmpDispatchDate,_tmpReceivingDate,_tmpInstallationDate,_tmpWarrantyStartDate,_tmpWarrantyEndDate,_tmpCurrentStatus,_tmpQrCodePath,_tmpVendorId,_tmpLocationId,_tmpCreatedAt,_tmpUpdatedAt);
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

  private String __ComponentType_enumToString(@NonNull final ComponentType _value) {
    switch (_value) {
      case ELASTIC_RAIL_CLIP: return "ELASTIC_RAIL_CLIP";
      case LINER: return "LINER";
      case RAIL_PAD: return "RAIL_PAD";
      case SLEEPER: return "SLEEPER";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __ComponentStatus_enumToString(@NonNull final ComponentStatus _value) {
    switch (_value) {
      case MANUFACTURED: return "MANUFACTURED";
      case SHIPPED: return "SHIPPED";
      case RECEIVED: return "RECEIVED";
      case INSTALLED: return "INSTALLED";
      case IN_SERVICE: return "IN_SERVICE";
      case MAINTENANCE: return "MAINTENANCE";
      case FAILED: return "FAILED";
      case WITHDRAWN: return "WITHDRAWN";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private ComponentType __ComponentType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "ELASTIC_RAIL_CLIP": return ComponentType.ELASTIC_RAIL_CLIP;
      case "LINER": return ComponentType.LINER;
      case "RAIL_PAD": return ComponentType.RAIL_PAD;
      case "SLEEPER": return ComponentType.SLEEPER;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private ComponentStatus __ComponentStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "MANUFACTURED": return ComponentStatus.MANUFACTURED;
      case "SHIPPED": return ComponentStatus.SHIPPED;
      case "RECEIVED": return ComponentStatus.RECEIVED;
      case "INSTALLED": return ComponentStatus.INSTALLED;
      case "IN_SERVICE": return ComponentStatus.IN_SERVICE;
      case "MAINTENANCE": return ComponentStatus.MAINTENANCE;
      case "FAILED": return ComponentStatus.FAILED;
      case "WITHDRAWN": return ComponentStatus.WITHDRAWN;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
