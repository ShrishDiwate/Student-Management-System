package com.elevateLabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elevateLabs.Utils.DButils;
import com.elevateLabs.entity.Student;

public class StudentDao implements AutoCloseable{
	private Connection connection;
	
	public StudentDao() throws SQLException {
		connection = DButils.connection();
	}
	
	public void insertStudent(Student student) throws SQLException {
		String sql = "INSERT INTO student(name, branch , totalMarks) VALUES (?,?,?)";
		try(PreparedStatement insertstatement = connection.prepareCall(sql)) {
			insertstatement.setString(1, student.getName());
			insertstatement.setString(2, student.getBranch());
			insertstatement.setInt(3, student.getTotalMarks());
			insertstatement.executeUpdate();
		}
	}
	
	public List<Student> getAllStudent()throws SQLException{
		List<Student> studentlist = new ArrayList<Student>();
		String sql = "SELECT * FROM  student";
		try(PreparedStatement selectStatement = connection.prepareCall(sql)){
			ResultSet rs= selectStatement.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setBranch(rs.getString(3));
				student.setTotalMarks(rs.getInt(4));
				studentlist.add(student);
			}
		}
		return studentlist;
	}
	
	public void updateStudent(String branch,int id)throws SQLException{
		String sql = "UPDATE student SET branch = ? WHERE id = ? ";
		try(PreparedStatement updateDetail = connection.prepareCall(sql)){
			updateDetail.setString(1,branch);
			updateDetail.setInt(2,id);
			updateDetail.executeUpdate();
		}
	}
	
	public void deleteStudent(int id) throws SQLException {
		String sql="DELETE FROM student WHERE id = ?";
		try(PreparedStatement deleteStudent = connection.prepareCall(sql)){
			deleteStudent.setInt(1, id);
			deleteStudent.executeUpdate();
		}
	}
	
	
	@Override
	public void close() throws SQLException {
		if(connection!=null) {
			connection.close();
		}
		
	}
}
