package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.* ;
public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	ArrayList<Student> students;
	ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
	
		if(numOfStudents != 3){
			System.out.println("please input correct number, because it's our rule");
			return ;
		}
	
		numOfCourses = Integer.parseInt(args[1]);
	
		if(numOfCourses != 6){
			System.out.println("please input correct number, because it's our rule");
			return ;
		}
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			if(student != null)
			System.out.println(student.getStudentName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			if(course != null)
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		
		students = new ArrayList<Student>() ;
		
		int numOfData = lines.length ;
		String[] afterSplit = new String[numOfData] ;

		
		for(int j= 0 ; j< numOfData ; j++){
		
			Student student = new Student();
			afterSplit = lines[j].split(",") ;  
			student.setStudentName(afterSplit[1].trim()) ;
			
			if(!studentExist(students, student)){
				
				students.add(student);
		
			}
		
		}
	
		return students;

	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		
		String existName = "";
		

		for(Student member : students){
			
			if (member!= null){	
				existName = member.getStudentName() ;
				if(existName.equals(student.getStudentName())){
					return true ;
				}	
			}
		}

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		
		ArrayList<Course> courses = new ArrayList<Course>() ;

		int numOfData = lines.length ;
		String[] afterSplit = new String[numOfData] ;

		
		for(int j= 0 ; j< numOfData ; j++){
		
			Course course = new Course();
			afterSplit = lines[j].split(",") ;  
			course.setCourseName(afterSplit[2].trim()) ;
			
			if(!courseExist(courses, course)){
				
				courses.add(course);
		
			}
		
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		String existName = "";
		

		for(Course member : courses){
			
			if (member!= null){	
				existName = member.getCourseName() ;
				if(existName.equals(course.getCourseName())){
					return true ;
				}	
			}
		}

		return false;
	}


}

