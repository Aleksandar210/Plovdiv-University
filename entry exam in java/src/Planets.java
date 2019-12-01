import java.util.Scanner;
import java.util.Arrays;
public class Planets {
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		
		//start of the program with a menue
		menue();
		System.out.println("goodbye user");
		
	
		
	}
	
	//Menue
	static void menue() {
		
		
		boolean exit= false;		//determines if the program is over 
		
		
		//displaying options
		
		
		PlanetsData[] stars = new PlanetsData[0];		//creating cass array to store objects
		
		//the program loop
		while(exit==false) {
			
			//displaying options
			System.out.printf("%d|to create objects\n%d|to display\n%d|average mass of a family\n%d|exit\n",1,2,3,4 );
			
		//inviting user to enter option
		System.out.print("chose: ");
		int number;
		
		//entering option
		number=Integer.parseInt(scan.nextLine());
		
		switch(number) {
		case 1:
			
			 stars = createObjects();
			 
			break;
		case 2: 
			if(stars.length==0) {
				System.out.println();
				System.out.println("sorry we cant proceed with no objects assigned.");
				
				
				
			}else {
			for(int i=0;i<stars.length;i++) {
				stars[i].showData();
				System.out.println();
			}
			}
			break;
		case 3: 
			if(stars.length==0) {
				System.out.println("sorry we cant display anything without data.");
				
			}else {
			averageMass(stars);
			}
			break;
			
		case 4: exit=true;
		break;
			
			default: System.out.println("easter egg found, you fool");
			break;
			
			
		}
		System.out.println();
		}
	}
	
	//creating objects
	static PlanetsData[] createObjects() {
		System.out.print("enter nummber of stars: ");
		int number = Integer.parseInt(scan.nextLine());
		
		PlanetsData stars[] = new PlanetsData[number];
		for(int i=0;i<number;i++) {
			stars[i]=new PlanetsData();
		}
		
		return stars;
		
	}
	
	// get average of all star mass of some star family
	static void averageMass( PlanetsData[] stars) {
		
		//entering starFamily to calculate its average mass
		System.out.print("enter starFamily: ");
		String starFamily=scan.nextLine();
		
		//average will contain the return result value
		int average=0;
		int divide=0;
		
		//adding the masses of all stars from that starFamily to average variable
		for(int i=0;i<stars.length;i++) {
		if(stars[i].getstarFamily().equalsIgnoreCase(starFamily)) {
			average+=stars[i].getstarMass();
			divide++;
		}
		}
		
		//calculating average
		average/=divide;			
		System.out.println("average of "+starFamily+" "+average);
		
	}
	
	

}
