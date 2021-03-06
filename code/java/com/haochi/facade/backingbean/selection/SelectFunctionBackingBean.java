package com.haochi.facade.backingbean.selection;

import java.io.Serializable;
import java.util.prefs.BackingStoreException;

import javax.faces.context.FacesContext;

import com.haochi.facade.backingbean.bookservice.BookServiceBackingBean;
import com.haochi.platform.persistence.dao.doctorinfo.Doctorinfo;
import com.haochi.service.docinfo.DocinfoService;
import com.haochi.service.utility.BackingBeanVisitor;
import com.haochi.service.utility.CommonConstants;
import com.haochi.service.utility.PropertyUtils;

public class SelectFunctionBackingBean implements Serializable {
	
	private static final long serialVersionUID = 7340433749617651260L;
	
	private Doctorinfo[] docList;
	private Treatment[] treatList;
	
	private Integer selectedDocId;
	private Integer selectedTreatId;
	private boolean selectionAllSet;
	
	
	
	public SelectFunctionBackingBean() {
		selectedDocId = CommonConstants.NON_AVALIABLE_CODE;
		selectedTreatId = CommonConstants.NON_AVALIABLE_CODE;
		initialDocList();
		initialTreatList();
	}
	
	/**
	 * Initialize the treatment list for selecting.
	 */
	private void initialTreatList() {
		String[] treatmentList = PropertyUtils.getInstance()
				.getProperty(CommonConstants.TREATMENT_LIST_KEY_NAME).split(",");
		treatList = new Treatment[treatmentList.length];
		for (int i = 0; i < treatmentList.length; i++) {
			Treatment treatment = new Treatment();
			treatment.setSelected(false);
			treatment.setTreatName(treatmentList[i]);
			treatList[i] = treatment;
		}
	}
	
	/**
	 * Initialize the doc list for selecting.
	 */
	private void initialDocList() {
		DocinfoService docService = new DocinfoService();
		docList = docService.getAllDoctorinfo();
	}
	
	/*
	 * Update selection when trigger a new selecting.
	 */
	public void updateDocSelection(int index) {
		boolean reloadFlag = false;
		if(index == selectedDocId){
			reloadFlag = false;
		} else {
			reloadFlag = true;
		}
		setSelectedDocId(docList[index].getDocid());
		updateSelectionCondition();
		if(reloadFlag) {
			callBookServiceReload();
		}
	}
	
	public void updateTreatSelection(int index) {
		boolean reloadFlag = false;
		if(index == selectedTreatId){
			reloadFlag = false;
		} else {
			reloadFlag = true;
		}
		setSelectedTreatId(index);
		updateSelectionCondition();
		if(reloadFlag) {
			callBookServiceReload();
		}
	}
	
	/**
	 * Call the load action in book service backing bean to reload the view with order data.
	 */
	private void callBookServiceReload() {
		BackingBeanVisitor.getCurrentBookServiceBackingBean().refreshOrders();
	}
	
	private void updateSelectionCondition() {
		if(!this.selectedDocId.equals(CommonConstants.NON_AVALIABLE_CODE) 
				&& !this.selectedTreatId.equals(CommonConstants.NON_AVALIABLE_CODE)) {
			this.selectionAllSet = true;
		}
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

	public Integer getSelectedDocId() {
		return selectedDocId;
	}

	public void setSelectedDocId(Integer selectedDocIndex) {
		this.selectedDocId = selectedDocIndex;
	}

	public Integer getSelectedTreatId() {
		return selectedTreatId;
	}

	public void setSelectedTreatId(Integer selectedTreatIndex) {
		this.selectedTreatId = selectedTreatIndex;
	}

	public boolean isSelectionAllSet() {
		return selectionAllSet;
	}

	public void setSelectionAllSet(boolean selectionAllSet) {
		this.selectionAllSet = selectionAllSet;
	}
	
	
}
