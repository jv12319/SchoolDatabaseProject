
public class Course implements Comparable<Course>{

	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept; 
	private int numCredits;
	

	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		if(isGraduateCourse() == true) {
			return ("G" +  courseDept + courseNum);
		} else {
			return ("U" +  courseDept + courseNum);
		}
	}
	
	@Override
	public boolean equals(Object obj) {//all attributes must match for 2 Course objects to be considered equal
		if (obj == null){ return false; }
		if (this == obj) { return true; }//inspired by your override method in the Dog.java file
		if(obj instanceof Course) {
		Course other = (Course) obj;
		if(isGraduateCourse == other.isGraduateCourse) {
			if(courseNum == other.courseNum) {
				if(courseDept == other.courseDept) {
					if(numCredits == other.numCredits) {
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
		if(isGraduateCourse() == true) {
			return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate"
					, courseDept, courseNum, numCredits, isGraduateCourse);
		} else {
			return String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate"
					, courseDept, courseNum, numCredits, isGraduateCourse);
		}
	}
	
	public int compareTo(Course c) {
	//use the Comparable interface specification. Sort by courseNum
		//inspired by ch10 slides comparing dogs
		if(this.courseNum > c.courseNum) {
			return 1;
		} else if (this.courseNum < c.courseNum) {
			return -1;
		} else {
			return 0;
		}
	}
}
