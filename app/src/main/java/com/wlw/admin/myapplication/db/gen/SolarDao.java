package com.wlw.admin.myapplication.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wlw.admin.myapplication.calendar.data.Solar;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SOLAR".
*/
public class SolarDao extends AbstractDao<Solar, Long> {

    public static final String TABLENAME = "SOLAR";

    /**
     * Properties of entity Solar.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SolarId = new Property(0, Long.class, "solarId", true, "_id");
        public final static Property SolarDay = new Property(1, int.class, "solarDay", false, "SOLAR_DAY");
        public final static Property SolarMonth = new Property(2, int.class, "solarMonth", false, "SOLAR_MONTH");
        public final static Property SolarYear = new Property(3, int.class, "solarYear", false, "SOLAR_YEAR");
        public final static Property IsSFestival = new Property(4, boolean.class, "isSFestival", false, "IS_SFESTIVAL");
        public final static Property SolarFestivalName = new Property(5, String.class, "solarFestivalName", false, "SOLAR_FESTIVAL_NAME");
        public final static Property Solar24Term = new Property(6, String.class, "solar24Term", false, "SOLAR24_TERM");
        public final static Property Day = new Property(7, String.class, "day", false, "DAY");
        public final static Property Month = new Property(8, String.class, "month", false, "MONTH");
    }


    public SolarDao(DaoConfig config) {
        super(config);
    }
    
    public SolarDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SOLAR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: solarId
                "\"SOLAR_DAY\" INTEGER NOT NULL ," + // 1: solarDay
                "\"SOLAR_MONTH\" INTEGER NOT NULL ," + // 2: solarMonth
                "\"SOLAR_YEAR\" INTEGER NOT NULL ," + // 3: solarYear
                "\"IS_SFESTIVAL\" INTEGER NOT NULL ," + // 4: isSFestival
                "\"SOLAR_FESTIVAL_NAME\" TEXT," + // 5: solarFestivalName
                "\"SOLAR24_TERM\" TEXT," + // 6: solar24Term
                "\"DAY\" TEXT," + // 7: day
                "\"MONTH\" TEXT);"); // 8: month
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SOLAR\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Solar entity) {
        stmt.clearBindings();
 
        Long solarId = entity.getSolarId();
        if (solarId != null) {
            stmt.bindLong(1, solarId);
        }
        stmt.bindLong(2, entity.getSolarDay());
        stmt.bindLong(3, entity.getSolarMonth());
        stmt.bindLong(4, entity.getSolarYear());
        stmt.bindLong(5, entity.getIsSFestival() ? 1L: 0L);
 
        String solarFestivalName = entity.getSolarFestivalName();
        if (solarFestivalName != null) {
            stmt.bindString(6, solarFestivalName);
        }
 
        String solar24Term = entity.getSolar24Term();
        if (solar24Term != null) {
            stmt.bindString(7, solar24Term);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(8, day);
        }
 
        String month = entity.getMonth();
        if (month != null) {
            stmt.bindString(9, month);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Solar entity) {
        stmt.clearBindings();
 
        Long solarId = entity.getSolarId();
        if (solarId != null) {
            stmt.bindLong(1, solarId);
        }
        stmt.bindLong(2, entity.getSolarDay());
        stmt.bindLong(3, entity.getSolarMonth());
        stmt.bindLong(4, entity.getSolarYear());
        stmt.bindLong(5, entity.getIsSFestival() ? 1L: 0L);
 
        String solarFestivalName = entity.getSolarFestivalName();
        if (solarFestivalName != null) {
            stmt.bindString(6, solarFestivalName);
        }
 
        String solar24Term = entity.getSolar24Term();
        if (solar24Term != null) {
            stmt.bindString(7, solar24Term);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(8, day);
        }
 
        String month = entity.getMonth();
        if (month != null) {
            stmt.bindString(9, month);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Solar readEntity(Cursor cursor, int offset) {
        Solar entity = new Solar( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // solarId
            cursor.getInt(offset + 1), // solarDay
            cursor.getInt(offset + 2), // solarMonth
            cursor.getInt(offset + 3), // solarYear
            cursor.getShort(offset + 4) != 0, // isSFestival
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // solarFestivalName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // solar24Term
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // day
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // month
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Solar entity, int offset) {
        entity.setSolarId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSolarDay(cursor.getInt(offset + 1));
        entity.setSolarMonth(cursor.getInt(offset + 2));
        entity.setSolarYear(cursor.getInt(offset + 3));
        entity.setIsSFestival(cursor.getShort(offset + 4) != 0);
        entity.setSolarFestivalName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSolar24Term(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDay(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMonth(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Solar entity, long rowId) {
        entity.setSolarId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Solar entity) {
        if(entity != null) {
            return entity.getSolarId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Solar entity) {
        return entity.getSolarId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}