package model;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;

@Dependent
//implizit
@Any
@DieselMotorQualifier
public class DieselMotor extends Motor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ccm;
	private int zylinder;
	
	public DieselMotor() {
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

	@Override
	public String motorArt() {
		return this.getClass().getSimpleName();
	}
}
