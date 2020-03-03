package exam_2015_Fmi_PlovdivUni;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main  {
public static void main(String[] args) {
	
Scanner scan = new Scanner(System.in);



List<Animal> listWithAnimals = new ArrayList<Animal>();

animalshopMenue(listWithAnimals,scan);


}

static void animalshopMenue( List<Animal> animals, Scanner scan) {
	boolean exit = false;
	while(exit) {
		int select;
	do {
		System.out.println("1|Enter animal data");
		System.out.println("2|Display all animals");
		System.out.println("3|Search by Last Name");
		System.out.println("4|exit");
		System.out.print("Select: ");
		select = Integer.parseInt(scan.nextLine());
	}while(select<1 || select>4);	
	
	switch(select) {
	case 1:
		int numberAnimals;
		do {
			System.out.print("Enter number of animals: ");
			numberAnimals = Integer.parseInt(scan.nextLine());
		}while(numberAnimals<0|| numberAnimals>100);
		
		
		break;
		
	case 2:
		dispalayAllData(animals);
		break;
		
	case 3:
		searchByOwnerName(scan,animals);
		break;
	
	case 4:
		exit=true;
		break;
	}  //swichStatmentEnd
	
	}		//whileStatementEnd
	
} //method


static void enterData(int num,List<Animal> animals,Scanner scan) {
	for(int i =0;i<num;i++) {
		
		String name;
		do {
			System.out.print("Enter name: ");
			name = scan.nextLine();
		}while(name.length()>30);
		
		String type;
		do {
			System.out.print("type: ");
			type = scan.nextLine();
		}while(type.length()>15);
		
		int age;
		do {
			System.out.print("Enter months passed: ");
			age = Integer.parseInt(scan.nextLine());
		}while(age>2000);
		
		String ownerName;
		do {
			System.out.print("Enter owner both names: ");
			ownerName = scan.nextLine();
		}while(!ownerName.contains(" "));
		
		animals.add(new Animal(name,type,age,ownerName));
	}
	
	
}

static void dispalayAllData(List<Animal> animals) {
	Comparator<Animal> sortByType = (a,s) -> a.getType().compareToIgnoreCase(s.getType());
	Comparator<Animal> sortByAge = (a,s) ->Integer.compare(a.getAge(), s.getAge());
	animals.parallelStream().sorted(sortByType
			.thenComparing(sortByAge)
			
	   ).collect(Collectors.toList());
	for(Animal currentAnimal: animals) {
		System.out.println(currentAnimal);
	}
}



static void searchByOwnerName(Scanner scan,List<Animal> animals) {
	System.out.print("Enter owner last name: " );
	String lastName = scan.nextLine();
	int sumAllAges=0;
	int count=0;
	for(int i =0;i<animals.size();i++) {
		if(animals.get(i).getOwnerLastName().equalsIgnoreCase(lastName)) {
			sumAllAges+=animals.get(i).getAge();
			count++;
			System.out.println(animals.get(i));
		}
	}
	
	System.out.println();
	System.out.println("average age: "+ sumAllAges/count);
}

}
