package com.haochi.platform.persistence.dao;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */
public class Schedule extends AbstractSchedule implements java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = 8360843404532466812L;

	/** default constructor */
	public Schedule() {
	}

	/** full constructor */
	public Schedule(Integer scheduledocid, Integer schedulerestdayindex) {
		super(scheduledocid, schedulerestdayindex);
	}

}
