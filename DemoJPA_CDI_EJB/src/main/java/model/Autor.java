package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nachname;

	private String vorname;

	//bi-directional many-to-one association to Buch
	@OneToMany(mappedBy="autorBean")
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