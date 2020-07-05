package de.draegerit.wms.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "halle")
public class Halle {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "bezeichnung")
	private String bezeichnung;

	@Column(name = "hasStellplatz")
	private boolean stellplatz;

	@Column(name = "hasRegal")
	private boolean regal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public boolean isStellplatz() {
		return stellplatz;
	}

	public void setStellplatz(boolean stellplatz) {
		this.stellplatz = stellplatz;
	}

	public boolean isRegal() {
		return regal;
	}

	public void setRegal(boolean regal) {
		this.regal = regal;
	}

}
