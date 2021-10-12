package dz.etm.master15_SI.Exercice1;

import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
//import javafx.util.Pair;  

import dz.etm.master15_SI.Exercice1.model.Departement;
import dz.etm.master15_SI.Exercice1.model.Employe;

public class Programme {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*Employe emp = new Employe(1);//TODO GENERATE ID AUTOMIATIQUELY
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter surname\t");
	    String surname = myObj.nextLine();// Read user input
	    emp.setSurname(surname);	    
	    System.out.println("Enter name\t");
	    String name = myObj.nextLine();// Read user input
	    emp.setName(name);
	    
	    System.out.println("Enter your date of birth\t");
	    Scanner scanner = new Scanner(System.in);
	  //read the desired input
	   String dateAsString = scanner.next();
	   String pattern = "dd/MM/yyyy";
	   SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	  //parse the String as a Date
	  Date desiredDate = sdf.parse(dateAsString);

	  emp.setDateOfBirth(desiredDate);
	  int age = emp.getAge(emp.getDateOfBirth());
	    System.out.println(emp.toString());*/

	    ArrayList<Employe> employesList = new ArrayList<Employe>();  
	    Departement DRh = new Departement(1,"Ressources Humaines");
	    Departement DFc = new Departement(2,"Finances & comptabilit�");
	    Departement DIn = new Departement(3,"Informatique");
	    //Adding Employees
		employesList.add(new Employe(1,"Mohamedi","Mohamed","08/05/1945",'m',true,5555.00,DRh));
		employesList.add(new Employe(2,"Rih","Amina","01/11/1954",'f',true,44444.00,DFc));
		employesList.add(new Employe(3,"Loubar","Fares","20/08/1955",'m',false,33333.00,DIn));
		employesList.add(new Employe(4,"Kaidi","Rabie","20/08/1956",'f',true,55555.00,DFc));
		employesList.add(new Employe(5,"Boulehbel","Mohamed","11/12/1961",'m',true,66666.00,DFc));
		employesList.add(new Employe(6,"Ait Kaci","Amina","18/03/1962",'f',false,4444400,DRh));
		employesList.add(new Employe(7,"Bouteldja","Zakaria","05/07/1962",'m',false,33333.00,DIn));
		
		 
		 System.out.println("La liste des employ�s ayant moins de 60 ans\n");
		 employesList.stream()  
	                .filter(e ->e.getAge() < 60)   // filtering ages
	                .map(em -> em.toString())
					.forEach(System.out::println);
		System.out.println("\nLa liste des hommes mari�s :");
		employesList.stream()  
        .filter(e -> (e.getSexe() == 'm' && e.getMaried()))  // filtering price 
        .map(em -> em.toString())
		.forEach(System.out::println);
		
		System.out.println("\n____________________________________________________________________________________");
		//TODO 8.	R�cup�rer une liste des employ�s tri�e alphab�tiquement ; 	
		System.out.println("\nLa liste des ploy�s tri�s alphabetiquement :");
		employesList.stream().sorted(Comparator.comparing(e->e.getName()))
        .collect(Collectors.toList()).forEach(System.out::println);
		
		//TODO 9.	R�cup�rer une liste des employ�s tri�e par �ge et s�ils ont le m�me �ge par salaire d�croissant ;  Stream.sorted() + Comparator.comparing() + Comparator.thenComparing()
		System.out.println("\n____________________________________________________________________________________");
		System.out.println("\nLa liste des employ�s tri�e par �ge et s�ils ont le m�me �ge par salaire d�croissant");
		 	Comparator<Employe> AgeComparator = Comparator.comparing(Employe::getAge);
	        Comparator<Employe> salaryAgeComparator = AgeComparator.thenComparing(Employe::getSalary).reversed();
	        List<Employe> sortedList = employesList.stream().sorted(salaryAgeComparator).collect(Collectors.toList());

