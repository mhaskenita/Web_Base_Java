package exampleStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javaproject.jdbcDao;
import javaproject.jdbcUtils;

public class StudentDao implements jdbcDao<Student, Integer>{

	
	@Override
	public Collection<Student> getAll() 
	{
		Collection<Student> allStudents = new ArrayList<>();
		try (Connection dbStudent = jdbcUtils.buildConnection();
			Statement stmt = dbStudent.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Student"))
		{
			while(rs.next())
			{
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				Student stu = new Student(rollno,name,city);
				allStudents.add(stu);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return allStudents;
	}
	

	@Override
	public Student getOne(Integer rollno) {
		Student foundStudent = null;
		String sqlQuery = "select * from student where rollno = ?";
		try (
				Connection dbConnection = jdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			)
			{
				pstmt.setInt(1, rollno);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					int rollno1 = rs.getInt(1);
					String name = rs.getString(2);
					String city = rs.getString(3);
					foundStudent = new Student(rollno1,name,city);	
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return foundStudent;
		
	}

	@Override
	public void add(Student Student) {
		
		String sqlQuery = "insert into Student values(?,?,?)";
		try (
				Connection dbConnection = jdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			)
			{
				int rollno = Student.getRollno();
				String name = Student.getName();
				String city = Student.getCity();
				
				pstmt.setInt(1, rollno);
				pstmt.setString(2, name);
				pstmt.setString(3, city);
				
				int UpdateCount = pstmt.executeUpdate();
				System.out.println(UpdateCount+" resoured Updated");
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
	}

	@Override
	public void update(Student student) {
		
		
	}

	@Override
	public void delete(Student rollno) {
		
		
	}

}
