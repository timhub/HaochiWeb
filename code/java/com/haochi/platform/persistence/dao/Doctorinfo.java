package com.haochi.platform.persistence.dao;


/**
 * Doctorinfo entity. @author MyEclipse Persistence Tools
 */
public class Doctorinfo extends AbstractDoctorinfo implements
		java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = 403557139183678068L;

	/** default constructor */
	public Doctorinfo() {
	}

	/** minimal constructor */
	public Doctorinfo(Integer docid, Integer docuserid, String docname,
			String docability) {
		super(docid, docuserid, docname, docability);
	}

	/** full constructor */
	public Doctorinfo(Integer docid, Integer docuserid, String docname,
			String docintro, String docability) {
		super(docid, docuserid, docname, docintro, docability);
	}

}
