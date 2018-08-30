package com.wlw.admin.myapplication.helper;

import com.wlw.admin.myapplication.MyApp;
import com.wlw.admin.myapplication.calendar.data.CalendarDate;
import com.wlw.admin.myapplication.db.gen.CalendarDateDao;

import java.util.List;

public class DayHelpter {
    private static DayHelpter instance;
    private static CalendarDateDao calendarDateDao;

    public static DayHelpter getInstance() {
        if (instance == null) {
            synchronized (DayHelpter.class) {
                if (instance == null) {
                    instance = new DayHelpter();
                    calendarDateDao = MyApp.getInstance().getDaoSession().getCalendarDateDao();
                }
            }
        }
        return instance;
    }

    public void saveDay(CalendarDate bean) {
        calendarDateDao.insertOrReplace(bean);
    }

    public void saveDays(List<CalendarDate> beans) {
        calendarDateDao.insertOrReplaceInTx(beans);
    }

    public CalendarDate findDayById(String id) {
        CalendarDate bean = calendarDateDao.queryBuilder().where(CalendarDateDao.Properties.DateId.eq(id)).unique();
        return bean;
    }

    public List<CalendarDate> findAllDays() {
        return calendarDateDao.queryBuilder().orderAsc(CalendarDateDao.Properties.DateId).list();
    }
}
