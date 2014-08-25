package com.haochi.platform.persistence.dao;

/**
 * AbstractSchedule entity provides the base persistence definition of the
 * Schedule entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSchedule implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -3393999698864261175L;
	
	private Integer scheduledocid;
	private Integer schedulerestdayindex;

	// Constructors

	/** default constructor */
	public AbstractSchedule() {
	}

	/** full constructor */
	public AbstractSchedule(Integer scheduledocid, Integer schedulerestdayindex) {
		this.scheduledocid = scheduledocid;
		this.schedulerestdayindex = schedulerestdayindex;
	}

	// Property accessors

	public Integer getScheduledocid() {
		return this.scheduledocid;
	}

	public void setScheduledocid(Integer scheduledocid) {
		this.scheduledocid = scheduledocid;
	}

	public Integer getSchedulerestdayindex() {
		return this.schedulerestdayindex;
	}

	public void setSchedulerestdayindex(Integer schedulerestdayindex) {
		this.schedulerestdayindex = schedulerestdayindex;
	}

}