package com.itsayushmathur.cruddemo;

import com.itsayushmathur.cruddemo.dao.StudentDAO;
import com.itsayushmathur.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	Scanner scanner= new Scanner(System.in);
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			findStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Enter 1 to delete All. This action cannot be reversed. Press 0 to exit without deleting.");
		int x = scanner.nextInt();

		if(x == 1){
			System.out.println("Deleting all ...");
			System.out.println( studentDAO.deleteAll() +" entries deleted.");
		}
		else
			System.out.println("Aborted.");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.print("Enter id: ");
		int studentID = scanner.nextInt();
		studentDAO.delete(studentID);
		System.out.println("Entry Deleted");

	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id:primary key
		System.out.print("Enter id: ");
		int studentID = scanner.nextInt();
		scanner.nextLine();
		Student myStudent = studentDAO.findByID(studentID);

		//change name to what you want
		System.out.println("Enter the changes. leave blank if no change!");
		System.out.println("What is the new first name? ");
		String newfirstName= scanner.nextLine();
		System.out.println("What is the new last name? ");
		String newlastName= scanner.nextLine();
		System.out.println("What is the new email? ");
		String newemail= scanner.nextLine();

		if(!Objects.equals(newfirstName, "")) {
			myStudent.setFirstName(newfirstName);
		}
		if(!Objects.equals(newlastName, "")) {
			myStudent.setLastName(newlastName);
		}
		if(!Objects.equals(newemail, "")) {
			myStudent.setEmail(newemail);
		}

		//update the student
		studentDAO.update(myStudent);

		//display the updated student.
		System.out.println("Update operation complete: "+ myStudent);

	}

	private void findStudentByLastName(StudentDAO studentDAO) {


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
		Student tempStudent = new Student("Ayush","Mathur","mathurayush121@gmail.com");
		Student tempStudent1 = new Student("Kengan","Ashura","fightclub1@gmail.com");
		Student tempStudent2 = new Student("Baki","Hanma","killdad@mission.com");
		Student tempStudent3 = new Student("Naruto","Uzumaki","hokage@leaf.com");


		// save the student object
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent);
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









