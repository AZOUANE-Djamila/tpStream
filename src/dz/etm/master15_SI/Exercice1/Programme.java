package dz.etm.master15_SI.Exercice1;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.util.Pair;

import dz.etm.master15_SI.Exercice1.model.Departement;
import dz.etm.master15_SI.Exercice1.model.Employe;

public class Programme {

	public static void main(String[] args) throws ParseException {
	    ArrayList<Employe> employesList = new ArrayList<Employe>();  
	    Departement DRh = new Departement(1,"Ressources Humaines");
	    Departement DFc = new Departement(2,"Finances & comptabilité");
	    Departement DIn = new Departement(3,"Informatique");
	    List<Departement> departementsList = new ArrayList<Departement>();
	    departementsList.add(DRh);
	    departementsList.add(DFc);
	    departementsList.add(DIn);
	    //Adding Employees
		employesList.add(new Employe(1,"Mohamedi","Mohamed","08/05/1945",'m',true,5555.00,DRh));
		employesList.add(new Employe(2,"Rih","Amina","01/11/1954",'f',true,44444.00,DFc));
		employesList.add(new Employe(3,"Loubar","Fares","20/08/1955",'m',false,33333.00,DIn));
		employesList.add(new Employe(4,"Kaidi","Rabie","20/08/1956",'f',true,55555.00,DFc));
		employesList.add(new Employe(5,"Boulehbel","Mohamed","11/12/1961",'m',true,66666.00,DFc));
		employesList.add(new Employe(6,"Ait Kaci","Amina","18/03/1962",'f',false,4444400,DRh));
		employesList.add(new Employe(7,"Bouteldja","Zakaria","05/07/1962",'m',false,33333.00,DIn));
		
		 
		 System.out.println("La liste des employés ayant moins de 60 ans\n");
		 employesList.stream()  
	                .filter(e ->e.getAge() < 60)   // filtering ages
	                .map(em -> em.toString())
					.forEach(System.out::println);
		System.out.println("\nLa liste des hommes mariés :");
		employesList.stream()  
        .filter(e -> (e.getSexe() == 'm' && e.getMaried())) 
        .map(em -> em.toString())
		.forEach(System.out::println);
		
		System.out.println("\n____________________________________________________________________________________");
		// 8.	Récupérer une liste des employés triée alphabétiquement ; 	
		System.out.println("\nLa liste des employés triés alphabetiquement :");
		employesList.stream().sorted(Comparator.comparing(e->e.getName()))
        .collect(Collectors.toList()).forEach(System.out::println);
		
		// 9.	Récupérer une liste des employés triée par âge et s’ils ont le même âge par salaire décroissant ;  Stream.sorted() + Comparator.comparing() + Comparator.thenComparing()
		System.out.println("\nLa liste des employés triée par âge et s’ils ont le même âge par salaire décroissant_______________________________________");
		 	Comparator<Employe> AgeComparator = Comparator.comparing(Employe::getAge);
	        Comparator<Employe> salaryAgeComparator = AgeComparator.thenComparing(Employe::getSalary).reversed();
	        List<Employe> sortedList = employesList.stream().sorted(salaryAgeComparator).collect(Collectors.toList());

	        for (Employe employesorted : sortedList) {
	            System.out.println("Nom & Prénom: "+ employesorted.getName() + " "+ employesorted.getSurname() +" - Age " + employesorted.getAge() + " - Salaire:"+ employesorted.getSalary());
	        }
	        
	    // Récupérer une liste de 2 employés à partir du 3ième ;Stream.limit() + Stream.skeep()
			System.out.println("\nRécupérer une liste des 2 employés à partir du 3ième_______________________________________");
			Stream<Employe> sEmp = employesList.stream();
			List<Employe> limit2 = sEmp.skip(2).limit(2).collect(Collectors.toList());
			for (Employe employeListLimit : limit2) {
	            System.out.println("Nom & Prénom: "+ employeListLimit.getName() + " "+ employeListLimit.getSurname() +" - Age " + employeListLimit.getAge() + " - Salaire:"+ employeListLimit.getSalary());
	        }
			
		//TODO	Récupérer une liste sans répétition des prénoms des employés ; Stream.map() + Stream.distinct()
			System.out.println("\nLa liste sans répétition des prénoms des employés___________________________________________");
			employesList.stream().map(e -> e.getSurname()).distinct()
										.collect(Collectors.toList()).forEach(System.out::println);
			for (Employe employeListLimit : limit2) {
	            System.out.println("Nom & Prénom: "+ employeListLimit.getName() + " "+ employeListLimit.getSurname() +" - Age " + employeListLimit.getAge() + " - Salaire:"+ employeListLimit.getSalary());
	        }
		
		//	Grouper les employés par id de département. Afficher le résultat ; 	          Stream.collect() + Collectors.groupingBy()
			System.out.println("\nGrouper les employés par id de département. Afficher le résultat _____________________________");
			 Map<String, List<Employe>> groupByDepartMap = employesList.stream().collect(Collectors.groupingBy(Employe::getNameDepartement));//ou bien getDepartement
			 groupByDepartMap.forEach(
					 (k, v) -> System.out.println("\nDépartement: " +k +"   \n" + "   Nom   | Prénom| DateNaiss  |Sexe| Age | Est marié(e)? | Salaire\n" +
					   ((List < Employe > ) v).stream()
					   						.map(m -> "- "+ m.getName()+" | "+ m.getSurname()+" | "+ m.getDateOfBirth()+" | "+ m.getSexe()+" | "+ m.getAge() +" | "+ m.toStringMarried()+" | "+ m.getSalary()+"\n")
					   						.collect(Collectors.joining(""))));
			 System.out.println(groupByDepartMap);
			
		//	Diviser la liste des employés en deux : célibataire(s) et marié(e)(s) ; Stream.collect() + Collectors.partitionningBy()
		System.out.println("La liste des employés mariés: \n" + employesList.stream().collect(Collectors.partitioningBy(Employe::getMaried))+"\n");
		System.out.println("La liste des employés célibataire: \n" + employesList.stream().collect(Collectors.partitioningBy(e->e.getMaried()==false)));
		//	Faire une jointure entre la liste des employés et des départements. Puis afficher pour chaque employé son nom et prénom ainsi que le nom de son département      Stream.flatMap() + Stream.map() + classe javax.util.Pair<K,V>
        System.out.println("\nchaque employé son nom et prénom ainsi que le nom de son département___________________________________________");
		
        List<Pair<Employe,Departement>> listEmpDep = employesList.stream()
															   .flatMap(e-> departementsList.stream().filter(d-> d.getIdDep() == e.getDepartement().getIdDep()) // jointure au lieu du produit cartésien
															   .map(d-> new Pair<Employe,Departement>(e,d)))
															   .collect(Collectors.toList());
		listEmpDep.forEach(ed->System.out.println(ed.getKey()+ " "+ed.getValue()));
		  	
		//	Afficher le salaire minimum, maximum et moyen
        System.out.println("\nAfficher le salaire minimum, maximum et moyen____________________________________________");
		DoubleSummaryStatistics salaryMinMax = employesList.stream().collect(Collectors.summarizingDouble(Employe::getSalary));
		System.out.println("Le salaire minimum est: "+salaryMinMax.getMin());
		System.out.println("Le salaire maximum est: "+salaryMinMax.getMax());
		System.out.println("La moyenne des salaires est : "+salaryMinMax.getAverage());

	}

	}
