package com.railway.qrscanner.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.railway.qrscanner.data.dao.ComponentDao;
import com.railway.qrscanner.data.dao.ComponentDao_Impl;
import com.railway.qrscanner.data.dao.InspectionDao;
import com.railway.qrscanner.data.dao.InspectionDao_Impl;
import com.railway.qrscanner.data.dao.LocationDao;
import com.railway.qrscanner.data.dao.LocationDao_Impl;
import com.railway.qrscanner.data.dao.VendorDao;
import com.railway.qrscanner.data.dao.VendorDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ComponentDao _componentDao;

  private volatile VendorDao _vendorDao;

  private volatile LocationDao _locationDao;

  private volatile InspectionDao _inspectionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `components` (`serialId` TEXT NOT NULL, `componentType` TEXT NOT NULL, `materialSpecification` TEXT, `batchNumber` TEXT, `lotNumber` TEXT, `poNumber` TEXT, `manufacturingDate` TEXT, `dispatchDate` TEXT, `receivingDate` TEXT, `installationDate` TEXT, `warrantyStartDate` TEXT, `warrantyEndDate` TEXT, `currentStatus` TEXT NOT NULL, `qrCodePath` TEXT, `vendorId` INTEGER NOT NULL, `locationId` INTEGER, `createdAt` TEXT NOT NULL, `updatedAt` TEXT, PRIMARY KEY(`serialId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `vendors` (`id` INTEGER NOT NULL, `vendorCode` TEXT NOT NULL, `name` TEXT NOT NULL, `address` TEXT, `contactPerson` TEXT, `phone` TEXT, `email` TEXT, `certificationStatus` TEXT NOT NULL, `qualityRating` REAL NOT NULL, `createdAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `locations` (`id` INTEGER NOT NULL, `zone` TEXT NOT NULL, `division` TEXT NOT NULL, `section` TEXT, `stationCode` TEXT, `chainage` TEXT, `trackNumber` TEXT, `gpsLatitude` REAL, `gpsLongitude` REAL, `createdAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `inspections` (`id` INTEGER NOT NULL, `componentId` INTEGER NOT NULL, `inspectorId` INTEGER, `inspectionType` TEXT NOT NULL, `inspectionDate` TEXT NOT NULL, `status` TEXT NOT NULL, `findings` TEXT, `recommendations` TEXT, `nextInspectionDue` TEXT, `defectCategory` TEXT, `severityLevel` TEXT, `measurements` TEXT, `photos` TEXT, `createdAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '13a37bdeb727d140e0e8b6f4dd6f310b')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `components`");
        db.execSQL("DROP TABLE IF EXISTS `vendors`");
        db.execSQL("DROP TABLE IF EXISTS `locations`");
        db.execSQL("DROP TABLE IF EXISTS `inspections`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsComponents = new HashMap<String, TableInfo.Column>(18);
        _columnsComponents.put("serialId", new TableInfo.Column("serialId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("componentType", new TableInfo.Column("componentType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("materialSpecification", new TableInfo.Column("materialSpecification", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("batchNumber", new TableInfo.Column("batchNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("lotNumber", new TableInfo.Column("lotNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("poNumber", new TableInfo.Column("poNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("manufacturingDate", new TableInfo.Column("manufacturingDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("dispatchDate", new TableInfo.Column("dispatchDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("receivingDate", new TableInfo.Column("receivingDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("installationDate", new TableInfo.Column("installationDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("warrantyStartDate", new TableInfo.Column("warrantyStartDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("warrantyEndDate", new TableInfo.Column("warrantyEndDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("currentStatus", new TableInfo.Column("currentStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("qrCodePath", new TableInfo.Column("qrCodePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("vendorId", new TableInfo.Column("vendorId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("locationId", new TableInfo.Column("locationId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComponents.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComponents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComponents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComponents = new TableInfo("components", _columnsComponents, _foreignKeysComponents, _indicesComponents);
        final TableInfo _existingComponents = TableInfo.read(db, "components");
        if (!_infoComponents.equals(_existingComponents)) {
          return new RoomOpenHelper.ValidationResult(false, "components(com.railway.qrscanner.data.model.Component).\n"
                  + " Expected:\n" + _infoComponents + "\n"
                  + " Found:\n" + _existingComponents);
        }
        final HashMap<String, TableInfo.Column> _columnsVendors = new HashMap<String, TableInfo.Column>(10);
        _columnsVendors.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("vendorCode", new TableInfo.Column("vendorCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("contactPerson", new TableInfo.Column("contactPerson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("certificationStatus", new TableInfo.Column("certificationStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("qualityRating", new TableInfo.Column("qualityRating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVendors.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVendors = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVendors = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVendors = new TableInfo("vendors", _columnsVendors, _foreignKeysVendors, _indicesVendors);
        final TableInfo _existingVendors = TableInfo.read(db, "vendors");
        if (!_infoVendors.equals(_existingVendors)) {
          return new RoomOpenHelper.ValidationResult(false, "vendors(com.railway.qrscanner.data.model.Vendor).\n"
                  + " Expected:\n" + _infoVendors + "\n"
                  + " Found:\n" + _existingVendors);
        }
        final HashMap<String, TableInfo.Column> _columnsLocations = new HashMap<String, TableInfo.Column>(10);
        _columnsLocations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("zone", new TableInfo.Column("zone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("division", new TableInfo.Column("division", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("section", new TableInfo.Column("section", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("stationCode", new TableInfo.Column("stationCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("chainage", new TableInfo.Column("chainage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("trackNumber", new TableInfo.Column("trackNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("gpsLatitude", new TableInfo.Column("gpsLatitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("gpsLongitude", new TableInfo.Column("gpsLongitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocations = new TableInfo("locations", _columnsLocations, _foreignKeysLocations, _indicesLocations);
        final TableInfo _existingLocations = TableInfo.read(db, "locations");
        if (!_infoLocations.equals(_existingLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "locations(com.railway.qrscanner.data.model.Location).\n"
                  + " Expected:\n" + _infoLocations + "\n"
                  + " Found:\n" + _existingLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsInspections = new HashMap<String, TableInfo.Column>(14);
        _columnsInspections.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("componentId", new TableInfo.Column("componentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("inspectorId", new TableInfo.Column("inspectorId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("inspectionType", new TableInfo.Column("inspectionType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("inspectionDate", new TableInfo.Column("inspectionDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("findings", new TableInfo.Column("findings", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("recommendations", new TableInfo.Column("recommendations", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("nextInspectionDue", new TableInfo.Column("nextInspectionDue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("defectCategory", new TableInfo.Column("defectCategory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("severityLevel", new TableInfo.Column("severityLevel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("measurements", new TableInfo.Column("measurements", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("photos", new TableInfo.Column("photos", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspections.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInspections = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInspections = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInspections = new TableInfo("inspections", _columnsInspections, _foreignKeysInspections, _indicesInspections);
        final TableInfo _existingInspections = TableInfo.read(db, "inspections");
        if (!_infoInspections.equals(_existingInspections)) {
          return new RoomOpenHelper.ValidationResult(false, "inspections(com.railway.qrscanner.data.model.Inspection).\n"
                  + " Expected:\n" + _infoInspections + "\n"
                  + " Found:\n" + _existingInspections);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "13a37bdeb727d140e0e8b6f4dd6f310b", "d072172f4cc129b265eb649db283b77c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "components","vendors","locations","inspections");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `components`");
      _db.execSQL("DELETE FROM `vendors`");
      _db.execSQL("DELETE FROM `locations`");
      _db.execSQL("DELETE FROM `inspections`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ComponentDao.class, ComponentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(VendorDao.class, VendorDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(InspectionDao.class, InspectionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ComponentDao componentDao() {
    if (_componentDao != null) {
      return _componentDao;
    } else {
      synchronized(this) {
        if(_componentDao == null) {
          _componentDao = new ComponentDao_Impl(this);
        }
        return _componentDao;
      }
    }
  }

  @Override
  public VendorDao vendorDao() {
    if (_vendorDao != null) {
      return _vendorDao;
    } else {
      synchronized(this) {
        if(_vendorDao == null) {
          _vendorDao = new VendorDao_Impl(this);
        }
        return _vendorDao;
      }
    }
  }

  @Override
  public LocationDao locationDao() {
    if (_locationDao != null) {
      return _locationDao;
    } else {
      synchronized(this) {
        if(_locationDao == null) {
          _locationDao = new LocationDao_Impl(this);
        }
        return _locationDao;
      }
    }
  }

  @Override
  public InspectionDao inspectionDao() {
    if (_inspectionDao != null) {
      return _inspectionDao;
    } else {
      synchronized(this) {
        if(_inspectionDao == null) {
          _inspectionDao = new InspectionDao_Impl(this);
        }
        return _inspectionDao;
      }
    }
  }
}
