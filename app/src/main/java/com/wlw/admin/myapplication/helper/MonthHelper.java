package com.wlw.admin.myapplication.helper;

import com.wlw.admin.myapplication.MyApp;
import com.wlw.admin.myapplication.bean.CalenBean;
import com.wlw.admin.myapplication.db.gen.CalenBeanDao;

import java.util.List;

public class MonthHelper {
    private static MonthHelper instance;
    private static CalenBeanDao calenBeanDao;

    public static MonthHelper getInstance() {
        if (instance == null) {
            synchronized (MonthHelper.class) {
                if (instance == null) {
                    instance = new MonthHelper();
                    calenBeanDao = MyApp.getInstance().getDaoSession().getCalenBeanDao();
                }
            }
        }
        return instance;
    }

    public void saveMonth(CalenBean bean) {
        calenBeanDao.insertOrReplace(bean);
    }

    public void saveMonths(List<CalenBean> beans) {
        calenBeanDao.insertOrReplaceInTx(beans);
    }

    public CalenBean findMonthById(String id) {
        CalenBean bean = calenBeanDao.queryBuilder().where(CalenBeanDao.Properties.Id.eq(id)).unique();
        return bean;
    }

    public List<CalenBean> findAllMonths() {
        return calenBeanDao.queryBuilder().orderAsc(CalenBeanDao.Properties.Id).list();
    }
}
