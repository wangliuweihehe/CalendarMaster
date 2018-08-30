package com.wlw.admin.myapplication.calendar.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

import com.wlw.admin.myapplication.db.gen.DaoSession;
import com.wlw.admin.myapplication.db.gen.SolarDao;

import org.greenrobot.greendao.annotation.NotNull;

import com.wlw.admin.myapplication.db.gen.LunarDao;
import com.wlw.admin.myapplication.db.gen.CalendarDateDao;

@Entity
public class CalendarDate {
    @Id(autoincrement = true)
    private Long dateId;

    private long lunarId;
    private long solarId;
    @ToOne(joinProperty = "lunarId")
    private Lunar lunar;//农历

    @ToOne(joinProperty = "solarId")
    private Solar solar;//公历

    private boolean isInThisMonth; //是否在当月
    private boolean isSelect;//是否被选中
    private boolean isCanAskLeave = false;


    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 2061790298)
    private transient CalendarDateDao myDao;
    @Generated(hash = 1370124227)
    private transient Long lunar__resolvedKey;
    @Generated(hash = 1560261927)
    private transient Long solar__resolvedKey;

    public long getLunarId() {
        return lunarId;
    }

    public void setLunarId(long lunarId) {
        this.lunarId = lunarId;
    }

    public long getSolarId() {
        return solarId;
    }

    public void setSolarId(long solarId) {
        this.solarId = solarId;
    }

    public boolean isCanAskLeave() {
        return isCanAskLeave;
    }

    public void setCanAskLeave(boolean canAskLeave) {
        isCanAskLeave = canAskLeave;
    }

    @Generated(hash = 998392134)
    public CalendarDate(Long dateId, long lunarId, long solarId, boolean isInThisMonth,
                        boolean isSelect, boolean isCanAskLeave) {
        this.dateId = dateId;
        this.lunarId = lunarId;
        this.solarId = solarId;
        this.isInThisMonth = isInThisMonth;
        this.isSelect = isSelect;
        this.isCanAskLeave = isCanAskLeave;
    }

    @Generated(hash = 343617962)
    public CalendarDate() {
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public boolean isInThisMonth() {
        return isInThisMonth;
    }

    public void setIsInThisMonth(boolean isInThisMonth) {
        this.isInThisMonth = isInThisMonth;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 12690317)
    public Solar getSolar() {
        long __key = this.solarId;
        if (solar__resolvedKey == null || !solar__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SolarDao targetDao = daoSession.getSolarDao();
            Solar solarNew = targetDao.load(__key);
            synchronized (this) {
                solar = solarNew;
                solar__resolvedKey = __key;
            }
        }
        return solar;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1704291789)
    public void setSolar(@NotNull Solar solar) {
        if (solar == null) {
            throw new DaoException(
                    "To-one property 'solarId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.solar = solar;
            solarId = solar.getSolarId();
            solar__resolvedKey = solarId;
        }
    }

    public void setInThisMonth(boolean inThisMonth) {
        isInThisMonth = inThisMonth;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 33987515)
    public Lunar getLunar() {
        long __key = this.lunarId;
        if (lunar__resolvedKey == null || !lunar__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LunarDao targetDao = daoSession.getLunarDao();
            Lunar lunarNew = targetDao.load(__key);
            synchronized (this) {
                lunar = lunarNew;
                lunar__resolvedKey = __key;
            }
        }
        return lunar;
    }

    public boolean getIsInThisMonth() {
        return this.isInThisMonth;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public boolean getIsCanAskLeave() {
        return this.isCanAskLeave;
    }

    public void setIsCanAskLeave(boolean isCanAskLeave) {
        this.isCanAskLeave = isCanAskLeave;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 580876087)
    public void setLunar(@NotNull Lunar lunar) {
        if (lunar == null) {
            throw new DaoException(
                    "To-one property 'lunarId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.lunar = lunar;
            lunarId = lunar.getLunarId();
            lunar__resolvedKey = lunarId;
        }
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 607364658)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCalendarDateDao() : null;
    }
}
