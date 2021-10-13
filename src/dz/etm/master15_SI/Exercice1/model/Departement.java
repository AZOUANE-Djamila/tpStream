package dz.etm.master15_SI.Exercice1.model;

public class Departement {
	private int idDep;
	private String libelle;
	public int getIdDep() {
		return idDep;
	}
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Departement(int idDep, String libelle) {
		super();
		this.idDep = idDep;
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Departement [ID=" + getIdDep() + ", Libelle=" + getLibelle() + "]";
	}
	
	
}
