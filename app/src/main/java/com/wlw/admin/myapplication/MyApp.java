package com.wlw.admin.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.wlw.admin.myapplication.db.gen.DaoMaster;
import com.wlw.admin.myapplication.db.gen.DaoSession;

public class MyApp extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    //静态单例
    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setDatabase();
    }

    public static MyApp getInstance() {
        return instance;
    }

    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "NoSmoking_db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
