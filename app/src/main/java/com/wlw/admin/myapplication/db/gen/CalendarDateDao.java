package com.wlw.admin.myapplication.db.gen;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.wlw.admin.myapplication.calendar.data.Lunar;
import com.wlw.admin.myapplication.calendar.data.Solar;

import com.wlw.admin.myapplication.calendar.data.CalendarDate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CALENDAR_DATE".
*/
public class CalendarDateDao extends AbstractDao<CalendarDate, Long> {

    public static final String TABLENAME = "CALENDAR_DATE";

    /**
     * Properties of entity CalendarDate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property DateId = new Property(0, Long.class, "dateId", true, "_id");
        public final static Property LunarId = new Property(1, long.class, "lunarId", false, "LUNAR_ID");
        public final static Property SolarId = new Property(2, long.class, "solarId", false, "SOLAR_ID");
        public final static Property IsInThisMonth = new Property(3, boolean.class, "isInThisMonth", false, "IS_IN_THIS_MONTH");
        public final static Property IsSelect = new Property(4, boolean.class, "isSelect", false, "IS_SELECT");
        public final static Property IsCanAskLeave = new Property(5, boolean.class, "isCanAskLeave", false, "IS_CAN_ASK_LEAVE");
    }

    private DaoSession daoSession;

    private Query<CalendarDate> calenBean_DataQuery;

    public CalendarDateDao(DaoConfig config) {
        super(config);
    }
    
    public CalendarDateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CALENDAR_DATE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: dateId
                "\"LUNAR_ID\" INTEGER NOT NULL ," + // 1: lunarId
                "\"SOLAR_ID\" INTEGER NOT NULL ," + // 2: solarId
                "\"IS_IN_THIS_MONTH\" INTEGER NOT NULL ," + // 3: isInThisMonth
                "\"IS_SELECT\" INTEGER NOT NULL ," + // 4: isSelect
                "\"IS_CAN_ASK_LEAVE\" INTEGER NOT NULL );"); // 5: isCanAskLeave
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CALENDAR_DATE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CalendarDate entity) {
        stmt.clearBindings();
 
        Long dateId = entity.getDateId();
        if (dateId != null) {
            stmt.bindLong(1, dateId);
        }
        stmt.bindLong(2, entity.getLunarId());
        stmt.bindLong(3, entity.getSolarId());
        stmt.bindLong(4, entity.getIsInThisMonth() ? 1L: 0L);
        stmt.bindLong(5, entity.getIsSelect() ? 1L: 0L);
        stmt.bindLong(6, entity.getIsCanAskLeave() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CalendarDate entity) {
        stmt.clearBindings();
 
        Long dateId = entity.getDateId();
        if (dateId != null) {
            stmt.bindLong(1, dateId);
        }
        stmt.bindLong(2, entity.getLunarId());
        stmt.bindLong(3, entity.getSolarId());
        stmt.bindLong(4, entity.getIsInThisMonth() ? 1L: 0L);
        stmt.bindLong(5, entity.getIsSelect() ? 1L: 0L);
        stmt.bindLong(6, entity.getIsCanAskLeave() ? 1L: 0L);
    }

    @Override
    protected final void attachEntity(CalendarDate entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CalendarDate readEntity(Cursor cursor, int offset) {
        CalendarDate entity = new CalendarDate( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // dateId
            cursor.getLong(offset + 1), // lunarId
            cursor.getLong(offset + 2), // solarId
            cursor.getShort(offset + 3) != 0, // isInThisMonth
            cursor.getShort(offset + 4) != 0, // isSelect
            cursor.getShort(offset + 5) != 0 // isCanAskLeave
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CalendarDate entity, int offset) {
        entity.setDateId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLunarId(cursor.getLong(offset + 1));
        entity.setSolarId(cursor.getLong(offset + 2));
        entity.setIsInThisMonth(cursor.getShort(offset + 3) != 0);
        entity.setIsSelect(cursor.getShort(offset + 4) != 0);
        entity.setIsCanAskLeave(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CalendarDate entity, long rowId) {
        entity.setDateId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CalendarDate entity) {
        if(entity != null) {
            return entity.getDateId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CalendarDate entity) {
        return entity.getDateId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "data" to-many relationship of CalenBean. */
    public List<CalendarDate> _queryCalenBean_Data(Long dateId) {
        synchronized (this) {
            if (calenBean_DataQuery == null) {
                QueryBuilder<CalendarDate> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.DateId.eq(null));
                calenBean_DataQuery = queryBuilder.build();
            }
        }
        Query<CalendarDate> query = calenBean_DataQuery.forCurrentThread();
        query.setParameter(0, dateId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getLunarDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getSolarDao().getAllColumns());
            builder.append(" FROM CALENDAR_DATE T");
            builder.append(" LEFT JOIN LUNAR T0 ON T.\"LUNAR_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN SOLAR T1 ON T.\"SOLAR_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CalendarDate loadCurrentDeep(Cursor cursor, boolean lock) {
        CalendarDate entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Lunar lunar = loadCurrentOther(daoSession.getLunarDao(), cursor, offset);
         if(lunar != null) {
            entity.setLunar(lunar);
        }
        offset += daoSession.getLunarDao().getAllColumns().length;

        Solar solar = loadCurrentOther(daoSession.getSolarDao(), cursor, offset);
         if(solar != null) {
            entity.setSolar(solar);
        }

        return entity;    
    }

    public CalendarDate loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<CalendarDate> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CalendarDate> list = new ArrayList<CalendarDate>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<CalendarDate> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CalendarDate> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
