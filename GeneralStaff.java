
public class GeneralStaff extends Employee{
	private String duty;
	
	public GeneralStaff() {
		this.duty = "";
	}
	
	public GeneralStaff(String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		this(duty);
		setDeptName(deptName);
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj) == true) {
			if (obj == null){ return false; }
			if (this == obj) { return true; }//inspired by your override method in the Dog.java file
			if(obj instanceof GeneralStaff) {
			GeneralStaff other = (GeneralStaff) obj;
			if(duty == other.duty) {
				return true;
			}
		}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " GeneralStaff: Duty: %10s", duty );
	}
	
}
