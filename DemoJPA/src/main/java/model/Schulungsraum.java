package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the schulungsraum database table.
 * 
 */
@Entity
@NamedQuery(name="Schulungsraum.findAll", query="SELECT s FROM Schulungsraum s")
public class Schulungsraum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int kapazit�t;

	private String name;

	//bi-directional many-to-one association to Audioequipment
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="audiohersteller", referencedColumnName="hersteller"),
		@JoinColumn(name="audiotypbezichnung", referencedColumnName="typbezeichnung")
		})
	private Audioequipment audioequipment;

	public Schulungsraum() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKapazit�t() {
		return this.kapazit�t;
	}

	public void setKapazit�t(int kapazit�t) {
		this.kapazit�t = kapazit�t;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Audioequipment getAudioequipment() {
		return this.audioequipment;
	}

	public void setAudioequipment(Audioequipment audioequipment) {
		this.audioequipment = audioequipment;
	}

}