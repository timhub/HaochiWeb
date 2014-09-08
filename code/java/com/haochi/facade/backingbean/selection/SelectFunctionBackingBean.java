package com.haochi.facade.backingbean.selection;

import com.haochi.platform.persistence.dao.doctorinfo.Doctorinfo;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.PropertyUtils;

public class SelectFunctionBackingBean {
	
	private Doctorinfo[] docList;
	private Treatment[] treatList;
	
	private Integer selectedDocIndex;
	private Integer selectedTreatIndex;
	
	private static final String TREATMENT_LIST_KEY_NAME = "treatment_list_value"; 	
	
	public SelectFunctionBackingBean() {
		selectedDocIndex = CommonConstants.NON_AVALIABLE_CODE;
		selectedTreatIndex = CommonConstants.NON_AVALIABLE_CODE;
		initialTeatList();
	}
	
	/**
	 * Initialize the treatment list for selecting.
	 */
	private void initialTeatList() {
		String[] treatmentList = PropertyUtils.getInstance()
				.getProperty(TREATMENT_LIST_KEY_NAME).split(",");
		treatList = new Treatment[treatmentList.length];
		for (int i = 0; i < treatmentList.length; i++) {
			Treatment treatment = new Treatment();
			treatment.setSelected(false);
			treatment.setTreatName(treatmentList[i]);
		}
	}
	
	/**
	 * Initialize the doc list for selecting.
	 */
	private void initialDocList() {
		
	}

	public Doctorinfo[] getDocList() {
		return docList;
	}

	public void setDocList(Doctorinfo[] docList) {
		this.docList = docList;
	}

	public Treatment[] getTreatList() {
		return treatList;
	}

	public void setTreatList(Treatment[] treatList) {
		this.treatList = treatList;
	}

	public Integer getSelectedDocIndex() {
		return selectedDocIndex;
	}

	public void setSelectedDocIndex(Integer selectedDocIndex) {
		this.selectedDocIndex = selectedDocIndex;
	}

	public Integer getSelectedTreatIndex() {
		return selectedTreatIndex;
	}

	public void setSelectedTreatIndex(Integer selectedTreatIndex) {
		this.selectedTreatIndex = selectedTreatIndex;
	}
	
	
}
