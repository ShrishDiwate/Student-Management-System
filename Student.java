package com.elevateLabs.entity;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	private String branch;
	private int totalMarks;
	
	public Student() {
		
	}
	public Student(int id,String name, String branch, int totalMarks) {
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.totalMarks = totalMarks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", branch=" + branch + ", totalMarks=" + totalMarks + "]";
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter the name of student: ");
		name = sc.next();
		sc.nextLine();
		System.out.print("Enter the branch name: ");
		branch = sc.next();
		sc.nextLine();
		System.out.println("Enter the total marks of the student: ");
		totalMarks = sc.nextInt();
	}
	
}

