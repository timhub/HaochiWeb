package com.haochi.platform.persistence.dao;

/**
 * AbstractTreathistory entity provides the base persistence definition of the
 * Treathistory entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTreathistory implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1824655591354166486L;
	
	private Integer treatid;
	private Integer treatuserid;
	private Integer treatdocid;
	private String treatcontent;
	private String treatdate;

	// Constructors

	/** default constructor */
	public AbstractTreathistory() {
	}

	/** minimal constructor */
	public AbstractTreathistory(Integer treatid, Integer treatuserid,
			Integer treatdocid, String treatdate) {
		this.treatid = treatid;
		this.treatuserid = treatuserid;
		this.treatdocid = treatdocid;
		this.treatdate = treatdate;
	}

	/** full constructor */
	public AbstractTreathistory(Integer treatid, Integer treatuserid,
			Integer treatdocid, String treatcontent, String treatdate) {
		this.treatid = treatid;
		this.treatuserid = treatuserid;
		this.treatdocid = treatdocid;
		this.treatcontent = treatcontent;
		this.treatdate = treatdate;
	}

	// Property accessors

	public Integer getTreatid() {
		return this.treatid;
	}

	public void setTreatid(Integer treatid) {
		this.treatid = treatid;
	}

	public Integer getTreatuserid() {
		return this.treatuserid;
	}

	public void setTreatuserid(Integer treatuserid) {
		this.treatuserid = treatuserid;
	}

	public Integer getTreatdocid() {
		return this.treatdocid;
	}

	public void setTreatdocid(Integer treatdocid) {
		this.treatdocid = treatdocid;
	}

	public String getTreatcontent() {
		return this.treatcontent;
	}

	public void setTreatcontent(String treatcontent) {
		this.treatcontent = treatcontent;
	}

	public String getTreatdate() {
		return this.treatdate;
	}

	public void setTreatdate(String treatdate) {
		this.treatdate = treatdate;
	}

}