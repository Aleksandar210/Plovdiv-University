import java.util.Scanner;
public class PlanetsData {
	Scanner scan = new Scanner(System.in);		//creating a scanner object to get input from user
	
	//class lines
	protected String name;
	protected double distance;
	protected int category;
	protected double starMass;
	protected String starFamily;
	protected String categoryName;
	
	
	
	public PlanetsData() {
		//adding values to the fields
		setName();
		setDistance();
		setCategory();
		setMass();
		setstarFamily();
		
		
	}
	
	//getters and setters
	
	//-------------------------------------------------------------
	//setters
	public void setName() {
		do {
		System.out.print("enter star name: ");
		this.name=scan.nextLine();
		}while(name.length()>20);
		
	}
	
	
	public void setDistance() {
		do {
		System.out.print("enter distacne: ");
		this.distance=Double.parseDouble(scan.nextLine());
		}while(distance<1);
	}
	
	
	public void setCategory() {
		do {
			
			System.out.print("enter category: ");
			this.category=Integer.parseInt(scan.nextLine());
		}while(this.category>9||this.category<1);
	
	}
	
	public void setstarFamily() {
		do {
			System.out.print("star family:");
		this.starFamily=scan.nextLine();
				
		}while(this.starFamily.length()>30);
		}
	
	public void setMass() {
		do {
			System.out.print("set star mass: ");
			this.starMass=Double.parseDouble(scan.nextLine());
		}while(this.starMass<1);
	}
	
	
	
	//-----------------------------------------------------------------
	//getters
	
	public String getName() {
		return this.name;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	
	public String getCategory() {
		switch(this.category) {
		case 1: categoryName="HyperGiant";
		break;
		case 2: categoryName="ultraGiant";
		break;
		case 3: categoryName="brightGiant";
		break;
		case 4: categoryName="Giants";
		break;
		case 5: categoryName="subGiants";
		break;
		case 6: categoryName="Dwarfs";
		break;
		case 7: categoryName="subDwarfs";
		break;
		case 8: categoryName="blackDwarfs";
		break;
		case 9: categoryName="brownDwarfs";
		break;
		default: categoryName="uknown";
		
		
		}
		return categoryName;
	}
	
	public String getstarFamily() {
		return this.starFamily;
		}
		
		
	
	public double getstarMass() {
		return this.starMass;
	}
	
	

	
	
	
	
	//methods and functions
	
	//display stars data
	public void showData() {
		System.out.printf("%s\n%.2f\n%s\n%.2f\n%s\n",getName(),getDistance(),getCategory(),getstarMass(),getstarFamily());
		
	}
	
	
	
	
	

}
