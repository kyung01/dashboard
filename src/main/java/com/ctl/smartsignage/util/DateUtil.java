package com.ctl.smartsignage.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Arun Kumar Tiwari
 */
public class DateUtil {

    // List of all date formats that we want to parse.
    // Add your own format here.
    private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>() {

        /**
		 * 
		 */
		private static final long serialVersionUID = -7796079734096159278L;

		{
            add(new SimpleDateFormat("dd/MM/yy"));
            add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            add(new SimpleDateFormat("yyyy-MM-dd"));
            add(new SimpleDateFormat("HH:mm"));
            add(new SimpleDateFormat("HH:mm:ss"));
            add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        }
    };

    /**
     * Convert String with various formats into java.util.Date
     *
     * @param input Date as a string
     * @return java.util.Date object if input string is parsed successfully else
     * returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if (null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            try {
                date = format.parse(input);
            } catch (ParseException e) {
                // System.out.println("Plase Add the new Fromat in dateFormats.");
            }
            if (date != null) {
                break;
            }
        }

        return date;
    }

    /**
     * Convert java.util.Date with various formats into String
     *
     * @param input String as a Date
     * @return java.util.Date object if input string is parsed successfully else
     * returns null
     */
    public static String convertDateToString(Date input) {
        String date = null;
        if (null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            date = format.format(input);
            if (date != null) {
                break;
            }
        }

        return date;
    }
     /**
     * Convert java.util.Date 
     *
     * @param input Date and time
     * returns Date
     */
        public static Date addDateTime(Date date, Date time) {

        Calendar dCal = Calendar.getInstance();
        dCal.setTime(date);
        Calendar tCal = Calendar.getInstance();
        tCal.setTime(time);
        dCal.set(Calendar.HOUR_OF_DAY, tCal.get(Calendar.HOUR_OF_DAY));
        dCal.set(Calendar.MINUTE, tCal.get(Calendar.MINUTE));
//  dCal.set(Calendar.SECOND, tCal.get(Calendar.SECOND));
//  dCal.set(Calendar.MILLISECOND, tCal.get(Calendar.MILLISECOND));
        date = dCal.getTime();
        System.out.println("d=" + dCal.getTime());
        return date;
    }
}
