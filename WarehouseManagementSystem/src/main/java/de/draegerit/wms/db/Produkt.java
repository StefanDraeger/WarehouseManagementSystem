package de.draegerit.wms.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import de.draegerit.wms.db.util.EPackmaterial;

@Entity
@Table(name = "produkte")
public class Produkt {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="menge")
	private double menge;
	
	@Column(name="mengeneinheit")
	private String mengeneinheit;
	
	@Column(name="laenge")
	private double laenge;
	
	@Column(name="breite")
	private double breite;
	
	@Column(name="name")
	private String name;
	
	@Column(name="anzahl")
	private int anzahl;
	
	@Column(name="warn_anzahl")
	private int warnAnzahl;
	
	
	@Column(name="packmaterial")
	private EPackmaterial packmaterial;
	
	@Column(name="gesperrt")
	private boolean gesperrt;
		

	public boolean isGesperrt() {
		return gesperrt;
	}

	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public EPackmaterial getPackmaterial() {
		return packmaterial;
	}

	public void setPackmaterial(EPackmaterial packmaterial) {
		this.packmaterial = packmaterial;
	}

	public String getMengeneinheit() {
		return mengeneinheit;
	}

	public void setMengeneinheit(String mengeneinheit) {
		this.mengeneinheit = mengeneinheit;
	}

	public double getMenge() {
		return menge;
	}

	public void setMenge(double menge) {
		this.menge = menge;
	}

	public int getWarnAnzahl() {
		return warnAnzahl;
	}

	public void setWarnAnzahl(int warnAnzahl) {
		this.warnAnzahl = warnAnzahl;
	}

}
