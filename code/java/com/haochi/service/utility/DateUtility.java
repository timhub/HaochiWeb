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
	
	static DateUtility instance = null;
	
	private Calendar calendar;
	private Date currentDate;
	private int currentMonth;
	private int currentDayOfWeek;
	
	public DateUtility() {
		currentDate = new Date();
		
		//Get current date time.
		calendar = Calendar.getInstance();
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
	
	/**
	 * Get the first day of current month.
	 * @return
	 */
	public Calendar getFirstDayOfMonth(){     
       Calendar calendar = Calendar.getInstance();   
       calendar.set(Calendar.DATE,1);
       return calendar;     
    }  
	
	/**
	 * Get the amount of days within the first week of the month.
	 * @return
	 */
	public int getDaysInFirstWeek() {
		int result = 0;
		Calendar calendar = getFirstDayOfMonth();
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
