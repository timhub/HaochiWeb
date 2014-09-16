package com.haochi.service.utility;

import java.io.Serializable;

/**
 * Restore the selection data for book service.
 * Default value for ids are <b>-1</b> and it's not bounded with
 * any doctors or treatment items. To make it singleton is for
 * backing up the selection data so that user could visit this
 * more conveniently .
 *
 * @author Tim
 */
public class SelectionHandler implements Serializable{
	
	private static final long serialVersionUID = -5552657327877239205L;
	
	private Integer docId;
	private Integer treatmentId;
	private boolean selectionAllSet;
	
	/**
	 * Set default value of the ids as -1.
	 */
	public SelectionHandler() {
		docId = CommonConstants.NON_AVALIABLE_CODE;
		treatmentId = CommonConstants.NON_AVALIABLE_CODE;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
		if (this.docId != CommonConstants.NON_AVALIABLE_CODE
				&& this.treatmentId != CommonConstants.NON_AVALIABLE_CODE) {
			this.selectionAllSet = true;
		}
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
		if (this.docId != CommonConstants.NON_AVALIABLE_CODE
				&& this.treatmentId != CommonConstants.NON_AVALIABLE_CODE) {
			this.selectionAllSet = true;
		}
	}

	public boolean isSelectionAllSet() {
		return selectionAllSet;
	}

	public void setSelectionAllSet(boolean selectionAllSet) {
		this.selectionAllSet = selectionAllSet;
	}

}
