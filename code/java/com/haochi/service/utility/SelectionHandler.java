package com.haochi.service.utility;

/**
 * Restore the selection data for book service.
 * Default value for ids are <b>-1</b> and it's not bounded with
 * any doctors or treatment items. To make it singleton is for
 * backing up the selection data so that user could visit this
 * more conveniently .
 *
 * @author Tim
 */
public class SelectionHandler {
	
	private static SelectionHandler instance;
	
	private Integer docId;
	private Integer treatmentId;
	
	public static SelectionHandler getInstance() {
		if(instance == null) {
			instance = new SelectionHandler();
		} 
		return instance;
	}
	
	/**
	 * Set default value of the ids as -1.
	 */
	public SelectionHandler() {
		docId = CommonConstants.NON_AVALIABLE_CODE;
		treatmentId = CommonConstants.NON_AVALIABLE_CODE ;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

}
