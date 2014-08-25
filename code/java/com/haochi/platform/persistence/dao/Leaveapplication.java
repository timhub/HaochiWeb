package com.haochi.platform.persistence.dao;

/**
 * Leaveapplication entity. @author MyEclipse Persistence Tools
 */
public class Leaveapplication extends AbstractLeaveapplication implements
		java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = -4950746017218013246L;

	/** default constructor */
	public Leaveapplication() {
	}

	/** full constructor */
	public Leaveapplication(Integer leavedocid, String leavedate,
			String leavestarttime, String leaveendtime) {
		super(leavedocid, leavedate, leavestarttime, leaveendtime);
	}

}
