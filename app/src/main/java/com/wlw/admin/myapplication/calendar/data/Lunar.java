package com.wlw.admin.myapplication.calendar.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by joybar on 9/12/16.
 */
@Entity
public class Lunar {
    @Id(autoincrement = true)
    private Long lunarId;

    public int lunarDay;
    public boolean isleap;
    public int lunarMonth;
    public int lunarYear;
    public boolean isLFestival;
    public String lunarFestivalName;//农历节日

    @Generated(hash = 216772959)
    public Lunar() {
    }

    @Generated(hash = 932064225)
    public Lunar(Long lunarId, int lunarDay, boolean isleap, int lunarMonth, int lunarYear, boolean isLFestival,
            String lunarFestivalName) {
        this.lunarId = lunarId;
        this.lunarDay = lunarDay;
        this.isleap = isleap;
        this.lunarMonth = lunarMonth;
        this.lunarYear = lunarYear;
        this.isLFestival = isLFestival;
        this.lunarFestivalName = lunarFestivalName;
    }

    public int getLunarDay() {
        return lunarDay;
    }

    public void setLunarDay(int lunarDay) {
        this.lunarDay = lunarDay;
    }

    public boolean isIsleap() {
        return isleap;
    }

    public void setIsleap(boolean isleap) {
        this.isleap = isleap;
    }

    public int getLunarMonth() {
        return lunarMonth;
    }

    public void setLunarMonth(int lunarMonth) {
        this.lunarMonth = lunarMonth;
    }

    public int getLunarYear() {
        return lunarYear;
    }

    public void setLunarYear(int lunarYear) {
        this.lunarYear = lunarYear;
    }

    public boolean isLFestival() {
        return isLFestival;
    }

    public void setLFestival(boolean LFestival) {
        isLFestival = LFestival;
    }

    public String getLunarFestivalName() {
        return lunarFestivalName;
    }

    public void setLunarFestivalName(String lunarFestivalName) {
        this.lunarFestivalName = lunarFestivalName;
    }

    public Long getLunarId() {
        return lunarId;
    }

    public void setLunarId(Long lunarId) {
        this.lunarId = lunarId;
    }

    final static String chineseNumber[] =
            {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

    public static String getChinaDayString(int day) {
        String chineseTen[] =
                {"初", "十", "廿", "卅"};
        int n = day % 10 == 0 ? 9 : day % 10 - 1;
        if (day > 30)
            return "";
        if (day == 10)
            return "初十";
        else
            return chineseTen[day / 10] + chineseNumber[n];
    }

    @Override
    public String toString() {
        return "Lunar [isleap=" + isleap + ", lunarDay=" + lunarDay
                + ", lunarMonth=" + lunarMonth + ", lunarYear=" + lunarYear
                + ", isLFestival=" + isLFestival + ", lunarFestivalName="
                + lunarFestivalName + "]";
    }

    public boolean getIsleap() {
        return this.isleap;
    }

    public boolean getIsLFestival() {
        return this.isLFestival;
    }

    public void setIsLFestival(boolean isLFestival) {
        this.isLFestival = isLFestival;
    }
}
