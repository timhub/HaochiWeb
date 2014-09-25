package com.haochi.service.utility;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is used for date calculation
 *
 * @author Tim
 */
public class DateUtility implements Serializable{
	
	private static final long serialVersionUID = 6315634455208343229L;

	static DateUtility instance = null;
	
	private Calendar calendar;
	private Date currentDate;
	private int currentMonth;
	private int currentDayOfWeek;
	
	public DateUtility() {
		currentDate = new Date();
		
		//Get current date time.
		calendar = Calendar.getInstance();
		currentMonth = calendar.get(Calendar.MONTH);
	}
	
	/**
	 * Return an instance of this utility.
	 * @return
	 */
	public static DateUtility getInstance() {
		if (instance == null) {
			instance = new DateUtility();
		}
		return instance;
	}
	
	public static boolean isSameDate(Date date1, Date date2) {
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String datestr1 = sdf.format(date1);
		String datestr2 = sdf.format(date2);
		
		if(datestr1.equals(datestr2)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Get the first day of current month.
	 * @return
	 */
	public Calendar getFirstDayOfMonth(Calendar calendar){     
       calendar.set(Calendar.DATE,1);
       return calendar;     
    }  
	
	/**
	 * Get the amount of days within the first week of the month.
	 * @return
	 */
	public int getDaysInFirstWeek(Calendar calendar) {
		int result = 0;
		result = 7 - calendar.get(Calendar.DAY_OF_WEEK) + 1;
		
		return result;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentDayOfWeek() {
		return currentDayOfWeek;
	}

	public void setCurrentDayOfWeek(int currentDayOfWeek) {
		this.currentDayOfWeek = currentDayOfWeek;
	}

	public static void setInstance(DateUtility instance) {
		DateUtility.instance = instance;
	}
	
	
}
