package com.haochi.facade.backingbean.selection;

import java.io.Serializable;

public class Treatment implements Serializable {

	private static final long serialVersionUID = -3863829044390466570L;
	
	private String treatName;
	private boolean avilable;
	private boolean isSelected;
	
	public String getTreatName() {
		return treatName;
	}
	public void setTreatName(String treatName) {
		this.treatName = treatName;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public boolean isAvilable() {
		return avilable;
	}
	public void setAvilable(boolean avilable) {
		this.avilable = avilable;
	}
	
	
}
