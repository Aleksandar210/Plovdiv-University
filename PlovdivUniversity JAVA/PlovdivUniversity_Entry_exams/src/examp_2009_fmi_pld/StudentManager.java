package examp_2009_fmi_pld;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	private String schoolName;
private ArrayList<Student> students = new ArrayList<Student>();

public StudentManager(String schoolName) {
	this.schoolName = schoolName;
}

public void addStudent(Student stud) {
	students.add(stud);
}

public Student slectStudent(Scanner scan) {
	int index = -1;
	for(Student stud :students) {
		System.out.println((index++)+"|  "+stud);
	}
	System.out.println();
	int select;
	do {
		System.out.print("Select: ");
		select  = Integer.parseInt(scan.nextLine());
	}while(select>index || select<0);
	return students.get(select);
}

public void changeStudentData(Student stud,Scanner scan) {

int select;
do {
	System.out.println("1| Change name");
	System.out.println("2| Exit");
	System.out.print("Select: ");
	select = Integer.parseInt(scan.nextLine());
}while(select<1 || select>2);


}


public void displayAllData() {
	for(Student std: students) {
		System.out.println(std);
	}
}
}
