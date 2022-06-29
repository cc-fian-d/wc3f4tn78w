package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the audioequipment database table.
 * 
 */
@Entity
@NamedQuery(name="Audioequipment.findAll", query="SELECT a FROM Audioequipment a")
public class Audioequipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AudioequipmentPK id;

	private double preis;

	//bi-directional many-to-one association to Schulungsraum
	@OneToMany(mappedBy="audioequipment")
	private List<Schulungsraum> schulungsraums;

	public Audioequipment() {
	}

	public AudioequipmentPK getId() {
		return this.id;
	}

	public void setId(AudioequipmentPK id) {
		this.id = id;
	}

	public double getPreis() {
		return this.preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public List<Schulungsraum> getSchulungsraums() {
		return this.schulungsraums;
	}

	public void setSchulungsraums(List<Schulungsraum> schulungsraums) {
		this.schulungsraums = schulungsraums;
	}

	public Schulungsraum addSchulungsraum(Schulungsraum schulungsraum) {
		getSchulungsraums().add(schulungsraum);
		schulungsraum.setAudioequipment(this);

		return schulungsraum;
	}

	public Schulungsraum removeSchulungsraum(Schulungsraum schulungsraum) {
		getSchulungsraums().remove(schulungsraum);
		schulungsraum.setAudioequipment(null);

		return schulungsraum;
	}

}