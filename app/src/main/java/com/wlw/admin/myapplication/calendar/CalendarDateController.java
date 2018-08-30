package com.wlw.admin.myapplication.calendar;

import com.wlw.admin.myapplication.calendar.data.CalendarDate;
import com.wlw.admin.myapplication.calendar.data.Lunar;
import com.wlw.admin.myapplication.calendar.data.Solar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2/24/16.
 */
public class CalendarDateController {
    public static List<CalendarDate> getCalendarDate(int year, int month) {
        List<CalendarDate> mListDate = new ArrayList<>();
        List<CalendarUtils.CalendarSimpleDate> list = null;
        try {
            list = CalendarUtils.getEverydayOfMonth(year, month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int count = list.size();

        for (int i = 0; i < count; i++) {
            Solar solar = new Solar();
            solar.setSolarId(new Long(i));
            solar.setSolarYear(list.get(i).getYear());
            solar.setSolarMonth(list.get(i).getMonth());
            solar.setSolarDay(list.get(i).getDay());
            if (solar.getSolarMonth() < 10) {
                solar.setMonth("0" + solar.getSolarMonth());
            } else {
                solar.setMonth(solar.getSolarMonth() + "");
            }
            if (solar.getSolarDay() < 10) {
                solar.setDay("0" + solar.getSolarDay());
            } else {
                solar.setDay(solar.getSolarDay() + "");
            }
            Lunar lunar = LunarSolarConverter.SolarToLunar(solar);
            CalendarDate calendarDate = new CalendarDate();
            calendarDate.setIsInThisMonth(month == list.get(i).getMonth());
            calendarDate.setSolar(solar);
            calendarDate.setLunar(lunar);
            calendarDate.setIsSelect(false);
            mListDate.add(calendarDate);
        }
        return mListDate;
    }
}
