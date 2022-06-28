package model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

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
public class Auto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hersteller;//null
	private String fahrzeugnummer;//null
	
	@Inject
	private Reifen reifen;//CDI soll für mich das Objekt verwalten/erstellen
	
	@Inject
	private Motor motor;//CDI soll für mich das Objekt verwalten/erstellen

	public Auto() {
		
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

}
