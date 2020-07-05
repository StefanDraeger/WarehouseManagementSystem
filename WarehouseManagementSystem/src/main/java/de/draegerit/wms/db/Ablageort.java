package de.draegerit.wms.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import de.draegerit.wms.db.util.EAblageortTyp;

@Entity
@Table(name = "ablageort")
public class Ablageort {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="ablageortTyp")
	private EAblageortTyp ablageortTyp;
	
	@Column(name="halle")
	private Halle halle;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EAblageortTyp getAblageortTyp() {
		return ablageortTyp;
	}

	public void setAblageortTyp(EAblageortTyp ablageortTyp) {
		this.ablageortTyp = ablageortTyp;
	}

	public Halle getHalle() {
		return halle;
	}

	public void setHalle(Halle halle) {
		this.halle = halle;
	}
	
	

}
