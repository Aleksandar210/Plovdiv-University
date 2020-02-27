import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Examp_2013_variant_2 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int number;
	do {
		number = Integer.parseInt(scan.nextLine());
	}while(number<0 || number>100);
	
	ArrayList<Message> messages = new ArrayList<Message>();
	
	menue(messages,scan,number);
	scan.close();
	
}

static void menue(ArrayList<Message> messages, Scanner scan, int number) {
	boolean exit = false;
	while(exit) {
		
		int select;
		do{
			System.out.println("1|Enter Message in List");
			System.out.println("2|Display all Data");
			System.out.println("3| search by Date");
			System.out.println("4| search by expired");
			System.out.println("5|Exit");
			System.out.print("Select: ");
			select =Integer.parseInt(scan.nextLine());
			
		}while(select<1|| select>5);
		
		switch(select) {
		case 1: enterMessagesToList(messages,scan,number);
		break;
		case 2:
			System.out.println();
			displayAllMessages(messages);
			break;
		case 3:
			System.out.println();
			searchByDate(messages,scan);
			break;
		case 4:
			System.out.println();
			displayExpired(messages,scan);
			break;
		case 5:
			System.out.println();
			exit=true;
			break;
		}
	}
}


static void enterMessagesToList(ArrayList<Message> messages,Scanner scan, int number) {
	for(int i =0;i<number;i++) {
	System.out.print("Enter title: ");
	String title = scan.nextLine();
	System.out.print("Enter Message: ");
	String message = scan.nextLine();
	System.out.print("Enter date of Entry: ");
	String dateOfEntry;
	int spaceCount;
	do{
		dateOfEntry = scan.nextLine();
		 spaceCount = 0;
		for (char c : dateOfEntry.toCharArray()) {
		    if (c == ' ') {
		         spaceCount++;
		    }
		}
	}while(spaceCount!=3);
	dateOfEntry = dateOfEntry.replace(" ",".");
	
	System.out.print("Enter Expire Date: ");
	String expireDate;
	
	do{
		expireDate = scan.nextLine();
		 spaceCount = 0;
		for (char c : expireDate.toCharArray()) {
		    if (c == ' ') {
		         spaceCount++;
		    }
		}
	}while(spaceCount!=3);
	expireDate = expireDate.replace(" ",".");
	System.out.print("Enter activation hour: ");
	String activationHour;
	do{
		activationHour = scan.nextLine();
		 spaceCount = 0;
		for (char c : activationHour.toCharArray()) {
		    if (c == ' ') {
		         spaceCount++;
		    }
		}
	}while(spaceCount!=2);
	activationHour = activationHour.replace(" ",".");
	
	Message mess = new Message(title,message,dateOfEntry,expireDate,activationHour);
	messages.add(mess);
	}
	
}






static void searchByDate(ArrayList<Message>mesages, Scanner scan) {
	System.out.print("Enter Entry Date: ");
	String enterDate;
	
	int count=0;
	
	do {
		enterDate =  scan.nextLine();
		
		 for(char c: enterDate.toCharArray()) {
			 if(c=='.') {
				 count++;
			 }
		 }
	}while(count!=2);
	
	for(int i =0;i<mesages.size();i++) {
		if(mesages.get(i).getDateOfEntry().equals(enterDate)) {
			System.out.println(mesages.get(i));
		}
	}
}






static void displayAllMessages(ArrayList<Message> messages) {
	ArrayList<Message> temp = new ArrayList<Message>(messages);
	temp.stream().sorted((a,b)->a.getTitle().compareTo(b.getTitle())).collect(Collectors.toList());
	for(Message mess: temp) {
		System.out.println(mess);
	}
}






static void displayExpired(ArrayList<Message>messages,Scanner scan) {
	String enterDate;
	ArrayList<Message> temp= new ArrayList<Message>(messages);

	int count=0;
	do{
		enterDate = scan.nextLine();
		 for(char c: enterDate.toCharArray()) {
			 if(c=='.') {
				 count++;
			 }
		 }
	}while(count!=3);
	
	int[] digitsOfDate = getDigitsOfDate(enterDate);
	
	
	for(int i =0;i<messages.size();i++) {
		int[] currentDigitsOfDate = getDigitsOfDate(messages.get(i).getExpireDate());
		
			 if(currentDigitsOfDate[2]>digitsOfDate[2]) {
				 System.out.println(messages.get(i));
			 }else if(currentDigitsOfDate[1]>digitsOfDate[1]) {
				 System.out.println(messages.get(i));
			 }else if(currentDigitsOfDate[0]>digitsOfDate[0]) {
				 System.out.println(messages.get(i));
			 }else {
				 
			 }
		
	}
	
	
}





private static int[] getDigitsOfDate(String enterDate) {
	String[] tempString = enterDate.split(".");
	int[] digitsOfDate = new int[tempString.length];
	for(int i = 0;i<tempString.length;i++) {
		digitsOfDate[i]=Integer.parseInt(tempString[i]);
	}
	return digitsOfDate;
}

}
