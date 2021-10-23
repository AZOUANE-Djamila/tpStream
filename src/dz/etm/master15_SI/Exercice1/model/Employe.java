package dz.etm.master15_SI.Exercice1.model;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 1 - Créer les deux classes en spécifiant le package, et les constructeurs
/**
 * Représente un employé dans une société
 * @author AZOUANE DJAMILA
 * @version 1.0 (21 JUIN 2021)
 * 
 */
public class Employe {
	//Définition des attributs
	private int id;
	private Departement departement;
	private String name, surname;
	private Date dateOfBirth;
	private boolean maried;
	private double salary;
	private char sexe;
	
	//TODO Vérifier la plage des valeurs
	
	//Génération des getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDateOfBirth() {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(dateOfBirth);
		return date;
	}
	public void setDateOfBirth(Date dOB) {
		this.dateOfBirth = dOB;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public boolean getMaried() {
		return maried;
	}
	public void setMaried(boolean maried) {
		this.maried = maried;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	
	//4 -  Créer les constructeurs
	public Employe(int id) {
		super();
		this.id = id;
	}
	public Employe(int id, String name, String surname, String dateOfBirth, char sexe,boolean maried,
			double salary, Departement depart) throws ParseException {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		setDateOfBirth(sdf.parse(dateOfBirth));
		setDepartement(depart);
		this.maried = maried;
		this.salary = salary;
		this.sexe = sexe;
	}
	
	
	
	//5- Implémenter les méthodes
	public String getNameDepartement() {
		return departement.getLibelle();
	}
	public int getAge() {
		 Calendar today = Calendar.getInstance();
		 Calendar cBithDay = Calendar.getInstance();
		 cBithDay.setTime(dateOfBirth);
		    int age = 0;

		    //birthDate.setTime(getDateOfBirth());
		    if (cBithDay.after(today)) {
		        throw new IllegalArgumentException("La date de naissance est supérieur à celle d'aujourd'hui!");
		    }
		    

		    age = today.get(Calendar.YEAR) - cBithDay.get(Calendar.YEAR);

		    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
		    if ( (cBithDay.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
		            (cBithDay.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
		        age--;

		     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
		    }else if ((cBithDay.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
		              (cBithDay.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
		        age--;
		    }
		    if (age <= 18) throw new IllegalArgumentException("Cet employé ne peut pas travailler, il a -18 ans");
		    else return age;
		}
	@Override
	public String toString() {
		return "Employe ID=" + getId() + ", Nom=" + getName() + ", Prénom=" + getSurname()
				+ ", Age=" + getAge();
	}
	
	
	public String toStringMarried() {
		if (getMaried()) return "Oui";
		else return "Non";
		
	}
	public String situationEmploye() {
		if (getMaried()) return "Marié(e)";
		else return "Célibataire";
		
	}
}
