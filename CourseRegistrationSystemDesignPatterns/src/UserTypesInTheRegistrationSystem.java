/*Project Description:
* This project simulates a university course registration system where different types of users such as students, 
	 * instructors, and IT workers manage courses. The system supports key functionalities like enrolling students in courses,
	 *  creating courses, and cloning courses into new sections.       
     *-------------------------------------------------------------------
     *Design Patterns Used:
     *1.Factory Design Pattern: The UniversityUserFactory class is used to create different types of users in the system, 
     *such as Student, Instructor, and ITWorker. This pattern helps centralize user creation and decouple the instantiation 
     *logic from the rest of the system.
     *--------------------------------------------------------
     *2.Singleton Design Pattern: The CourseManager class uses the Singleton pattern to ensure that there is only one 
     *instance managing all the courses in the system. This helps centralize course management and prevent inconsistencies.
     *--------------------------------------------------------- 
     *3.Prototype Design Pattern: The Course class implements the Cloneable interface, enabling the cloning of existing courses 
     *into new sections. This pattern is used to duplicate courses easily without creating them from scratch.
	 * 
	 * 
 */


import java.util.*;

class UniversityUserFactory{
	/* Title: UniversityUserFactory class
	 * Author: Arda Baran
	 * Description:
	 * This class uses the Factory Design Pattern to create different types of users (Student, Instructor, IT Worker) in the system.
	 * It also maintains lists of all students and instructors, and manages IT worker instances.
	 * This class serves as a factory for creating different types of users and managing them.
	 * It also contains utility methods to retrieve users by name and add them to the system.
	 * 
	 */
	
	
	public static List<Student> allStudents = new ArrayList<>();//stores all students created by factory pattern.
public static List<Instructor>allLecturers= new ArrayList<>();	//stores all instructors created by factory pattern
public static ITWorker itWorker=null;//stores it worker created by factory pattern	
	public static UserTypesInTheRegistrationSystem createTeduPerson(String nameSurname,String mail,String positionInUniversity) {
		switch(positionInUniversity) {
		case "Student":
			return new Student(nameSurname,mail,positionInUniversity);
		case "Instructor":
			return new Instructor(nameSurname,mail,positionInUniversity);
		case "IT Worker":
			return new ITWorker(nameSurname,mail,positionInUniversity);
			default:
				return null;
		}
	}
	
	public static void addInstructorToUniversity(UserTypesInTheRegistrationSystem user) {
	/*
	 * Summary:adds instructor which is created by factory pattern to the arraylist
	 * 
	 */
		if(user instanceof Instructor) {
		Instructor instructor = (Instructor) user;
		allLecturers.add(instructor);
	}
		
	}
	public static void setITWorker(UserTypesInTheRegistrationSystem user) {
		/*
		 * Summary:sets the it department worker which is created by factory pattern 
		 * 
		 */	
		
		
		if(user instanceof ITWorker) {
			ITWorker it = (ITWorker) user;
			itWorker=it;
		}
	}
public static void addStudentToUniversity(UserTypesInTheRegistrationSystem user,double gpa,int creditEarned) {
	/*
	 * Summary:adds student which is created by factory pattern to the arraylist
	 * 
	 */
	if(user instanceof Student) {
	
		Student student = (Student) user;	
		
	student.setGpa(gpa);
	student.setCreditEarned(creditEarned);
	student.adjustProbationStatus();
	allStudents.add(student);
	}
}
public static Student getStudentByName(String name) {
	/*
	 * Summary:Retrieves student by name
	 * 
	 */	
	
	for(Student student :allStudents) {
		if(student.getNameSurname().equalsIgnoreCase(name)) {
			return student;
		}
	}
return null;
}
public static Instructor getInstructorByName(String name) {
	/*
	 * Summary:Retrieves instructor by name
	 * 
	 */	
	
	
	for(Instructor instructor : allLecturers) {
		if(instructor.getNameSurname().equalsIgnoreCase(name)) {
			return instructor;
		}
	}
return null;
}
public static ITWorker getITWorker() {
	/*
	 * Summary:Retrieves the it worker
	 * 
	 */	
	
	return itWorker;
}
}

