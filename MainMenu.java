package com.elevateLabs.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.elevateLabs.dao.StudentDao;
import com.elevateLabs.entity.Student;

public class MainMenu {

	public static int menu(Scanner sc) {
		System.out.println("***************************");
		System.out.println("1.Insert student details");
		System.out.println("2.Update student details");
		System.out.println("3.Remove student details");
		System.out.println("4.View student details");
		System.out.println("5.Exit....");
		System.out.println("***************************");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	 
	public static void insertStudent(Scanner sc) {
		Student student = new Student();
		student.accept(sc);
		try(StudentDao studentDao = new StudentDao()) {
			studentDao.insertStudent(student);
			System.out.println("Insertion successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void displayStudent() {
		try(StudentDao StudentDao = new StudentDao()) {
			List<Student> studentlist = StudentDao.getAllStudent();
			studentlist.forEach(p -> System.out.println(p));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateStudent(Scanner sc) {
		try(StudentDao studentDao = new StudentDao()){
			System.out.println("Enter the student id of the student:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the new branch of the student");
			String branch = sc.nextLine();
			System.out.println("Student details updates successfully");
			studentDao.updateStudent(branch,id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteStudent(Scanner sc) {
		try(StudentDao studentDao = new StudentDao()){
			System.out.println("Enter the menu id to delete the student");
			int id=sc.nextInt();
			System.out.println("Student detail successfully deleted");
			studentDao.deleteStudent(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		while( (choice = menu(sc))!= 5){
		switch(choice){
		case 1:
			insertStudent(sc);
			break;
			
		case 2:
			updateStudent(sc);
			break;
			
		case 3:
			deleteStudent(sc);
			break;
			
		case 4:
			displayStudent();
			break;
			
		default:
			System.out.println("Invalid choice!");
		}
		}
	}

}
