package model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import ctrl.cdi.Added;


/**
 * 
 * @RequestScoped An eine Anfrage gebunden
 * 
 * @SessionScoped An eine Benutzersitzung gebunden
 * 
 * @ApplicationScoped Quasi Singleton. Es wird nur eine Instanz für die
 *                    Applikation erzeugt
 * 
 * @ConversationScoped An eine JSF Conversation gebunden. Manuelles starten und
 *                     beenden des Scopes.
 * 
 * @Dependent Der Lebenszyklus einer Bean mit @Dependent Scope ist an den
 *            Lebenszyklus der einbindenen Bean gebunden.
 * 
 * 
 *
 */
//@SessionScoped
@RequestScoped
@Named("auto")
@Default
@Added
public class Auto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hersteller;// null
	private String fahrzeugnummer;// null

	@Inject
	private Reifen reifen;// CDI soll für mich das Objekt verwalten/erstellen

	@Inject
	private Motor motor;// CDI soll für mich das Objekt verwalten/erstellen

	public Auto() {

	}

	public Auto(String hersteller, String fahrzeugnummer, Reifen reifen, Motor motor) {
		super();
		this.hersteller = hersteller;
		this.fahrzeugnummer = fahrzeugnummer;
		this.reifen = reifen;
		this.motor = motor;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public String getFahrzeugnummer() {
		return fahrzeugnummer;
	}

	public void setFahrzeugnummer(String fahrzeugnummer) {
		this.fahrzeugnummer = fahrzeugnummer;
	}

	public Reifen getReifen() {
		return reifen;
	}

	public void setReifen(Reifen reifen) {
		this.reifen = reifen;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Auto [hersteller=" + hersteller + ", fahrzeugnummer=" + fahrzeugnummer + ", reifen=" + reifen
				+ ", motor=" + motor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fahrzeugnummer == null) ? 0 : fahrzeugnummer.hashCode());
		result = prime * result + ((hersteller == null) ? 0 : hersteller.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((reifen == null) ? 0 : reifen.hashCode());
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
		Auto other = (Auto) obj;
		if (fahrzeugnummer == null) {
			if (other.fahrzeugnummer != null)
				return false;
		} else if (!fahrzeugnummer.equals(other.fahrzeugnummer))
			return false;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (reifen == null) {
			if (other.reifen != null)
				return false;
		} else if (!reifen.equals(other.reifen))
			return false;
		return true;
	}

	@Override
	public Auto clone() {
		return new Auto(this.getHersteller(), this.getFahrzeugnummer(), this.getReifen(), this.getMotor());
	}

}