public abstract class UserTypesInTheRegistrationSystem {
	/*Title:UserTypesInTheRegistrationSystem class
	 * Author:Arda Baran
	 * Description:
	 * This abstract class defines the common properties and behaviors of all types of users in the system.
	 *  Defines the base structure for all users, including shared attributes such as nameSurname, mail, and positionInUniversity.
	 * Each user subclass must implement showUserDetails() to display its details.
	 * 
	 * 	
	 */
	
	
	
	
	String nameSurname,mail,positionInUniversity;


public UserTypesInTheRegistrationSystem(String nameSurname,String mail,String positionInUniversity) {
	this.nameSurname=nameSurname;
	this.mail=mail;
	this.positionInUniversity=positionInUniversity;
	
}
public String getNameSurname() {
	return nameSurname;
}
public void setNameSurname(String nameSurname) {
	this.nameSurname = nameSurname;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPositionInUniversity() {
	return positionInUniversity;
}
public void setPositionInUniversity(String positionInUniversity) {
	this.positionInUniversity = positionInUniversity;
}

public abstract void showUserDetails();

}
class Student extends UserTypesInTheRegistrationSystem{
	/*Title:Student class
	 * Author:Arda Baran
	 * Description:
	 * This class represents a student in the course registration system. A student has nameSurname,a list of enrolled courses,mail
	 * ,gpa , total credits he earned in his academic life and probation status.In TEDU, if a student has probation status.he cannot
	 * enroll a new course.
	 * The duty of a student in this system is enrolling a course.
	 * 	
	 */
	
	
	
	ArrayList<Course> coursesEnrolled;
double gpa;
int creditEarned;
boolean probationStatus;


public Student(String nameSurname,String mail,String positionInUniversity) {
    super(nameSurname, mail,positionInUniversity);
     this.coursesEnrolled=new ArrayList<>();
     this.creditEarned=0;          
     this.gpa = 0.0;
     this.probationStatus=false;    
}

public double findProbationLimit() {
int totalCredit = getCreditEarned();
if(totalCredit >= 0 && totalCredit <= 50) {
	return 1.60;
}else if(totalCredit > 50 && totalCredit <= 100) {
	return 1.70;
}else {
	return 1.80;
}	
}
public void adjustProbationStatus() {
/*
 * Summary:Updates the student's probation status based on their GPA and earned credits.
 * 
 */
 double currentGpa=getGpa();
 double probationLimit = findProbationLimit();
 
 if(currentGpa < probationLimit) {
	 setProbationStatus(true);
 }else {
	 setProbationStatus(false);
 }
	
}
public boolean containsSameCourseName(Course course) {
for(Course c : getCoursesEnrolled()) {
	if(c.getCname().equalsIgnoreCase(course.getCname()) ) {
		return true;
		
	}
}
return false;
}
public boolean canStudentEnrollsThisCourse(Course course) {
	if(isProbationStatus() || coursesEnrolled.contains(course) ||containsSameCourseName(course)) {
		return false;
		
	}
	return true;
}

public void enrollCourse(Course course) {
/*
 * Summary:Enrolls the student in a course if the probation status allows it and they are not already registered.
 * 
 * 
 */
	
	if(course == null) {
	return;
	
}
if(!canStudentEnrollsThisCourse(course)) {
	System.out.println("Student "+getNameSurname()+ " cannot enroll to "+course.getCname()     +" course due to probation status or  already registered to this course");
return;
}

coursesEnrolled.add(course);

course.getStudentsRegisteredToThisCourse().add(this);
System.out.println("Student "+getNameSurname()+" Successfully Enrolled To "+course.getCname()+" Section: "+course.getSection() +" Course...");
}
@Override
public void showUserDetails() {
	System.out.println(getPositionInUniversity()+" Name/Surname: "  +getNameSurname());
	System.out.println(getPositionInUniversity()+" E-Mail: "+getMail());
	System.out.println(getPositionInUniversity()+" GPA: "+getGpa());
	System.out.println(getPositionInUniversity()+" Total Credits Earned: "+getCreditEarned());
	System.out.println("Probation Status: "+isProbationStatus());
    System.out.println("-----------------------------------------------");
    System.out.println("Enrolled Courses: ");
    for(Course c : getCoursesEnrolled()) {
    	if(c==null) {
    		System.out.println("Student is not enrolled to any course");
    	}else {
    		System.out.println("Course Name: "+c.getCname()+"||| Section: "+c.getSection()+"||| Course Instructor: "+c.getLecturer().getNameSurname() +"||| TEDU Credit: "+c.getTeduCredit());
    	}
    }
}

public ArrayList<Course> getCoursesEnrolled() {
	return coursesEnrolled;
}
public void setCoursesEnrolled(ArrayList<Course> coursesEnrolled) {
	this.coursesEnrolled = coursesEnrolled;
}
public double getGpa() {
	return gpa;
}
public void setGpa(double gpa) {
	this.gpa = gpa;
}
public int getCreditEarned() {
	return creditEarned;
}
public void setCreditEarned(int creditEarned) {
	this.creditEarned = creditEarned;
}
public boolean isProbationStatus() {
	return probationStatus;
}
public void setProbationStatus(boolean probationStatus) {
	this.probationStatus = probationStatus;
}


}
class Instructor extends UserTypesInTheRegistrationSystem{
	/*Title:Instructor class
	 * Author:Arda Baran
	 * Description:
	 * This class represents an instructor. It maintains a list of courses taught by the instructor and can display details about 
	 * them.The duty of instructor in this registration system is to teaching courses.
	 * Also,the courses that instructor teaches are stored in the givenLectures list.
	 * 
	 * 
	 * 	
	 */ 

