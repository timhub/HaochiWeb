package com.haochi.platform.persistence.dao.doctorinfo;

/**
 * AbstractDoctorinfo entity provides the base persistence definition of the
 * Doctorinfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDoctorinfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -4551878842196943208L;
	
	private Integer docid;
	private Integer docuserid;
	private String docname;
	private String docintro;
	private String docability;

	// Constructors

	/** default constructor */
	public AbstractDoctorinfo() {
	}

	/** minimal constructor */
	public AbstractDoctorinfo(Integer docid, Integer docuserid, String docname,
			String docability) {
		this.docid = docid;
		this.docuserid = docuserid;
		this.docname = docname;
		this.docability = docability;
	}

	/** full constructor */
	public AbstractDoctorinfo(Integer docid, Integer docuserid, String docname,
			String docintro, String docability) {
		this.docid = docid;
		this.docuserid = docuserid;
		this.docname = docname;
		this.docintro = docintro;
		this.docability = docability;
	}

	// Property accessors

	public Integer getDocid() {
		return this.docid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public Integer getDocuserid() {
		return this.docuserid;
	}

	public void setDocuserid(Integer docuserid) {
		this.docuserid = docuserid;
	}

	public String getDocname() {
		return this.docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDocintro() {
		return this.docintro;
	}

	public void setDocintro(String docintro) {
		this.docintro = docintro;
	}

	public String getDocability() {
		return this.docability;
	}

	public void setDocability(String docability) {
		this.docability = docability;
	}

}