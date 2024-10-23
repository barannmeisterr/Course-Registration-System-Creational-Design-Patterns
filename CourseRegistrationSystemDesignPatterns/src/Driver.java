import java.util.*;
public class Driver {
	/*Title:Driver class
	 * Author:Arda Baran
	 * Description:
	 * This class is Main class.Firstly,students ,instructors and the it worker are created by using the Factory design pattern. 
	 *Then, the it worker creates new courses that offered in the university and clones this courses to new sections with
	 * instructors and new section IDs.
	 * Then student enrolls to courses if his/her gpa is not below the probation limit based on his/her earned credits.
	 * 	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// creates IT Worker by using factory pattern
	UserTypesInTheRegistrationSystem itw = UniversityUserFactory.createTeduPerson("Elliot Anderson", "elliot.anderson@tedu.edu.tr", "IT Worker");
	UniversityUserFactory.setITWorker(itw);
	ITWorker it = UniversityUserFactory.getITWorker();

	//creates Students by using factory pattern
	UserTypesInTheRegistrationSystem s1 = UniversityUserFactory.createTeduPerson("ARDA BARAN", "arda.baran@tedu.edu.tr", "Student");
		UniversityUserFactory.addStudentToUniversity(s1, 1.83, 98);
					
		UserTypesInTheRegistrationSystem s2 = UniversityUserFactory.createTeduPerson("John Doe", "john.doe@tedu.edu.tr", "Student");
		UniversityUserFactory.addStudentToUniversity(s2, 2.03, 74);
		UserTypesInTheRegistrationSystem s3 = UniversityUserFactory.createTeduPerson("Maria Smith", "maria.smith@tedu.edu.tr", "Student");
		UniversityUserFactory.addStudentToUniversity(s3, 1.63, 44);
		
		UserTypesInTheRegistrationSystem s4 = UniversityUserFactory.createTeduPerson("Ali Veli", "ali.veli@tedu.edu.tr", "Student");
		UniversityUserFactory.addStudentToUniversity(s4, 2.50, 110);
		UserTypesInTheRegistrationSystem s5 = UniversityUserFactory.createTeduPerson("Ahmet Ahmetoğlu", "ahmet.ahmetoglu@tedu.edu.tr", "Student");
		UniversityUserFactory.addStudentToUniversity(s5, 1.73, 120);	
		
		
//Creates instructors by using factory pattern		
		UserTypesInTheRegistrationSystem l1 = UniversityUserFactory.createTeduPerson("Tansel Dökeroğlu", "tansel.dokeroglu@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l1);
		UserTypesInTheRegistrationSystem l2 = UniversityUserFactory.createTeduPerson("David Patterson", "david.patterson@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l2);
		UserTypesInTheRegistrationSystem l3 = UniversityUserFactory.createTeduPerson("Alan Oppenheim", "alan.oppenheim@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l3);
		UserTypesInTheRegistrationSystem l4 = UniversityUserFactory.createTeduPerson("Elliot Williams", "elliot.williams@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l4);
		UserTypesInTheRegistrationSystem l5 = UniversityUserFactory.createTeduPerson("Robert Sedgewick", "robert.sedgewick@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l5);
		UserTypesInTheRegistrationSystem l6 = UniversityUserFactory.createTeduPerson("Alan Turing", "alan.turing@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l6);
		UserTypesInTheRegistrationSystem l7 = UniversityUserFactory.createTeduPerson("John Hennessy", "john.hennessy@tedu.edu.tr", "Instructor");
		UniversityUserFactory.addInstructorToUniversity(l7);
		
		
		System.out.println("========================Creating Courses=======================================");	
/*Creates new course by using Singleton Pattern     */	
		it.createCourse("CMPE 361",UniversityUserFactory.getInstructorByName("David Patterson") ,3)	;
/* Clones the already created course in order to open a new section by using Prototype Pattern */	
		it.cloneCourseToNewSection(CourseManager.getInstance().getCourseByName("CMPE 361"),UniversityUserFactory.getInstructorByName("John Hennessy") , 2);
	
	it.createCourse("CMPE 371",UniversityUserFactory.getInstructorByName("Alan Oppenheim") ,3);
	it.cloneCourseToNewSection(CourseManager.getInstance().getCourseByName("CMPE 371"),UniversityUserFactory.getInstructorByName("Alan Turing") , 2);
	
	it.createCourse("SENG 354",UniversityUserFactory.getInstructorByName("Tansel Dökeroğlu") ,3);
	it.cloneCourseToNewSection(CourseManager.getInstance().getCourseByName("SENG 354"),UniversityUserFactory.getInstructorByName("Tansel Dökeroğlu") , 2);
	
