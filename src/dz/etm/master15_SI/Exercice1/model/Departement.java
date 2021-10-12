package dz.etm.master15_SI.Exercice1.model;

public class Departement {
	private int id;
	private String libelle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Departement(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Departement [ID=" + getId() + ", Libelle=" + getLibelle() + "]";
	}
	
	
}
