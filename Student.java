
public class Student extends Person implements Comparable<Person>{
	private static int numStudents;
	private int studentID;
	private Course [] coursesTaken = new Course[50];
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major = "undeclared";
	
	
	public Student() {
		numStudents++;
		studentID = numStudents;
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		isGraduate = false;
	}
	
	public Student(boolean isGraduate) {
		this();
		this.isGraduate = isGraduate;
	}
	
	public Student(String major, boolean isGraduate) {
		this();
        this.major = major;
        this.isGraduate = isGraduate;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		this();
		this.major = major;
		this.isGraduate = isGraduate;
		super.setName(name);
		super.setBirthYear(birthYear);
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getMajor(){
		return major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		if(numCoursesTaken < coursesTaken.length) {
			coursesTaken[numCoursesTaken] = course;
			numCoursesTaken++;
		} else {
			System.out.println("coursesTaken has reached capacity of 50");
	}
	}
	
	public void addCoursesTaken(Course [] course) {
		for(Course i : course) { // i = each Course object in course array ie a loop var
			if(numCoursesTaken < coursesTaken.length) {
				coursesTaken[numCoursesTaken] = i;
				numCoursesTaken++;
			} else {
				System.out.println("coursesTaken has reached capacity of 50");
		}
		}
	}
	
	public Course getCourseTaken(int index) {
		if(index >= 0 && index < numCoursesTaken) {
			Course courseTaken = coursesTaken[index];
			return courseTaken;
		} else {
			return null;
		}
	}
	
	public String getCourseTakenAsString(int index) {
		Course result = getCourseTaken(index);
		if(result == null) {
			return "";
		} else {
			return getCourseTaken(index).toString();
		}
	}
	
	public String getAllCoursesTakenAsString() {
		String coursesAsString = "";
		for(int i = 0; i < coursesTaken.length; i++) {
		 coursesAsString += getCourseTakenAsString(i);
		}
			return coursesAsString;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj) == true) {
			if (obj == null){ return false; }
			if (this == obj) { return true; }//inspired by your override method in the Dog.java file
			if(obj instanceof Student) {
			Student other = (Student) obj;
			if(numStudents == other.numStudents) {
				if(studentID == other.studentID) {
					if(coursesTaken == other.coursesTaken) {
						if(numCoursesTaken == other.numCoursesTaken) {
							if(isGraduate == other.isGraduate) {
								if(major == other.major) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(isGraduate == true) {
			String graduateStatus = "Graduate";
			return String.format(super.toString() + " Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
					studentID, major, graduateStatus, numCoursesTaken, getAllCoursesTakenAsString());
		} else {
			String graduateStatus = "Undergraduate";
			return String.format(super.toString() + " Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
					studentID, major, graduateStatus, numCoursesTaken, getAllCoursesTakenAsString());
		}
	}
	
	@Override
	public int compareTo(Person p) {
		//use the Comparable interface specification. Sort by numCredits (possibly numCoursesTaken?)
		if(p instanceof Student) {
			Student es = (Student) p;//cast p to student
				if(this.numCoursesTaken > es.numCoursesTaken) {
					return 1;
				} else if (this.numCoursesTaken < es.numCoursesTaken) {
					return -1;
				} else {
					return 0;
				}
		} else {
			return 0;
		}
	}
	

}
