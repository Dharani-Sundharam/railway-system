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
import com.railway.qrscanner.data.model.Inspection;
import com.railway.qrscanner.data.model.InspectionStatus;
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
public final class InspectionDao_Impl implements InspectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Inspection> __insertionAdapterOfInspection;

  private final EntityDeletionOrUpdateAdapter<Inspection> __deletionAdapterOfInspection;

  private final EntityDeletionOrUpdateAdapter<Inspection> __updateAdapterOfInspection;

  public InspectionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInspection = new EntityInsertionAdapter<Inspection>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `inspections` (`id`,`componentId`,`inspectorId`,`inspectionType`,`inspectionDate`,`status`,`findings`,`recommendations`,`nextInspectionDue`,`defectCategory`,`severityLevel`,`measurements`,`photos`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Inspection entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getComponentId());
        if (entity.getInspectorId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getInspectorId());
        }
        if (entity.getInspectionType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getInspectionType());
        }
        if (entity.getInspectionDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getInspectionDate());
        }
        statement.bindString(6, __InspectionStatus_enumToString(entity.getStatus()));
        if (entity.getFindings() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFindings());
        }
        if (entity.getRecommendations() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getRecommendations());
        }
        if (entity.getNextInspectionDue() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNextInspectionDue());
        }
        if (entity.getDefectCategory() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDefectCategory());
        }
        if (entity.getSeverityLevel() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSeverityLevel());
        }
        if (entity.getMeasurements() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getMeasurements());
        }
        if (entity.getPhotos() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getPhotos());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
      }
    };
    this.__deletionAdapterOfInspection = new EntityDeletionOrUpdateAdapter<Inspection>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `inspections` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Inspection entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfInspection = new EntityDeletionOrUpdateAdapter<Inspection>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `inspections` SET `id` = ?,`componentId` = ?,`inspectorId` = ?,`inspectionType` = ?,`inspectionDate` = ?,`status` = ?,`findings` = ?,`recommendations` = ?,`nextInspectionDue` = ?,`defectCategory` = ?,`severityLevel` = ?,`measurements` = ?,`photos` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Inspection entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getComponentId());
        if (entity.getInspectorId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getInspectorId());
        }
        if (entity.getInspectionType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getInspectionType());
        }
        if (entity.getInspectionDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getInspectionDate());
        }
        statement.bindString(6, __InspectionStatus_enumToString(entity.getStatus()));
        if (entity.getFindings() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFindings());
        }
        if (entity.getRecommendations() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getRecommendations());
        }
        if (entity.getNextInspectionDue() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNextInspectionDue());
        }
        if (entity.getDefectCategory() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDefectCategory());
        }
        if (entity.getSeverityLevel() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getSeverityLevel());
        }
        if (entity.getMeasurements() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getMeasurements());
        }
        if (entity.getPhotos() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getPhotos());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
        statement.bindLong(15, entity.getId());
      }
    };
  }

  @Override
  public Object insertInspection(final Inspection inspection,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInspection.insert(inspection);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertInspections(final List<Inspection> inspections,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInspection.insert(inspections);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteInspection(final Inspection inspection,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfInspection.handle(inspection);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateInspection(final Inspection inspection,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfInspection.handle(inspection);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Inspection>> getAllInspections() {
    final String _sql = "SELECT * FROM inspections";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inspections"}, new Callable<List<Inspection>>() {
      @Override
      @NonNull
      public List<Inspection> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfComponentId = CursorUtil.getColumnIndexOrThrow(_cursor, "componentId");
          final int _cursorIndexOfInspectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectorId");
          final int _cursorIndexOfInspectionType = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionType");
          final int _cursorIndexOfInspectionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfFindings = CursorUtil.getColumnIndexOrThrow(_cursor, "findings");
          final int _cursorIndexOfRecommendations = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendations");
          final int _cursorIndexOfNextInspectionDue = CursorUtil.getColumnIndexOrThrow(_cursor, "nextInspectionDue");
          final int _cursorIndexOfDefectCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "defectCategory");
          final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severityLevel");
          final int _cursorIndexOfMeasurements = CursorUtil.getColumnIndexOrThrow(_cursor, "measurements");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Inspection> _result = new ArrayList<Inspection>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Inspection _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpComponentId;
            _tmpComponentId = _cursor.getInt(_cursorIndexOfComponentId);
            final Integer _tmpInspectorId;
            if (_cursor.isNull(_cursorIndexOfInspectorId)) {
              _tmpInspectorId = null;
            } else {
              _tmpInspectorId = _cursor.getInt(_cursorIndexOfInspectorId);
            }
            final String _tmpInspectionType;
            if (_cursor.isNull(_cursorIndexOfInspectionType)) {
              _tmpInspectionType = null;
            } else {
              _tmpInspectionType = _cursor.getString(_cursorIndexOfInspectionType);
            }
            final String _tmpInspectionDate;
            if (_cursor.isNull(_cursorIndexOfInspectionDate)) {
              _tmpInspectionDate = null;
            } else {
              _tmpInspectionDate = _cursor.getString(_cursorIndexOfInspectionDate);
            }
            final InspectionStatus _tmpStatus;
            _tmpStatus = __InspectionStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpFindings;
            if (_cursor.isNull(_cursorIndexOfFindings)) {
              _tmpFindings = null;
            } else {
              _tmpFindings = _cursor.getString(_cursorIndexOfFindings);
            }
            final String _tmpRecommendations;
            if (_cursor.isNull(_cursorIndexOfRecommendations)) {
              _tmpRecommendations = null;
            } else {
              _tmpRecommendations = _cursor.getString(_cursorIndexOfRecommendations);
            }
            final String _tmpNextInspectionDue;
            if (_cursor.isNull(_cursorIndexOfNextInspectionDue)) {
              _tmpNextInspectionDue = null;
            } else {
              _tmpNextInspectionDue = _cursor.getString(_cursorIndexOfNextInspectionDue);
            }
            final String _tmpDefectCategory;
            if (_cursor.isNull(_cursorIndexOfDefectCategory)) {
              _tmpDefectCategory = null;
            } else {
              _tmpDefectCategory = _cursor.getString(_cursorIndexOfDefectCategory);
            }
            final String _tmpSeverityLevel;
            if (_cursor.isNull(_cursorIndexOfSeverityLevel)) {
              _tmpSeverityLevel = null;
            } else {
              _tmpSeverityLevel = _cursor.getString(_cursorIndexOfSeverityLevel);
            }
            final String _tmpMeasurements;
            if (_cursor.isNull(_cursorIndexOfMeasurements)) {
              _tmpMeasurements = null;
            } else {
              _tmpMeasurements = _cursor.getString(_cursorIndexOfMeasurements);
            }
            final String _tmpPhotos;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmpPhotos = null;
            } else {
              _tmpPhotos = _cursor.getString(_cursorIndexOfPhotos);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Inspection(_tmpId,_tmpComponentId,_tmpInspectorId,_tmpInspectionType,_tmpInspectionDate,_tmpStatus,_tmpFindings,_tmpRecommendations,_tmpNextInspectionDue,_tmpDefectCategory,_tmpSeverityLevel,_tmpMeasurements,_tmpPhotos,_tmpCreatedAt);
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
  public Object getInspectionById(final int id,
      final Continuation<? super Inspection> $completion) {
    final String _sql = "SELECT * FROM inspections WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Inspection>() {
      @Override
      @Nullable
      public Inspection call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfComponentId = CursorUtil.getColumnIndexOrThrow(_cursor, "componentId");
          final int _cursorIndexOfInspectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectorId");
          final int _cursorIndexOfInspectionType = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionType");
          final int _cursorIndexOfInspectionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfFindings = CursorUtil.getColumnIndexOrThrow(_cursor, "findings");
          final int _cursorIndexOfRecommendations = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendations");
          final int _cursorIndexOfNextInspectionDue = CursorUtil.getColumnIndexOrThrow(_cursor, "nextInspectionDue");
          final int _cursorIndexOfDefectCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "defectCategory");
          final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severityLevel");
          final int _cursorIndexOfMeasurements = CursorUtil.getColumnIndexOrThrow(_cursor, "measurements");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Inspection _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpComponentId;
            _tmpComponentId = _cursor.getInt(_cursorIndexOfComponentId);
            final Integer _tmpInspectorId;
            if (_cursor.isNull(_cursorIndexOfInspectorId)) {
              _tmpInspectorId = null;
            } else {
              _tmpInspectorId = _cursor.getInt(_cursorIndexOfInspectorId);
            }
            final String _tmpInspectionType;
            if (_cursor.isNull(_cursorIndexOfInspectionType)) {
              _tmpInspectionType = null;
            } else {
              _tmpInspectionType = _cursor.getString(_cursorIndexOfInspectionType);
            }
            final String _tmpInspectionDate;
            if (_cursor.isNull(_cursorIndexOfInspectionDate)) {
              _tmpInspectionDate = null;
            } else {
              _tmpInspectionDate = _cursor.getString(_cursorIndexOfInspectionDate);
            }
            final InspectionStatus _tmpStatus;
            _tmpStatus = __InspectionStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpFindings;
            if (_cursor.isNull(_cursorIndexOfFindings)) {
              _tmpFindings = null;
            } else {
              _tmpFindings = _cursor.getString(_cursorIndexOfFindings);
            }
            final String _tmpRecommendations;
            if (_cursor.isNull(_cursorIndexOfRecommendations)) {
              _tmpRecommendations = null;
            } else {
              _tmpRecommendations = _cursor.getString(_cursorIndexOfRecommendations);
            }
            final String _tmpNextInspectionDue;
            if (_cursor.isNull(_cursorIndexOfNextInspectionDue)) {
              _tmpNextInspectionDue = null;
            } else {
              _tmpNextInspectionDue = _cursor.getString(_cursorIndexOfNextInspectionDue);
            }
            final String _tmpDefectCategory;
            if (_cursor.isNull(_cursorIndexOfDefectCategory)) {
              _tmpDefectCategory = null;
            } else {
              _tmpDefectCategory = _cursor.getString(_cursorIndexOfDefectCategory);
            }
            final String _tmpSeverityLevel;
            if (_cursor.isNull(_cursorIndexOfSeverityLevel)) {
              _tmpSeverityLevel = null;
            } else {
              _tmpSeverityLevel = _cursor.getString(_cursorIndexOfSeverityLevel);
            }
            final String _tmpMeasurements;
            if (_cursor.isNull(_cursorIndexOfMeasurements)) {
              _tmpMeasurements = null;
            } else {
              _tmpMeasurements = _cursor.getString(_cursorIndexOfMeasurements);
            }
            final String _tmpPhotos;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmpPhotos = null;
            } else {
              _tmpPhotos = _cursor.getString(_cursorIndexOfPhotos);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _result = new Inspection(_tmpId,_tmpComponentId,_tmpInspectorId,_tmpInspectionType,_tmpInspectionDate,_tmpStatus,_tmpFindings,_tmpRecommendations,_tmpNextInspectionDue,_tmpDefectCategory,_tmpSeverityLevel,_tmpMeasurements,_tmpPhotos,_tmpCreatedAt);
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
  public Flow<List<Inspection>> getInspectionsByComponent(final int componentId) {
    final String _sql = "SELECT * FROM inspections WHERE componentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, componentId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inspections"}, new Callable<List<Inspection>>() {
      @Override
      @NonNull
      public List<Inspection> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfComponentId = CursorUtil.getColumnIndexOrThrow(_cursor, "componentId");
          final int _cursorIndexOfInspectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectorId");
          final int _cursorIndexOfInspectionType = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionType");
          final int _cursorIndexOfInspectionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfFindings = CursorUtil.getColumnIndexOrThrow(_cursor, "findings");
          final int _cursorIndexOfRecommendations = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendations");
          final int _cursorIndexOfNextInspectionDue = CursorUtil.getColumnIndexOrThrow(_cursor, "nextInspectionDue");
          final int _cursorIndexOfDefectCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "defectCategory");
          final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severityLevel");
          final int _cursorIndexOfMeasurements = CursorUtil.getColumnIndexOrThrow(_cursor, "measurements");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Inspection> _result = new ArrayList<Inspection>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Inspection _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpComponentId;
            _tmpComponentId = _cursor.getInt(_cursorIndexOfComponentId);
            final Integer _tmpInspectorId;
            if (_cursor.isNull(_cursorIndexOfInspectorId)) {
              _tmpInspectorId = null;
            } else {
              _tmpInspectorId = _cursor.getInt(_cursorIndexOfInspectorId);
            }
            final String _tmpInspectionType;
            if (_cursor.isNull(_cursorIndexOfInspectionType)) {
              _tmpInspectionType = null;
            } else {
              _tmpInspectionType = _cursor.getString(_cursorIndexOfInspectionType);
            }
            final String _tmpInspectionDate;
            if (_cursor.isNull(_cursorIndexOfInspectionDate)) {
              _tmpInspectionDate = null;
            } else {
              _tmpInspectionDate = _cursor.getString(_cursorIndexOfInspectionDate);
            }
            final InspectionStatus _tmpStatus;
            _tmpStatus = __InspectionStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpFindings;
            if (_cursor.isNull(_cursorIndexOfFindings)) {
              _tmpFindings = null;
            } else {
              _tmpFindings = _cursor.getString(_cursorIndexOfFindings);
            }
            final String _tmpRecommendations;
            if (_cursor.isNull(_cursorIndexOfRecommendations)) {
              _tmpRecommendations = null;
            } else {
              _tmpRecommendations = _cursor.getString(_cursorIndexOfRecommendations);
            }
            final String _tmpNextInspectionDue;
            if (_cursor.isNull(_cursorIndexOfNextInspectionDue)) {
              _tmpNextInspectionDue = null;
            } else {
              _tmpNextInspectionDue = _cursor.getString(_cursorIndexOfNextInspectionDue);
            }
            final String _tmpDefectCategory;
            if (_cursor.isNull(_cursorIndexOfDefectCategory)) {
              _tmpDefectCategory = null;
            } else {
              _tmpDefectCategory = _cursor.getString(_cursorIndexOfDefectCategory);
            }
            final String _tmpSeverityLevel;
            if (_cursor.isNull(_cursorIndexOfSeverityLevel)) {
              _tmpSeverityLevel = null;
            } else {
              _tmpSeverityLevel = _cursor.getString(_cursorIndexOfSeverityLevel);
            }
            final String _tmpMeasurements;
            if (_cursor.isNull(_cursorIndexOfMeasurements)) {
              _tmpMeasurements = null;
            } else {
              _tmpMeasurements = _cursor.getString(_cursorIndexOfMeasurements);
            }
            final String _tmpPhotos;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmpPhotos = null;
            } else {
              _tmpPhotos = _cursor.getString(_cursorIndexOfPhotos);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Inspection(_tmpId,_tmpComponentId,_tmpInspectorId,_tmpInspectionType,_tmpInspectionDate,_tmpStatus,_tmpFindings,_tmpRecommendations,_tmpNextInspectionDue,_tmpDefectCategory,_tmpSeverityLevel,_tmpMeasurements,_tmpPhotos,_tmpCreatedAt);
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
  public Flow<List<Inspection>> getInspectionsByInspector(final int inspectorId) {
    final String _sql = "SELECT * FROM inspections WHERE inspectorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, inspectorId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inspections"}, new Callable<List<Inspection>>() {
      @Override
      @NonNull
      public List<Inspection> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfComponentId = CursorUtil.getColumnIndexOrThrow(_cursor, "componentId");
          final int _cursorIndexOfInspectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectorId");
          final int _cursorIndexOfInspectionType = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionType");
          final int _cursorIndexOfInspectionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfFindings = CursorUtil.getColumnIndexOrThrow(_cursor, "findings");
          final int _cursorIndexOfRecommendations = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendations");
          final int _cursorIndexOfNextInspectionDue = CursorUtil.getColumnIndexOrThrow(_cursor, "nextInspectionDue");
          final int _cursorIndexOfDefectCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "defectCategory");
          final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severityLevel");
          final int _cursorIndexOfMeasurements = CursorUtil.getColumnIndexOrThrow(_cursor, "measurements");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Inspection> _result = new ArrayList<Inspection>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Inspection _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpComponentId;
            _tmpComponentId = _cursor.getInt(_cursorIndexOfComponentId);
            final Integer _tmpInspectorId;
            if (_cursor.isNull(_cursorIndexOfInspectorId)) {
              _tmpInspectorId = null;
            } else {
              _tmpInspectorId = _cursor.getInt(_cursorIndexOfInspectorId);
            }
            final String _tmpInspectionType;
            if (_cursor.isNull(_cursorIndexOfInspectionType)) {
              _tmpInspectionType = null;
            } else {
              _tmpInspectionType = _cursor.getString(_cursorIndexOfInspectionType);
            }
            final String _tmpInspectionDate;
            if (_cursor.isNull(_cursorIndexOfInspectionDate)) {
              _tmpInspectionDate = null;
            } else {
              _tmpInspectionDate = _cursor.getString(_cursorIndexOfInspectionDate);
            }
            final InspectionStatus _tmpStatus;
            _tmpStatus = __InspectionStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpFindings;
            if (_cursor.isNull(_cursorIndexOfFindings)) {
              _tmpFindings = null;
            } else {
              _tmpFindings = _cursor.getString(_cursorIndexOfFindings);
            }
            final String _tmpRecommendations;
            if (_cursor.isNull(_cursorIndexOfRecommendations)) {
              _tmpRecommendations = null;
            } else {
              _tmpRecommendations = _cursor.getString(_cursorIndexOfRecommendations);
            }
            final String _tmpNextInspectionDue;
            if (_cursor.isNull(_cursorIndexOfNextInspectionDue)) {
              _tmpNextInspectionDue = null;
            } else {
              _tmpNextInspectionDue = _cursor.getString(_cursorIndexOfNextInspectionDue);
            }
            final String _tmpDefectCategory;
            if (_cursor.isNull(_cursorIndexOfDefectCategory)) {
              _tmpDefectCategory = null;
            } else {
              _tmpDefectCategory = _cursor.getString(_cursorIndexOfDefectCategory);
            }
            final String _tmpSeverityLevel;
            if (_cursor.isNull(_cursorIndexOfSeverityLevel)) {
              _tmpSeverityLevel = null;
            } else {
              _tmpSeverityLevel = _cursor.getString(_cursorIndexOfSeverityLevel);
            }
            final String _tmpMeasurements;
            if (_cursor.isNull(_cursorIndexOfMeasurements)) {
              _tmpMeasurements = null;
            } else {
              _tmpMeasurements = _cursor.getString(_cursorIndexOfMeasurements);
            }
            final String _tmpPhotos;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmpPhotos = null;
            } else {
              _tmpPhotos = _cursor.getString(_cursorIndexOfPhotos);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Inspection(_tmpId,_tmpComponentId,_tmpInspectorId,_tmpInspectionType,_tmpInspectionDate,_tmpStatus,_tmpFindings,_tmpRecommendations,_tmpNextInspectionDue,_tmpDefectCategory,_tmpSeverityLevel,_tmpMeasurements,_tmpPhotos,_tmpCreatedAt);
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
  public Flow<List<Inspection>> getInspectionsByStatus(final String status) {
    final String _sql = "SELECT * FROM inspections WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inspections"}, new Callable<List<Inspection>>() {
      @Override
      @NonNull
      public List<Inspection> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfComponentId = CursorUtil.getColumnIndexOrThrow(_cursor, "componentId");
          final int _cursorIndexOfInspectorId = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectorId");
          final int _cursorIndexOfInspectionType = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionType");
          final int _cursorIndexOfInspectionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "inspectionDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfFindings = CursorUtil.getColumnIndexOrThrow(_cursor, "findings");
          final int _cursorIndexOfRecommendations = CursorUtil.getColumnIndexOrThrow(_cursor, "recommendations");
          final int _cursorIndexOfNextInspectionDue = CursorUtil.getColumnIndexOrThrow(_cursor, "nextInspectionDue");
          final int _cursorIndexOfDefectCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "defectCategory");
          final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severityLevel");
          final int _cursorIndexOfMeasurements = CursorUtil.getColumnIndexOrThrow(_cursor, "measurements");
          final int _cursorIndexOfPhotos = CursorUtil.getColumnIndexOrThrow(_cursor, "photos");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Inspection> _result = new ArrayList<Inspection>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Inspection _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpComponentId;
            _tmpComponentId = _cursor.getInt(_cursorIndexOfComponentId);
            final Integer _tmpInspectorId;
            if (_cursor.isNull(_cursorIndexOfInspectorId)) {
              _tmpInspectorId = null;
            } else {
              _tmpInspectorId = _cursor.getInt(_cursorIndexOfInspectorId);
            }
            final String _tmpInspectionType;
            if (_cursor.isNull(_cursorIndexOfInspectionType)) {
              _tmpInspectionType = null;
            } else {
              _tmpInspectionType = _cursor.getString(_cursorIndexOfInspectionType);
            }
            final String _tmpInspectionDate;
            if (_cursor.isNull(_cursorIndexOfInspectionDate)) {
              _tmpInspectionDate = null;
            } else {
              _tmpInspectionDate = _cursor.getString(_cursorIndexOfInspectionDate);
            }
            final InspectionStatus _tmpStatus;
            _tmpStatus = __InspectionStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final String _tmpFindings;
            if (_cursor.isNull(_cursorIndexOfFindings)) {
              _tmpFindings = null;
            } else {
              _tmpFindings = _cursor.getString(_cursorIndexOfFindings);
            }
            final String _tmpRecommendations;
            if (_cursor.isNull(_cursorIndexOfRecommendations)) {
              _tmpRecommendations = null;
            } else {
              _tmpRecommendations = _cursor.getString(_cursorIndexOfRecommendations);
            }
            final String _tmpNextInspectionDue;
            if (_cursor.isNull(_cursorIndexOfNextInspectionDue)) {
              _tmpNextInspectionDue = null;
            } else {
              _tmpNextInspectionDue = _cursor.getString(_cursorIndexOfNextInspectionDue);
            }
            final String _tmpDefectCategory;
            if (_cursor.isNull(_cursorIndexOfDefectCategory)) {
              _tmpDefectCategory = null;
            } else {
              _tmpDefectCategory = _cursor.getString(_cursorIndexOfDefectCategory);
            }
            final String _tmpSeverityLevel;
            if (_cursor.isNull(_cursorIndexOfSeverityLevel)) {
              _tmpSeverityLevel = null;
            } else {
              _tmpSeverityLevel = _cursor.getString(_cursorIndexOfSeverityLevel);
            }
            final String _tmpMeasurements;
            if (_cursor.isNull(_cursorIndexOfMeasurements)) {
              _tmpMeasurements = null;
            } else {
              _tmpMeasurements = _cursor.getString(_cursorIndexOfMeasurements);
            }
            final String _tmpPhotos;
            if (_cursor.isNull(_cursorIndexOfPhotos)) {
              _tmpPhotos = null;
            } else {
              _tmpPhotos = _cursor.getString(_cursorIndexOfPhotos);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _item = new Inspection(_tmpId,_tmpComponentId,_tmpInspectorId,_tmpInspectionType,_tmpInspectionDate,_tmpStatus,_tmpFindings,_tmpRecommendations,_tmpNextInspectionDue,_tmpDefectCategory,_tmpSeverityLevel,_tmpMeasurements,_tmpPhotos,_tmpCreatedAt);
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

  private String __InspectionStatus_enumToString(@NonNull final InspectionStatus _value) {
    switch (_value) {
      case PASSED: return "PASSED";
      case FAILED: return "FAILED";
      case PENDING: return "PENDING";
      case MAINTENANCE_REQUIRED: return "MAINTENANCE_REQUIRED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private InspectionStatus __InspectionStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PASSED": return InspectionStatus.PASSED;
      case "FAILED": return InspectionStatus.FAILED;
      case "PENDING": return InspectionStatus.PENDING;
      case "MAINTENANCE_REQUIRED": return InspectionStatus.MAINTENANCE_REQUIRED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
