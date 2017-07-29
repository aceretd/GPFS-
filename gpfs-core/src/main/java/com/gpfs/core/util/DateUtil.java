package com.gpfs.core.util;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public final class DateUtil {

    public static final String DATE_FORMAT = "YYYY-MMM-dd";
    public static final String DATE_TIME_FORMAT = DATE_FORMAT + " hh:mm";
    public static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_TIME_FORMAT);

    public static String toDateString(DateTime dateTime) {
        return null == dateTime ? "Not set" : dateTime.toString(DATE_FORMAT);
    }

}
