package examp_2009_fmi_pld;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	 StudentManager studentM = new StudentManager("PlovdivUni");
	 Scanner scan = new Scanner(System.in);
	 menue(studentM,scan);
	 scan.close();
}

static void menue(StudentManager studM,Scanner scan) {
	int select;
	boolean exit = false;
	while(exit) {
	do {
		System.out.println("1|Add Student");
		System.out.println("2|Select Student");
		System.out.println("3|Display all Data");
		System.out.println("4| Exit");
		System.out.print("Select: ");
		select = Integer.parseInt(scan.nextLine());
	}while(select<1 || select>4);
	
	switch(select){
	case 1:
		System.out.print("faculty Number: ");
		String facNumber;
		do {
			facNumber = scan.nextLine();
		}while(facNumber.length()!=10) ;
		Student stud = new Student(facNumber);
		studM.addStudent(stud);
		break;
        case 2:
		Student currentSelectedStudent  = studM.slectStudent(scan);
		System.out.println();
		boolean back = false;
		while(exit) {
		
		int selectAction;
		do {
			System.out.println("1| change data");
			System.out.println("2| exit");
			System.out.print("Select:  ");
			selectAction  = Integer.parseInt(scan.nextLine());
		}while(selectAction<1 || selectAction>3);
		
		switch(selectAction){
			case 1 :studM.changeStudentData(currentSelectedStudent, scan);
			break;
			case 2:
				back = true;
				break;
		}
		}
		break;
        case 3:
    		studM.displayAllData();
    		break;
        case 4:
        	exit = true;
        	break;
	}
	
	
	
		
	
	}

}





}

