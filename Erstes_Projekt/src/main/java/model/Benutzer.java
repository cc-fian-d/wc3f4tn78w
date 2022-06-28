package model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Named("benutzer")
@SessionScoped
public class Benutzer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vorname;
	private String nachname;
	private String password;
	
	//@Pattern(regexp = "[^@ ]+@[^@ ]+[.].+")
	@Email
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Benutzer() {

	}

	@Override
	public String toString() {
		return "Benutzer [vorname=" + vorname + ", nachname=" + nachname + ", password=" + password + ", email=" + email
				+ "]";
	}

}
