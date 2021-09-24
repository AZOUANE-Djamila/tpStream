package dz.etm.master15_SI.Exercice1;

import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

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
	    //Adding Employees
		employesList.add(new Employe(1,"Mohamedi","Mohamed","08/05/1945",'m',true,5555.00,1));
		employesList.add(new Employe(2,"Rih","Amina","01/11/1954",'f',true,44444.00,2));
		employesList.add(new Employe(3,"Loubar","Fares","20/08/1955",'m',false,33333.00,3));
		employesList.add(new Employe(4,"Kaidi","Rabie","20/08/1956",'f',true,55555.00,2));
		employesList.add(new Employe(5,"Boulehbel","Mohamed","11/12/1961",'m',true,66666.00,2));
		employesList.add(new Employe(6,"Ait Kaci","Amina","18/03/1962",'f',false,4444400,1));
		employesList.add(new Employe(7,"Bouteldja","Zakaria","05/07/1962",'m',false,33333.00,3));
		System.out.println("La liste des employés ayant moins de 60 ans\n");
		employesList.stream()  
	                .filter(e ->e.getAge(e.getDateOfBirth()) < 60)   // filtering ages
	                .map(em -> em.toString())
					.forEach(System.out::println);
		System.out.println("\nLa liste des hommes mariés :");
		employesList.stream()  
        .filter(e -> (e.getSexe() == 'm' && e.getMaried()))  // filtering price 
        .map(em -> em.toString())
		.forEach(System.out::println);
		
		System.out.println("\nLa liste des ployés triés alphabetiquement :");
		employesList.stream().sorted(Comparator.comparing(e->e.getName()))
        .collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("\nLa liste des employés triée par âge et s’ils ont le même âge par salaire décroissant");
		/*employesList.stream()
		.sorted(Comparator.comparing(e->e.getAge(e.getDateOfBirth()).thenComparing(employeList.getSalary())
        .collect(Collectors.toList())
        .forEach(System.out::println);*/
	}

}
