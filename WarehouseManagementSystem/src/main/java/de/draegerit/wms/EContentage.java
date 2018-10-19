package de.draegerit.wms;

public enum EContentage {
	LOGOUT("logout"), HALLETBL("halleTbl"),BENUTZERVERWALTUNG("benutzerverwaltung");

	private String page;

	private EContentage(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}
}
