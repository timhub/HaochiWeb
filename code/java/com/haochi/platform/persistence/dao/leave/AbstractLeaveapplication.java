package com.haochi.platform.persistence.dao.leave;

/**
 * AbstractLeaveapplication entity provides the base persistence definition of
 * the Leaveapplication entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLeaveapplication implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8240512749805479524L;
	
	private Integer leavedocid;
	private String leavedate;
	private String leavestarttime;
	private String leaveendtime;

	// Constructors

	/** default constructor */
	public AbstractLeaveapplication() {
	}

	/** full constructor */
	public AbstractLeaveapplication(Integer leavedocid, String leavedate,
			String leavestarttime, String leaveendtime) {
		this.leavedocid = leavedocid;
		this.leavedate = leavedate;
		this.leavestarttime = leavestarttime;
		this.leaveendtime = leaveendtime;
	}

	// Property accessors

	public Integer getLeavedocid() {
		return this.leavedocid;
	}

	public void setLeavedocid(Integer leavedocid) {
		this.leavedocid = leavedocid;
	}

	public String getLeavedate() {
		return this.leavedate;
	}

	public void setLeavedate(String leavedate) {
		this.leavedate = leavedate;
	}

	public String getLeavestarttime() {
		return this.leavestarttime;
	}

	public void setLeavestarttime(String leavestarttime) {
		this.leavestarttime = leavestarttime;
	}

	public String getLeaveendtime() {
		return this.leaveendtime;
	}

	public void setLeaveendtime(String leaveendtime) {
		this.leaveendtime = leaveendtime;
	}

}