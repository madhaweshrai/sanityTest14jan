package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateObject {

//	public static String todaysDate(){
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		Calendar cal = Calendar.getInstance();
//		Date date = cal.getTime();
//		String todayDate= dateFormat.format(date);
//		return todayDate;
//	}
	public static String dateObjMinusOne(){
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -1);
	Date date = cal.getTime();
	String yesterdayDate= dateFormat.format(date);
	return yesterdayDate;
	}
}