	it.createCourse("CMPE 453",UniversityUserFactory.getInstructorByName("Elliot Williams") ,3);
	it.cloneCourseToNewSection(CourseManager.getInstance().getCourseByName("CMPE 453"),UniversityUserFactory.getInstructorByName("David Patterson") , 2);
	
	it.createCourse("CMPE 223",UniversityUserFactory.getInstructorByName("Robert Sedgewick") ,3);
	it.createCourse("CMPE 224",UniversityUserFactory.getInstructorByName("Robert Sedgewick") ,3);
	it.createCourse("CMPE 327",UniversityUserFactory.getInstructorByName("Alan Turing") ,3);
		
	   System.out.println("================================================================================");
	   System.out.println();
	   System.out.println("========================Initial Course Profiles=======================================");
	   System.out.println();
	   CourseManager.getInstance().showAllCourses();//Displays all course profiles by using Singleton pattern 
	   System.out.println("================================================================================");
	   System.out.println();
	   System.out.println("========================Initial Instructor Profiles=======================================");
	   System.out.println();
	 for(Instructor lecturer : UniversityUserFactory.allLecturers) {
		 if(lecturer!=null) {
			 lecturer.showUserDetails();
			 System.out.println("-------------------------------------------------");
		 }
	 }
	 //Students enroll courses
	   System.out.println("=====================ARDA BARAN ENROLLS TO COURSES=======================================");
	   UniversityUserFactory.getStudentByName("ARDA BARAN").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 361", 2));
	   UniversityUserFactory.getStudentByName("ARDA BARAN").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 371", 1));
	   UniversityUserFactory.getStudentByName("ARDA BARAN").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 453", 1));
	   UniversityUserFactory.getStudentByName("ARDA BARAN").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("SENG 354", 1));
	   UniversityUserFactory.getStudentByName("ARDA BARAN").showUserDetails();
	   System.out.println("==========================================================================================");
	   System.out.println();
	   System.out.println("=====================John Doe ENROLLS TO COURSES=======================================");
	   UniversityUserFactory.getStudentByName("John Doe").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 361", 2));
	   UniversityUserFactory.getStudentByName("John Doe").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 371", 2));
	   UniversityUserFactory.getStudentByName("John Doe").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 327", 1));
	   UniversityUserFactory.getStudentByName("John Doe").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 223", 1));
	   UniversityUserFactory.getStudentByName("John Doe").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("SENG 354", 2));
	   UniversityUserFactory.getStudentByName("John Doe").showUserDetails();
	   System.out.println("==========================================================================================");
	   System.out.println();
	   System.out.println("=====================Maria Smith ENROLLS TO COURSES=======================================");
	   UniversityUserFactory.getStudentByName("Maria Smith").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 361", 2));
	   UniversityUserFactory.getStudentByName("Maria Smith").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 371", 2));
	   UniversityUserFactory.getStudentByName("Maria Smith").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 327", 1));
	   UniversityUserFactory.getStudentByName("Maria Smith").showUserDetails();
	   System.out.println("==========================================================================================");
	   System.out.println();
	   System.out.println("=====================Ali Veli ENROLLS TO COURSES=======================================");
	   //tests the already enrolled course condition is work
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 361", 1));
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 224", 1));
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 453", 2));
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("SENG 354", 1));
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("SENG 354", 2));
	   UniversityUserFactory.getStudentByName("Ali Veli").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 327", 1));
	   UniversityUserFactory.getStudentByName("Ali Veli").showUserDetails();
	   System.out.println("==========================================================================================");
	   System.out.println();
	   System.out.println("=====================Ahmet Ahmetoğlu ENROLLS TO COURSES=======================================");
	   //tests the probation status is work 
	   UniversityUserFactory.getStudentByName("Ahmet Ahmetoğlu").enrollCourse(CourseManager.getInstance().getCourseByNameAndSection("CMPE 361", 1));
	   UniversityUserFactory.getStudentByName("Ahmet Ahmetoğlu").showUserDetails();
	   System.out.println("==========================================================================================");
	   System.out.println();
	   System.out.println("========================Final Course Profiles=======================================");
	   System.out.println();
	   CourseManager.getInstance().showAllCourses();
	   System.out.println("================================================================================");
	  
	   System.out.println("========================Final Instructor Profiles=======================================");
	   System.out.println();
	   for(Instructor lec : UniversityUserFactory.allLecturers) {
		   if(lec!=null) {
			   lec.showUserDetails();
		   System.out.println("----------------------------------------------------------------------------");
		   }
	   }
	   System.out.println("================================================================================");
	   
	}

}
