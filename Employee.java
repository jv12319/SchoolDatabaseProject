
public class Employee extends Person implements Comparable<Person>{

	private String deptName;
	private static int numEmployees = 0;
	private int employeeID = 0;		//generated
	
	public Employee() {
		deptName = "";
		numEmployees++;
		employeeID = numEmployees;//figured this out by rereading Dog (2).java in the drive
	}
	
	public Employee(String deptName) {
		this();
		this.deptName = deptName;
	}
	
	public Employee(String name, int birthYear, String deptName) {
		this();
		setName(name);//figured this out by rereading ShowDog file in the drive shared
		setBirthYear(birthYear);
		this.deptName = deptName;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj) == true) {
			if (obj == null){ return false; }
			if (this == obj) { return true; }//inspired by your override method in the Dog.java file
			if(obj instanceof Employee) {
			Employee other = (Employee) obj;
			if(deptName == other.deptName) {
				if(employeeID == other.employeeID) {
					if(numEmployees == other.numEmployees) {
						return true;
					}
				}
			}
		}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
	}
	
	@Override
	public int compareTo(Person p) {
		//use the Comparable interface specification. Sort by employeeID
		if(p instanceof Employee) {
			Employee e = (Employee) p;//cast p to Employee
				if(this.employeeID > e.employeeID) {
					return 1;
				} else if (this.employeeID < e.employeeID) {
					return -1;
				} else {
					return 0;
				}
		} else {
			return 0;
		}
	}
	

}
