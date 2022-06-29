package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the buch database table.
 * 
 */
@Entity
@NamedQuery(name="Buch.findAll", query="SELECT b FROM Buch b")
public class Buch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	@Temporal(TemporalType.DATE)
	private Date erscheinungjahr;

	@Lob
	private String klappentext;

	private String titel;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="Autor")
	private Autor autorBean;

	public Buch() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getErscheinungjahr() {
		return this.erscheinungjahr;
	}

	public void setErscheinungjahr(Date erscheinungjahr) {
		this.erscheinungjahr = erscheinungjahr;
	}

	public String getKlappentext() {
		return this.klappentext;
	}

	public void setKlappentext(String klappentext) {
		this.klappentext = klappentext;
	}

	public String getTitel() {
		return this.titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Autor getAutorBean() {
		return this.autorBean;
	}

	public void setAutorBean(Autor autorBean) {
		this.autorBean = autorBean;
	}

}