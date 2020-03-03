package exam_2015_Fmi_PlovdivUni;

public class Animal {
	private String name;
	private String type;
	private int age;
	private String ownerFirstName;
	private String ownerLastName;

	
	public Animal(String name,String type,int age, String ownerNames, ) {
		this.name= name;
		this.type = type;
		this.age = age;
		String[] names = ownerNames.split(" ");
		this.ownerFirstName = names[0];
		this.ownerLastName = names[1];
		
	}

	@Override
	public String toString() {
		return this.name+" Animale Type: "+this.type+" age :"+this.age+" owner: "+getOwnerFirstName()+ " "+ getOwnerLastName()+ " ID: "+this.ownerId; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	
	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerFirstName(String ownerNames) {
		this.ownerFirstName = ownerNames;
	}
	
	public void setOwnerLastName(String ownerNames) {
		this.ownerLastName = ownerNames;
	}
	
	

}
