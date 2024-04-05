import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

//Java updated txt file video https://youtu.be/rcn7y9fNPwA
//Code overview https://youtu.be/9IX-0QiMy6g

public class Driver_SchoolDB {
	public static void main(String[] args) {
		
		TextFileHandler handler = new TextFileHandler();
		String fileName = "SchoolDB_Initial.txt";
		
		handler.readFileWriteToConsole(fileName);
		
		Course course1 = new Course(true, 771, "MAT", 4);
		Faculty faculty1 = new Faculty();
		Faculty faculty2 = new Faculty(true);
		Faculty faculty3 = new Faculty("MAT",false);
		Faculty faculty4 = new Faculty("Superman",1938,"PHY",true);
		
		Student student1 = new Student();
		Student student2 = new Student(false);
		Student student3 = new Student("Math",false);
		Student student4 = new Student("Wonderwoman",1941,"JST",true);
		
		GeneralStaff genStaff1 = new GeneralStaff();
		GeneralStaff genStaff2 = new GeneralStaff("advise students");
		GeneralStaff genStaff3 = new GeneralStaff("Sanitation", "clean");
		GeneralStaff genStaff4 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
		
		Course course2 = new Course(true, 777, "CMP", 4);
		Course course3 = new Course(true, 711, "CMP", 4);
		Course course4 = new Course(true, 723, "MAT", 4);
		Course course5 = new Course(false, 168, "CMP", 4);
		Course course6 = new Course(false, 338, "CMP", 4);
		
		Course allCs [] = {course1, course2, course3, course4, course5, course6};
		System.out.println("\n**************************************************************");
		System.out.println("SCHOOL DATABASE INFO:\n");
		System.out.println("************************************************");
		System.out.println("COURSES:");
		for(int i=0; i<allCs.length; i++){
			System.out.println(allCs[i].toString());
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("PERSONS:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("EMPLOYEES:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("GENERAL STAFF:");
		GeneralStaff allGs [] = {genStaff1, genStaff2, genStaff3, genStaff4};
		for(int i=0; i<allGs.length; i++){
			System.out.println(allGs[i].toString());
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("FACULTY:");
		Faculty allFs [] = {faculty1, faculty2, faculty3, faculty4};
		for(int i=0; i<allFs.length; i++){
			System.out.println(allFs[i].toString());
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("STUDENTS:");
		Student allSs [] = {student1, student2, student3, student4};
		for(int i=0; i<allSs.length; i++){
			System.out.println(allSs[i].toString());
		}
		System.out.println("************************************************");
		System.out.println("**************************************************************\n");
		
		
		
        
	}
	
	static class Menu{
		public static void main(String[] args) {
			Scanner scnr = new Scanner(System.in);
			Course[] courses = new Course[3];
			Faculty[] facultys = new Faculty[3];
			GeneralStaff [] genStaffs = new GeneralStaff [3];
			Student[] students = new Student[3];
			
			TextFileHandler handler = new TextFileHandler();
			String fileName = "src/SchoolDB_Initial.txt";
			
			handler.readFileWriteToConsole(fileName);//13
			
			handler.appendToFile("src/SchoolDB_Updated.txt", handler.readFile(fileName));//14
	
			
			for(int i = 0; i < 3; i++) {//12a
				System.out.println("Lets create a course object " + (i+1) + ":");
				
				System.out.println("Is it a graduate course. e.g: true/false");
				boolean isGraduateCourse = scnr.nextBoolean();
				
				System.out.println("Enter its course number. e.g: 111");
				int courseNum = scnr.nextInt();
				
				System.out.println("Enter course department. e.g: MAT");
				String courseDept = scnr.next();
				
				System.out.println("Enter number of credits the course is worth. e.g: 4");
				int numCredits = scnr.nextInt();
				
				Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
				courses[i] = course;
				System.out.println("Course" + (i+1) + " has been created. " + course.toString());
			}
			
			for(int i = 0; i < 3; i++) {//12b
				System.out.println("Lets create a faculty object " + (i+1) + ":");
				
				System.out.println("Enter Faculty's name. e.g: Joe");
				String name = scnr.next();
				
				System.out.println("Enter Faculty's birth year. e.g: 2002");
				int birthYear = scnr.nextInt();
				
				System.out.println("Enter the department name that Faculty works in. e.g: MAT");
				String deptName = scnr.next();
				
				System.out.println("Enter if the Faculty is tenured. e.g: true/false");
				boolean isTenured = scnr.nextBoolean();
				
				Faculty faculty = new Faculty(name, birthYear, deptName, isTenured);
				facultys[i] = faculty;
				System.out.println("Faculty" + (i+1) + " has been created. " + faculty.toString());
			}
			
			for(int i = 0; i < 3; i++) {//12c
				System.out.println("Lets create a general staff object " + (i+1)+ ":");
				
				System.out.println("Enter general staffs name. e.g: Joe");
				String name = scnr.next();
				
				System.out.println("Enter general staffs birth year. e.g: 2002");
				int birthYear = scnr.nextInt();
				
				System.out.println("Enter the department name that general staff works in. e.g: Sanitation");
				String deptName = scnr.next();
				
				System.out.println("Enter the genral staffs duty. e.g: clean");
				String duty = scnr.next();
				
				GeneralStaff genStaff = new GeneralStaff(name, birthYear, deptName, duty);
				genStaffs[i] = genStaff;
				System.out.println("GeneralStaff" + (i+1) + " has been created. " + genStaff.toString());
			}
			
			for(int i = 0; i < 3; i++) {//12d
				System.out.println("Lets create a student object " + (i+1) + ":");
				
				System.out.println("Enter Students name. e.g: Joe");
				String name = scnr.next();
				
				System.out.println("Enter students birth year. e.g: 2002");
				int birthYear = scnr.nextInt();
				
				System.out.println("Enter the students major. e.g: CIS");
				String major = scnr.next();
				
				System.out.println("Enter if the student is a graduate student. e.g: true/false");
				boolean isGraduate = scnr.nextBoolean();
				
				Student student = new Student(name, birthYear, major, isGraduate);
				students[i] = student;
				System.out.println("Student" + (i+1) + " has been created. " + student.toString());
			}
			
			facultys[1].addCourseTaught(courses[1]);//12e
			facultys[2].addCourseTaught(courses[2]);
			
			students[1].addCourseTaken(courses[1]);//12f
			students[2].addCourseTaken(courses[2]);
			
			facultys[1].getCourseTaught(0);//12i
			facultys[1].getCourseTaught(-1);
			
			students[1].getCourseTaken(0);//12j
			students[1].getCourseTaken(-1);
			
			Course[] coursesToAddToFaculty = new Course[2];//12g
			for (int i = 0; i < 2; i++) {
			    coursesToAddToFaculty[i] = courses[i];
			} facultys[1].addCoursesTaught(coursesToAddToFaculty);//this was super tricky 
			
			Course[] coursesToAddToStudent = new Course[2];//12h
			for (int i = 0; i < 2; i++) {
			    coursesToAddToStudent[i] = courses[i];
			} facultys[1].addCoursesTaught(coursesToAddToStudent);
			
			handler.appendToFile("src/SchoolDB_Updated.txt","\nCOURSES:\n");
			for(int i=0; i<courses.length; i++){
				System.out.println(courses[i].toString());
				handler.appendToFile("src/SchoolDB_Updated.txt", courses[i].toString());//14
			}
			
			handler.appendToFile("src/SchoolDB_Updated.txt","\nFACULTY:\n");
			for(int i=0; i<facultys.length; i++){
				System.out.println(facultys[i].toString());
				handler.appendToFile("src/SchoolDB_Updated.txt", facultys[i].toString());//14
			}
			
			handler.appendToFile("src/SchoolDB_Updated.txt","\nGENERAL STAFF:\n");
			for(int i=0; i<genStaffs.length; i++){
				System.out.println(genStaffs[i].toString());
				handler.appendToFile("src/SchoolDB_Updated.txt", genStaffs[i].toString());//14
			}
			
			handler.appendToFile("src/SchoolDB_Updated.txt","\nSTUDENTS:\n");
			for(int i=0; i<students.length; i++){
				System.out.println(students[i].toString());
				handler.appendToFile("src/SchoolDB_Updated.txt", students[i].toString());//14
			}
			
			
			
		}
	}
	
	static class TextFileHandler {//Professor Sofianos created this TextFileHandler class in class with us.
		
		
		
		public void createNewFile(String fileName){
			PrintWriter outStream = null;
			
			try{
				outStream = new PrintWriter(fileName);//create and connect to empty file
				
			}catch(FileNotFoundException e){
				System.err.println("Could not create the empty file "+fileName+
						" the message was "+e.getMessage());
			}
			finally{
				if(outStream != null){
					outStream.close();//close the stream and release resources
				}
				System.out.println("Done trying to create new file");
			}
			
			
		}
		

		
		public void writeToNewFile(String fileName, String text){
			PrintWriter outStream = null;
			
			try{
				outStream = new PrintWriter(fileName);//create and connect to empty file
				outStream.println(text);//write the text to the new file
			}catch(FileNotFoundException e){
				System.err.println("Could not create the empty file "+fileName+
						" the message was "+e.getMessage());
			}
			finally{
				if(outStream != null){
					outStream.close();//close the stream and release resources
				}
				System.out.println("Done trying to write to new file");
			}
			
			
		}
		

		public void appendToFile(String fileName, String text){
			PrintWriter outStream = null;
			
			try{
				outStream = new PrintWriter(new FileOutputStream(fileName, true));//connect to existing file, append to end
				outStream.println(text);//write the text to the end of the file
			}catch(FileNotFoundException e){
				System.err.println("Could not create the empty file "+fileName+
						" the message was "+e.getMessage());
			}
			finally{
				if(outStream != null){
					outStream.close();//close the stream and release resources
				}
			}
			
			
		}
		

		public String readFile(String fileName){
			Scanner inStream = null;
			String fileContents = "";
			File theFile = null;
			
			try {
				
				theFile = new File(fileName);//create a File object
				inStream = new Scanner(theFile);//connect to the file we want to read from
				
				while(inStream.hasNextLine()){ //does the file have another line?
					fileContents +=  inStream.nextLine() +"\n"; //retrieve the line and append to our String
				}
				
				
					
			} catch (FileNotFoundException e) {
				System.err.println("Could not read from file "+fileName+"\n"+e.getMessage());
			}
			finally{
				if(inStream != null){
					inStream.close();
				}
				
				
			}
			return fileContents;
		}
		
		

		public void readFileWriteToConsole(String fileName){
			Scanner inStream = null;
			File theFile = null;
			try {
				theFile = new File(fileName);//create a File object
				inStream = new Scanner(theFile);//connect to the file we want to read from
//				String theLine = "";	
				while(inStream.hasNextLine()){ //does the file have another line?
					System.out.println(  inStream.nextLine() ); //retrieve the line and print it out
				}
				
			} catch (FileNotFoundException e) {
				System.err.println("Could not read from file "+fileName+"\n"+e.getMessage());
			}
			finally{
				if(inStream != null){
					inStream.close();
				}
				
			}
		
		}

		public void copyFile(String fileNameOriginal, String fileNameCopy){
			
			Scanner inStream = null;
			PrintWriter outStream = null;
			try{
				inStream = new Scanner(new File(fileNameOriginal));
				outStream = new PrintWriter(new FileOutputStream(fileNameCopy, true));
				int lineNumber = 1;
				while(inStream.hasNextLine()){
					String theLine = inStream.nextLine();
					outStream.println((lineNumber++) + " " + theLine);
				}
				
				
				
			}catch(FileNotFoundException e){
				System.err.println("Could not copy from file "+fileNameOriginal+" to "+fileNameCopy+"\n"+e.getMessage());
				
			}
			
			
			finally{
				if(inStream != null){
					inStream.close();//close the stream and release resources
				}
				if(outStream != null){
					outStream.close();//close the stream and release resources
				}
				System.out.println("Done trying to copy from file "+fileNameOriginal+" to "+fileNameCopy);
				
			}
			
			
			
			
			
		
		}
	}

}
