package com.haochi.platform.persistence.dao.treathistory;

/**
 * Treathistory entity. @author MyEclipse Persistence Tools
 */
public class Treathistory extends AbstractTreathistory implements
		java.io.Serializable {

	// Constructors

	private static final long serialVersionUID = -333495858502667182L;

	/** default constructor */
	public Treathistory() {
	}

	/** minimal constructor */
	public Treathistory(Integer treatid, Integer treatuserid,
			Integer treatdocid, String treatdate) {
		super(treatid, treatuserid, treatdocid, treatdate);
	}

	/** full constructor */
	public Treathistory(Integer treatid, Integer treatuserid,
			Integer treatdocid, String treatcontent, String treatdate) {
		super(treatid, treatuserid, treatdocid, treatcontent, treatdate);
	}

}
