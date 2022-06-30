package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
@NamedQuery(name = Autor.QUERY_FIND_BY_ID
			, query = "SELECT a FROM Autor a WHERE a.id=:" + Autor.PARAMETER_FIND_BY_ID)
@NamedQuery(name = Autor.QUERY_FIND_BY_ID_FETCH_BUCH
			, query = "SELECT a FROM Autor a JOIN FETCH a.buecher b WHERE a.id=:" + Autor.PARAMETER_FIND_BY_ID)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String QUERY_FIND_BY_ID = "QUERY_FIND_BY_ID";
	public static final String PARAMETER_FIND_BY_ID = "id";
	public static final String QUERY_FIND_BY_ID_FETCH_BUCH = "QUERY_FIND_BY_ID_FETCH_BUCH";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@XmlAttribute
	private String nachname;

	@XmlAttribute
	private String vorname;

	// bi-directional many-to-one association to Buch
	@OneToMany(mappedBy = "autorBean", cascade = { CascadeType.PERSIST })
	private List<Buch> buecher;

	public Autor() {
		this.buecher = new ArrayList<Buch>();
	}

	public Autor(String nachname, String vorname) {
		this();
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public List<Buch> getBuecher() {
		return this.buecher;
	}

	public void setBuecher(List<Buch> buecher) {
		this.buecher = buecher;
	}

	public Buch addBuecher(Buch buecher) {
		getBuecher().add(buecher);
		buecher.setAutorBean(this);

		return buecher;
	}

	public Buch removeBuecher(Buch buecher) {
		getBuecher().remove(buecher);
		buecher.setAutorBean(null);

		return buecher;
	}

}