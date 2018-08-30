package com.wlw.admin.myapplication.calendar.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by joybar on 9/12/16.
 */
@Entity
public class Solar {
    @Id(autoincrement = true)
    private Long solarId;

    @Generated(hash = 1297838676)
    public Solar() {
    }

    @Generated(hash = 655396887)
    public Solar(Long solarId, int solarDay, int solarMonth, int solarYear,
                 boolean isSFestival, String solarFestivalName, String solar24Term,
                 String day, String month) {
        this.solarId = solarId;
        this.solarDay = solarDay;
        this.solarMonth = solarMonth;
        this.solarYear = solarYear;
        this.isSFestival = isSFestival;
        this.solarFestivalName = solarFestivalName;
        this.solar24Term = solar24Term;
        this.day = day;
        this.month = month;
    }

    private int solarDay;
    private int solarMonth;
    private int solarYear;
    private boolean isSFestival;
    private String solarFestivalName;//公历节日
    private String solar24Term;//24节气
    private String day;
    private String month;

    public Long getSolarId() {
        return solarId;
    }

    public void setSolarId(Long solarId) {
        this.solarId = solarId;
    }

    public int getSolarDay() {
        return solarDay;
    }

    public void setSolarDay(int solarDay) {
        this.solarDay = solarDay;
    }

    public int getSolarMonth() {
        return solarMonth;
    }

    public void setSolarMonth(int solarMonth) {
        this.solarMonth = solarMonth;
    }

    public int getSolarYear() {
        return solarYear;
    }

    public void setSolarYear(int solarYear) {
        this.solarYear = solarYear;
    }

    public boolean isSFestival() {
        return isSFestival;
    }

    public void setSFestival(boolean SFestival) {
        isSFestival = SFestival;
    }

    public String getSolarFestivalName() {
        return solarFestivalName;
    }

    public void setSolarFestivalName(String solarFestivalName) {
        this.solarFestivalName = solarFestivalName;
    }

    public String getSolar24Term() {
        return solar24Term;
    }

    public void setSolar24Term(String solar24Term) {
        this.solar24Term = solar24Term;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean getIsSFestival() {
        return this.isSFestival;
    }

    public void setIsSFestival(boolean isSFestival) {
        this.isSFestival = isSFestival;
    }

}
