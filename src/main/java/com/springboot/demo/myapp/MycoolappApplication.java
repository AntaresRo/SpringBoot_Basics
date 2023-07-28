package com.springboot.demo.myapp;

import com.springboot.demo.myapp.dao.StudentDAO;
import com.springboot.demo.myapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);

			//querryForStudents(studentDAO);
			//queryForStudentByLastname(studentDAO);

			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);

		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 3;
		System.out.println("Deleting student id: " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentID = 1;
		System.out.println("Getting student with id: " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastname(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void querryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempstudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		System.out.println("Saving student");
		studentDAO.save(tempstudent);

		int theId = tempstudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found student " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
