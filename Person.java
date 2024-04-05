
public class Person implements Comparable<Person>{
	private String name;
	private int birthYear;
	
	public Person() {
		this.name = "";
		this.birthYear = 0;
	}
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int year) {
		this.birthYear = year;
	}
	
	
	@Override
	public boolean equals(Object obj) {	
	//all attributes must match for 2 Person objects to be considered equal
		if (obj == null){ return false; }
		if (this == obj) { return true; }//inspired by your override method in the Dog.java file
		if(obj instanceof Person) {
		Person other = (Person) obj;
		if(name == other.name) {
			if(birthYear == other.birthYear) {
				return true;
			}
		}
	}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	}
	
	public int compareTo(Person p) {
		//use the Comparable interface specification. Sort by birthYear.
		if(this.birthYear > p.birthYear) {
			return 1;
		} else if (this.birthYear < p.birthYear) {
			return -1;
		} else {
			return 0;
		}
	}
	

}
