package exam2019_fmi_bachelor_PU_aleksandarKuzmov;
import java.util.ArrayList;
import java.util.Scanner;
public class Eaxam2019_2 {
	static Scanner scan  = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Clients> clients = new ArrayList<Clients>();
		//entering N
		int number;
		do {
			number = Integer.parseInt(scan.nextLine());
		}while(number<1 || number>5000);
		generateAndEnterClients(number,clients);
		clientMenue(clients);
		System.out.println();
		System.out.println("Goodbye User!");
		
		
	}
	static void clientMenue(ArrayList<Clients> clients) {
		boolean exit=false;
		while(!exit) {
		
		System.out.println("1|Display all Clients");
		System.out.println("2|Display clients by star-entered");
		System.out.println("3|Stop");
		int select;
		do {
			select  = Integer.parseInt(scan.nextLine());
		}while(select<1 || select >4);
		switch(select) {
		
		case 1:
			for(int i =0;i<clients.size();i++) {
				System.out.println(clients.get(i).displayClientData());
			}
			break;
		case 2:
			System.out.print("enter rating: ");
			int ratingEntered = Integer.parseInt(scan.nextLine());
			for(int i =0;i<clients.size();i++) {
				clients.get(i).displayPeopleByRating(ratingEntered);
			}
			break;
		case 3: 
			exit = true;
			break;
		}
		
		}
		
	}
	
	//create an object fo type Clients
	static void generateAndEnterClients(int number,ArrayList<Clients>clients) {
		for(int i =0;i<number;i++) {
			System.out.print("Enter name:");
			String name = scan.nextLine();
			System.out.print("Enter date of registry: ");
			String date = scan.nextLine();
			System.out.print("Enter number purchases: ");
			int numberPurch = Integer.parseInt(scan.nextLine());
			System.out.print("enter sum: ");
			double sum = Double.parseDouble(scan.nextLine());
			if(validateEnteredData(name,date,numberPurch)) {
			Clients client = new Clients(name, date,numberPurch,sum);
			clients.add(client);
			}
			
		}
			
		
	}
	
	
	static boolean validateEnteredData(String name,String date, int number) {
		boolean isNameValid = false;
		boolean isDateValid = false;
		boolean isNumberPurchasesValid = false;
		
		
		if(name.length()<=40) {
			isNameValid = true;
		}
		
		String[] count = date.split(".");
		 if(count.length==3) {
			 isDateValid = true;
		 }
		 
		 
		 if(number>=1 || number<=999){
			 isNumberPurchasesValid = true;
		 }
		 
		 
		 if( !(isNumberPurchasesValid ||  isDateValid || isNameValid)) {
			 return false;
		 }else {
			 return true;
		 }
		 
	}

}
