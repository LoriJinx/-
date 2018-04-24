package com.system.utils;

import java.time.LocalDate;

public class SemesterUtils {

    public static String currentSemester() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        String prifix = year + "~" + (year + 1) + "学年度   ";
        String suffix = "上学期";
        if (month < 9 || month >= 3) {
            prifix = (year - 1) + "~" + year + "学年度  ";
            suffix = "下学期";
        }
        return prifix + suffix;
    }
}
