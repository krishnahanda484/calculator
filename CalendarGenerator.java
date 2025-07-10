package com.example.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarGenerator {
    public static List<List<String>> generateCalendar(int year, int month) {
        List<List<String>> weeks = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Fill first week
        List<String> week = new ArrayList<>();
        for (int i = 1; i < firstDayOfWeek; i++) {
            week.add("");
        }
        int day = 1;
        while (day <= daysInMonth) {
            week.add(String.valueOf(day));
            if (week.size() == 7) {
                weeks.add(new ArrayList<>(week));
                week.clear();
            }
            day++;
        }
        // Fill the last week with empty strings if needed
        while (week.size() > 0 && week.size() < 7) {
            week.add("");
        }
        if (!week.isEmpty()) {
            weeks.add(week);
        }
        return weeks;
    }
}