	List<Course> givenLectures;
 public Instructor(String nameSurname,String mail,String positionInUniversity) {
	 super(nameSurname, mail,positionInUniversity);
	 this.givenLectures=new ArrayList<>();
 }
 @Override
 public void showUserDetails() {
 	System.out.println(getPositionInUniversity()+" Name/Surname: "  +getNameSurname());
 	System.out.println(getPositionInUniversity()+" E-Mail: "+getMail());
 	System.out.println();
 	System.out.println("Lectures Given: ");
 	for(Course c : getGivenLectures()) {
 		if(c == null) {
 			System.out.println("Instructor does not give lecture in this semester...");
 		}else {
 			System.out.println("Course Name: "+c.getCname()+" Section: "+c.getSection()+" TEDU Credit: "+c.getTeduCredit());
 		}
 	}
 }
public List<Course> getGivenLectures() {
	return givenLectures;
}
public void setGivenLectures(List<Course> givenLectures) {
	this.givenLectures = givenLectures;
}
 
 
 
}
class ITWorker extends UserTypesInTheRegistrationSystem{
	/*Title:ITWorker class
	 * Author:Arda Baran
	 * Description:
	 * This class represents an IT worker responsible for managing courses in the system. IT workers can create and clone courses.
	 * IT Worker is responsible to creating a new unique courses.Also,IT worker can open new sections of already created courses.
	 * Creating new courses and cloning existing courses functionalities are based on Singleton and Prototype design patterns.
	 * 
	 * 	
	 */
	public ITWorker(String nameSurname,String mail,String positionInUniversity) {
		super(nameSurname,mail,positionInUniversity);
	}
	   public Course createCourse(String courseName, Instructor lecturer, int teduCredit) {
	     /*
	      * Summary:Creates a new course with a given name, instructor, and credit value.Uses Singleton Design Pattern.
	      *   
	      */
		   
		   
		   Course newCourse = new Course(courseName, lecturer, teduCredit);
	        newCourse.setSection(1);
	        CourseManager.getInstance().addCourse(newCourse);
	        System.out.println("New course created: " + courseName);
	       lecturer.getGivenLectures().add(newCourse);//appends the newCourse object (a course that was just created) to the list of courses that given insturctor teaches
	        return newCourse;
	    }
	   public Course cloneCourseToNewSection(Course originalCourse,Instructor newLecturer, int newSection) {
		   /*
		      * Summary:Clones an existing course with a given existing course, given new instructor and new section ID.
		      * Uses Prototype Design Pattern.
		      *   
		      */   

		   try {
	            Course clonedCourse = (Course) originalCourse.clone();
	            clonedCourse.setSection(newSection);
	            clonedCourse.setLecturer(newLecturer);
	            CourseManager.getInstance().addCourse(clonedCourse);
	            System.out.println("Course " + originalCourse.getCname() + " cloned to section " + newSection);
	            newLecturer.getGivenLectures().add(clonedCourse);//appends the clonedCourse object (a course that was just cloned) to the list of courses that given insturctor teaches
	            return clonedCourse;
	        } catch (CloneNotSupportedException e) {
	            System.out.println("Course cloning failed: " + e.getMessage());
	            return null;
	        }
	    }
	   
	   
	   
	  @Override
	    public void showUserDetails() {
	        System.out.println(getPositionInUniversity() + " Name/Surname: " + getNameSurname());
	        System.out.println(getPositionInUniversity() + " E-Mail: " + getMail());
	    }	
}

