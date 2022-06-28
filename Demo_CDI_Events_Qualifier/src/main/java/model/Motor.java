package model;

import java.io.Serializable;

public abstract class Motor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ccm;
	private int zylinder;
	
	public Motor() {
		this.zylinder = 4;
	}

	public int getCcm() {
		return ccm;
	}

	public void setCcm(int ccm) {
		this.ccm = ccm;
	}

	public int getZylinder() {
		return zylinder;
	}

	public void setZylinder(int zylinder) {
		this.zylinder = zylinder;
	}

	public abstract String motorArt();
}
