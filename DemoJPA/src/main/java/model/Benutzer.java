package model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@RequestScoped
@Named("benutzer")
@NamedQueries({
		@NamedQuery(name = Benutzer.QUERY_FIND_BY_VORNAME, query = "SELECT b FROM Benutzer b WHERE b.vorname LIKE :"
				+ Benutzer.PARAMETER_FIND_BY_VORNAME),
		@NamedQuery(name = Benutzer.QUERY_FIND_BY_NACHNAME, query = "SELECT b FROM Benutzer b WHERE b.nachname LIKE :"
				+ Benutzer.PARAMETER_FIND_BY_NACHNAME) })

public class Benutzer implements Serializable {

	public static final String QUERY_FIND_BY_VORNAME = "QUERY_FIND_BY_VORNAME";
	public static final String PARAMETER_FIND_BY_VORNAME = "vorname";

	public static final String QUERY_FIND_BY_NACHNAME = "QUERY_FIND_BY_NACHNAME";
	public static final String PARAMETER_FIND_BY_NACHNAME = "nachname";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalnummer;

	private String vorname;
	private String nachname;

	public int getPersonalnummer() {
		return personalnummer;
	}

	public void setPersonalnummer(int personalnummer) {
		this.personalnummer = personalnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Benutzer() {
		// TODO Auto-generated constructor stub
	}

	public Benutzer(Benutzer origin) {
		this.setPersonalnummer(origin.getPersonalnummer());
		this.setVorname(origin.getVorname());
		this.setNachname(origin.getNachname());
	}

	@Override
	public Benutzer clone() {
		return new Benutzer(this);
	}

	@Override
	public String toString() {
		return "Benutzer [personalnummer=" + personalnummer + ", vorname=" + vorname + ", nachname=" + nachname + "]";
	}
}