	        for (Employe employesorted : sortedList) {
	            System.out.println("Nom & Pr�nom: "+ employesorted.getName() + " "+ employesorted.getSurname() +" - Age " + employesorted.getAge() + " - Salaire:"+ employesorted.getSalary());
	        }
	        
	    //TODO R�cup�rer une liste de 2 employ�s � partir du 3i�me ;Stream.limit() + Stream.skeep()
			System.out.println("\n____________________________________________________________________________________");
			System.out.println("\nR�cup�rer une liste des 2 employ�s � partir du 3i�me_______________________________________");
			Stream<Employe> sEmp = employesList.stream();
			List<Employe> limit2 = sEmp.skip(2).limit(2).collect(Collectors.toList());
			for (Employe employeListLimit : limit2) {
	            System.out.println("Nom & Pr�nom: "+ employeListLimit.getName() + " "+ employeListLimit.getSurname() +" - Age " + employeListLimit.getAge() + " - Salaire:"+ employeListLimit.getSalary());
	        }
			
		//TODO	R�cup�rer une liste sans r�p�tition des pr�noms des employ�s ; Stream.map() + Stream.distinct()
			System.out.println("\nLa liste sans r�p�tition des pr�noms des employ�s___________________________________________");
			employesList.stream().map(e -> e.getName()).distinct()
										.collect(Collectors.toList()).forEach(System.out::println);
			for (Employe employeListLimit : limit2) {
	            System.out.println("Nom & Pr�nom: "+ employeListLimit.getName() + " "+ employeListLimit.getSurname() +" - Age " + employeListLimit.getAge() + " - Salaire:"+ employeListLimit.getSalary());
	        }
		
		//TODO	Grouper les employ�s par id de d�partement. Afficher le r�sultat ; 	          Stream.collect() + Collectors.groupingBy()
			System.out.println("\nGrouper les employ�s par id de d�partement. Afficher le r�sultat _____________________________");
			 Map<String, List<Employe>> groupByDepartMap = employesList.stream().collect(Collectors.groupingBy(Employe::getNameDepartement));
			 groupByDepartMap.forEach((k, v) -> System.out.println("\nD�partement: " +k +"   \n" + "   Nom   | Pr�nom| DateNaiss  |Sexe| Age | Est mari�(e)? | Salaire\n" +
					   ((List < Employe > ) v).stream().map(m -> "- "+ m.getName()+" | "+ m.getSurname()+" | "+ m.getDateOfBirth()+" | "+ m.getSexe()+" | "+ m.getAge() +" | "+ m.toStringMarried()+" | "+ m.getSalary()+"\n")
					  .collect(Collectors.joining(""))));
			 System.out.println(groupByDepartMap);
			
		//TODO	Diviser la liste des employ�s en deux : c�libataire(s) et mari�(e)(s) ; Stream.collect() + Collectors.partitionningBy()
		System.out.println(employesList.stream().collect(Collectors.partitioningBy(Employe::getMaried)));

		//TODO	Faire une jointure entre la liste des employ�s et des d�partements. Puis afficher pour chaque employ� son nom et pr�nom ainsi que le nom de son d�partement      Stream.flatMap() + Stream.map() + classe javax.util.Pair<K,V>
		//Pair<Employe, Departement> p = new Pair<>();  

		//List<Employe> employesdep = employesList.stream().map(e -> e.getName()).flatMap(d -> d.stream()).collect(Collectors.toList());
		  	
		System.out.println("\n____________________________________________________________________________________");

		//TODO	Afficher le salaire minimum, maximum et moyen ;		         Stream.collect() + Collectors.SummarizingDouble()
		DoubleSummaryStatistics salaryMinMax = employesList.stream().collect(Collectors.summarizingDouble(Employe::getSalary));
		System.out.println("Le salaire minimum est: "+salaryMinMax.getMin());
		System.out.println("Le salaire maximum est: "+salaryMinMax.getMax());
	}

	private static Departement Departement(int i, String string) {
		// TODO Auto-generated method stub
		return null;
	}}
