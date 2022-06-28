package model;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Nach JavaBean Konventionen
 * 
 *  Private Objektattribute
 *  
 *  Notwendige Getter/Setter
 *  
 *  implements Serializable
 *  
 *  Parameterloser Konstruktor
 *  
 *  -- erweitert
 *  
 *  Parameter übergebender Konstruktor
 *  
 *  toString überschrieben
 *  
 *  Equals & HashCode überschrieben
 *
 *  wegen CDI: Clone methode überschrieben
 *  
 */
@RequestScoped
@Named("huhn")
public class Huhn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	/**
	 * Attribute
	 */
	private String federfarbe;
	
	@Max(value = 5)
	@Min(value = 1)
	private int alter;
	private String ohrenFarbe;

	/**
	 * Getter/Setter
	 */
	public String getFederfarbe() {
		return federfarbe;
	}

	public void setFederfarbe(String federfarbe) {
		this.federfarbe = federfarbe;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public String getOhrenFarbe() {
		return ohrenFarbe;
	}

	public void setOhrenFarbe(String ohrenFarbe) {
		this.ohrenFarbe = ohrenFarbe;
	}

	/**
	 * Parameterloser Konstruktor
	 * 
	 * Wenn kein Expliziter Konstruktor geschrieben wird, fügt der Java Compiler
	 * einen leeren Parameterlosen Konstruktor dazu. (Impiliziter Konstruktor)
	 */
	public Huhn() {
//		this.setFederfarbe("weiss");
//		this.setAlter(ThreadLocalRandom.current().nextInt());
//		this.setOhrenFarbe("orange");
	}

	/**
	 * Parameter übergebender Konstruktor
	 */
	public Huhn(String federfarbe, int alter, String ohrenfarbe) {
		this.setFederfarbe(federfarbe);
		this.setAlter(alter);
		this.setOhrenFarbe(ohrenfarbe);
	}



	@Override
	public String toString() {
		return "Huhn [federfarbe=" + federfarbe + ", alter=" + alter + ", ohrenFarbe=" + ohrenFarbe + ", hashCode()="
				+ this.hashCode() + "]";
	}

	/**
	 * Wichtig wegen CDI
	 * 
	 * CDI nutzt für das injizieren der Objekte ein sogenannte Proxy-Pattern.
	 * 
	 * Context and Dependency Injections
	 */
	@Override
	public Huhn clone() {
		Huhn clone = new Huhn();
		clone.setFederfarbe(this.getFederfarbe());
		clone.setAlter(this.getAlter());
		clone.setOhrenFarbe(this.getOhrenFarbe());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alter;
		result = prime * result + ((federfarbe == null) ? 0 : federfarbe.hashCode());
		result = prime * result + ((ohrenFarbe == null) ? 0 : ohrenFarbe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Huhn other = (Huhn) obj;
		if (alter != other.alter)
			return false;
		if (federfarbe == null) {
			if (other.federfarbe != null)
				return false;
		} else if (!federfarbe.equals(other.federfarbe))
			return false;
		if (ohrenFarbe == null) {
			if (other.ohrenFarbe != null)
				return false;
		} else if (!ohrenFarbe.equals(other.ohrenFarbe))
			return false;
		return true;
	}

}
