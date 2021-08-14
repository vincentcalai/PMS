package com.pms.pmsapp.util;

import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
	public static <E> E nvl(E expr1, E expr2) {
        return (null != expr1) ? expr1 : expr2;
    }
}
