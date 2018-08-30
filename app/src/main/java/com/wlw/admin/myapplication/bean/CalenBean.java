package com.wlw.admin.myapplication.bean;

import com.wlw.admin.myapplication.calendar.data.CalendarDate;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.wlw.admin.myapplication.db.gen.DaoSession;
import com.wlw.admin.myapplication.db.gen.CalendarDateDao;
import com.wlw.admin.myapplication.db.gen.CalenBeanDao;

@Entity
public class CalenBean {
    @Id(autoincrement = true)
    private Long id;

    private int month;
    private int year;
    private long date;

    @ToMany(referencedJoinProperty = "dateId")
    private List<CalendarDate> data;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1247967775)
    private transient CalenBeanDao myDao;

    @Generated(hash = 1793440622)
    public CalenBean() {

    }

    @Generated(hash = 1511282311)
    public CalenBean(Long id, int month, int year, long date) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1415155568)
    public List<CalendarDate> getData() {
        if (data == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CalendarDateDao targetDao = daoSession.getCalendarDateDao();
            List<CalendarDate> dataNew = targetDao._queryCalenBean_Data(id);
            synchronized (this) {
                if (data == null) {
                    data = dataNew;
                }
            }
        }
        return data;
    }

    public void setData(List<CalendarDate> data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1283600904)
    public synchronized void resetData() {
        data = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 414092316)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCalenBeanDao() : null;
    }
}
