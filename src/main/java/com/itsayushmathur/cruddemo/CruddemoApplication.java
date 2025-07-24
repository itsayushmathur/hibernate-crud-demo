package com.itsayushmathur.cruddemo;

import com.itsayushmathur.cruddemo.dao.StudentDAO;
import com.itsayushmathur.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
			findStudentByLastName(studentDAO);

		};
	}

	private void findStudentByLastName(StudentDAO studentDAO) {

		Scanner scanner= new Scanner(System.in);
		System.out.print("Please enter the last name : ");
		String queryName = scanner.nextLine();

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName(queryName);

		//display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents= studentDAO.findAll();

		//display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new stduent");
		Student tempStudent1 = new Student("Tanjiro","Kamado","hinokamikagura01@DSC.com");

		// save the studentDAO
	studentDAO.save(tempStudent1);
		// display id of the saved student
		int theID = tempStudent1.getId();
		System.out.println("Saved Student. ID Generate: "+ theID);
		//retrieve the student based on the id: primary key
		System.out.println("Retrieving the Student with id: "+theID);
		Student myStudent = studentDAO.findByID(theID);
		//display the student
		System.out.println("Found the student: "+ myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating multiple student objects...");
//		Student tempStudent = new Student("Ayush","Mathur","mathurayush121@gmail.com");
		Student tempStudent1 = new Student("Kengan","Ashura","fightclub1@gmail.com");
		Student tempStudent2 = new Student("Baki","Hanma","killdad@mission.com");
		Student tempStudent3 = new Student("Naruto","Uzumaki","hokage@leaf.com");

		// save the student object
		System.out.println("Saving the students ...");
//		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ayush","Mathur","mathurayush121@gmail.com");

		// save the student object
		System.out.println("Saving student ...");
		studentDAO.save(tempStudent);

		// display id of the saved students

		System.out.println("Saved.Generated id : "+ tempStudent.getId());

	}
}









