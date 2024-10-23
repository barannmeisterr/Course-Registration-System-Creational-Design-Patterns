import java.util.*;

class CourseManager {
	/*Title:CourseManager class
	 * Author:Arda Baran
	 * Description:
	 *This class uses the Singleton Design Pattern to manage all courses in the system.It includes methods for adding, 
	 *retrieving, and displaying courses.The purpose is to centralizing Centralized course management through a single instance,
	 * ensuring there is only one CourseManager that handles course-related operations such as adding courses, cloning courses,
	 * and retrieving them by name or section.
	 * 	
	 */  
	
	
	
	private static CourseManager instance;
    private List<Course> courses = new ArrayList<>();

    private CourseManager() { 
    	
    }

    public static CourseManager getInstance() {
   /*
    *Summary: 
    *   This method is part of the Singleton Design Pattern, ensuring that there is only one instance of the CourseManager class throughout the entire application.
    *   This method checks if an instance of CourseManager already exists. If it does not, a new instance is created and returned.
    *    If an instance already exists, it simply returns the existing instance.
    *   Ensures only one instance of CourseManager is created (singleton).
    *   Provides a global point of access to the single CourseManager instance.
    */
    	
    	
    	if (instance == null) {
            instance = new CourseManager();
        }
        return instance;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    public Course getCourseByNameAndSection(String courseName,int section) {
    /*
     * Summary:Retrieves the course by its name and section ID so that student can enroll that course. 	
     */
    	
    	for(Course course : courses) {
    	    	if(course.getCname().equalsIgnoreCase(courseName) && course.getSection()==section) {
    	    		return course;
    	    	}
    	    }
    	    	return null;
    }
    public Course getCourseObject(Course course) {
    	for(Course c : courses) {
    		if(c==course) {
    			return c ;
    			
    		}
    	}
    return null;
    }
    public Course getCourseByName(String courseName) {
    	   /*
         * Summary:Retrieves the course by its name so that a course can be cloned. 	
         */ 
    	
    	for(Course course : courses) {
    	if(course.getCname().equalsIgnoreCase(courseName)) {
    		return course;
    	}
    }
    	return null;
    }
    public void showAllCourses() {
        for (Course course : courses) {
            course.showCourseDetails();
        }
    }
}
public class Course implements Cloneable {
	/*Title:Course class
	 * Author:Arda Baran
	 * Description:
	 * This class represents a course in the university system.A course can be defined with name of the course, tedu credit,lecturer
	 * and section ID.It implements the Prototype Design Pattern,allowing courses to be cloned for creating new sections.
	 * 
	 * 
	 * 	
	 */

	List<Student> studentsRegisteredToThisCourse;//keeps the list of the registered student to this course
String cname;
Instructor lecturer;
int teduCredit,section;
public Course(String cname,Instructor lecturer,int teduCredit) {
	this.cname=cname;
	this.lecturer=lecturer;
	this.teduCredit=teduCredit;
	this.studentsRegisteredToThisCourse=new ArrayList<>();
	this.section=1;
}

public int getSection() {
	return section;
}

public void setSection(int section) {
	this.section = section;
}
/*@Override
protected Object clone() throws CloneNotSupportedException {
/*
 *Summary:Implements the Prototype pattern to allow courses to be cloned into new sections. 
 *   
 *   
 */
	
	//return super.clone();
//}*/
@Override
protected Object clone() throws CloneNotSupportedException {
	/*
	 *Summary:Implements the Prototype pattern to allow courses to be cloned into new sections. 
	 *   dont clones the registered student list.just initializes with an empty student list 
	 *   
	 */
	Course clonedCourse = (Course) super.clone();

    // Performs deep copy of the cleared studentsRegisteredToThisCourse list
    clonedCourse.studentsRegisteredToThisCourse = new ArrayList<>();    
    
    return clonedCourse;
}

public void showCourseDetails() {
	System.out.println("Course Name : " +getCname() +" Course Section: "+getSection());
	System.out.println("Course Instructor : " +getLecturer().getNameSurname() );
	System.out.println("Instructor Mail: "+getLecturer().getMail());
   System.out.println("Course TEDU Credit Hour: "+getTeduCredit());
   System.out.println("Registered Students To "+getCname()+" Course(SECTION "+getSection()  +"):");
   for(Student s : getStudentsRegisteredToThisCourse()) {
	   if(s == null) {
		   System.out.println("There is no student registered to this course...");
	   }else {
		   System.out.println("Name Surname: "+s.getNameSurname()+" Mail: "+s.getMail());
	   }
   }
   System.out.println("---------------------------------------------------");
}

public List<Student> getStudentsRegisteredToThisCourse() {
	return studentsRegisteredToThisCourse;
}
public void addStudent(Student student) {
	if(student==null) {
		return;
	}
getStudentsRegisteredToThisCourse().add(student);

}
public void setStudentsRegisteredToThisCourse(List<Student> studentsRegisteredToThisCourse) {
	this.studentsRegisteredToThisCourse = studentsRegisteredToThisCourse;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Instructor getLecturer() {
	return lecturer;
}
public void setLecturer(Instructor lecturer) {
	this.lecturer = lecturer;
}
public int getTeduCredit() {
	return teduCredit;
}
public void setTeduCredit(int teduCredit) {
	this.teduCredit = teduCredit;
}



}
