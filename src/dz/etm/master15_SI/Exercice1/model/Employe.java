package dz.etm.master15_SI.Exercice1.model;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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
	private int id,depart;
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
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dOB) {
		this.dateOfBirth = dOB;
	}
	public int getDepart() {
		return depart;
	}
	public void setDepart(int depart) {
		this.depart = depart;
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
			double salary, int depart) throws ParseException {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		//TODO SWITCH DATE
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		setDateOfBirth(sdf.parse(dateOfBirth));
		this.depart = depart;
		this.maried = maried;
		this.salary = salary;
		this.sexe = sexe;
	}
	
	
	
	//5- Implémenter les méthodes
	
	
	public int getAge(Date dateOfBirth) {
		 Calendar today = Calendar.getInstance();
		    Calendar birthDate = Calendar.getInstance();

		    int age = 0;

		    birthDate.setTime(dateOfBirth);
		    if (birthDate.after(today)) {
		        throw new IllegalArgumentException("Can't be born in the future");
		    }
		    

		    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
		    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
		            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
		        age--;

		     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
		    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
		              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
		        age--;
		    }
		    if (age <= 18) throw new IllegalArgumentException("This employee Can't work, He has -18 years");
		    else return age;
		}
	@Override
	public String toString() {
		return "Employe ID=" + getId() + ", Nom=" + getName() + ", Prénom=" + getSurname()
				+ ", Age=" + getAge(getDateOfBirth());
	}
	
	
}
