package exam2019_fmi_bachelor_PU_aleksandarKuzmov;
import java.util.Scanner;
public class Clients {
	static Scanner scan = new Scanner(System.in);
	
 private String name;
 private String dateOfRegistry;
 private int numberPurchases;
 private double sumOfPurchases;
 private double rating;
 private String stars;
 
	
 public Clients(String enteredName, String enteredDate,int number, double sum) {
	 setName(enteredName);
	 setDateOfRegistry(enteredDate);
	 setNumberPurchases(number);
	 setSumOfPurchases(sum);
	 calculateStars(number);
 }

	
	public String getName() {
		return name;
	}
	
	public void setName(String enter) {
	
			
			if(enter.length()<=40) {
				name = enter;
			}
		
	}
	
	public String getDateOfRegistry() {
		return dateOfRegistry;
	}
	public void setDateOfRegistry(String enter) {
		int count;
		 
		 count = enter.length() - enter.replace(".", "").length();
		 if(count!=3) {
			 dateOfRegistry = enter;
		 }
		
	}
	public int getNumberPurchases() {
		return numberPurchases;
	}
	public void setNumberPurchases(int enterNumberPurchases) {
		if(enterNumberPurchases>=1 || enterNumberPurchases<=999){
			numberPurchases = enterNumberPurchases;
		}
	}
	public double getSumOfPurchases() {
		return sumOfPurchases;
	}
	public void setSumOfPurchases(double sumOfPurchases) {
		this.sumOfPurchases = sumOfPurchases;
	}

	public String getStars() {
		return this.stars;
	}
	
	public  void displayPeopleByRating(int ratingEntered) {
		if(ratingEntered==rating) {
			displayClientData();
		}
	}
	
	public String displayClientData() {
		String displayClient = String.format("%s, %i, %d, %s, *s",name,numberPurchases,sumOfPurchases,dateOfRegistry,stars);
		
		return displayClient; 
	}
	
	
	
	private void calculateStars(int numberPurchases) {
		int temp = this.numberPurchases;
		if(temp<=99 || temp>=1) {
		stars ="*";
		rating = 1;
		}else if(temp>=100 || temp<=299) {
			stars ="**";
			rating = 2;
		}else if(temp>=300 || temp<=499) {
			stars = "***";
			rating = 3;
		}else if(temp>=500 || temp<=999) {
			stars ="****";
			rating = 4;
		}else {
			stars = "*****";
			rating = 5;
		}
	}
	
	

	
}
