

public class Faculty extends Employee implements Comparable<Person>{
	
	private Course[] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	public Faculty() {
		super();
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}
	
	public Faculty(boolean isTenured) {
		this();
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		this();
		setDeptName(deptName);
		this.isTenured = isTenured;
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		this();
		setName(name);
		setBirthYear(birthYear);
		setDeptName(deptName);
		this.isTenured = isTenured;
	}
	
	public boolean isTenured() {
		return isTenured;
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {
		if(numCoursesTaught < coursesTaught.length) {
			coursesTaught[numCoursesTaught] = course;
			numCoursesTaught++;
		} else {
			System.out.println("coursesTaught has reached capacity of 100");
	}
	}
	
	public void addCoursesTaught(Course [] course) {
		for(Course i : course) {
		if(numCoursesTaught < coursesTaught.length) {
			coursesTaught[numCoursesTaught] = i;
			numCoursesTaught++;
		} else {
			System.out.println("coursesTaught has reached capacity of 100");
	}
	}
	}
	
	public Course getCourseTaught(int index) {
		if(index >= 0 && index < numCoursesTaught) {
			Course courseTaught = coursesTaught[index];
			return courseTaught;
		} else {
			return null;
		}
		
	}
	
	public String getCourseTaughtAsString(int index) {
		Course result = getCourseTaught(index);
		if(result == null) {
			return "";
		} else {
			return getCourseTaught(index).toString();
		}
	}
	
	public String getAllCoursesTaughtAsString() {
		String coursesAsString = "";
		for(int i = 0; i < coursesTaught.length; i++) {
		 coursesAsString += getCourseTaughtAsString(i);
		}
			return coursesAsString;
		}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj) == true) {
			if (obj == null){ return false; }
			if (this == obj) { return true; }//inspired by your override method in the Dog.java file
			if(obj instanceof Faculty) {
			Faculty other = (Faculty) obj;
			if(coursesTaught == other.coursesTaught) {
				if(numCoursesTaught == other.numCoursesTaught) {
					if(isTenured == other.isTenured) {
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
		if(isTenured == true) {
			String tenuredStatus = "Is Tenured";
			return String.format(super.toString() + " Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
					tenuredStatus, numCoursesTaught, getAllCoursesTaughtAsString());
		} else {
			String tenuredStatus = "Not Tenured";
			return String.format(super.toString() + " Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
					tenuredStatus, numCoursesTaught, getAllCoursesTaughtAsString());
		}
	}
	
	@Override
	public int compareTo(Person p) {
		//use the Comparable interface specification. Sort by numCoursesTaught

		if(p instanceof Faculty) {
			Faculty f = (Faculty) p;//cast p to Faculty
				if(this.numCoursesTaught > f.numCoursesTaught) {
					return 1;
				} else if (this.numCoursesTaught < f.numCoursesTaught) {
					return -1;
				} else {
					return 0;
				}
		} else {
			return 0;
		}
	}
	
		
}
