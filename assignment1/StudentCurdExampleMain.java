package exampleStudent;

import java.util.Collection;
import java.util.Scanner;
import javaproject.jdbcDao;

public class StudentCurdExampleMain 
{	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean exit=true;
		
		while(exit)
		{
			System.out.println("------Operations to Perform------");
			System.out.println("1. Show All Student Details"
					+ "\n2. Get Any One Student Details"
					+ "\n3. Add One Student Details"
					+ "\n0. exit");
		
			System.out.println("\nEnter your choice:- ");
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				jdbcDao<Student, Integer> dao = new StudentDao();
				Collection<Student> StudentList = dao.getAll();
				StudentList.stream().forEach(stu -> System.out.println(stu));
				System.out.println("---------------------------------------");
				break;
			case 2:
				System.out.println("Enter the Student Roll No:- ");
				int rollno = sc.nextInt();
				jdbcDao<Student, Integer> dao1 = new StudentDao();
				Student Student = dao1.getOne(rollno);
				if(rollno != 0)
				System.out.println(Student);
				else
					System.out.println("Student with given ID does not exist.");
				System.out.println("---------------------------------------");
				break;
			case 3:
				System.out.println("Enter values for RollNo , Name , City");
				int rollno1 = sc.nextInt();
				String name = sc.next();
				String city = sc.next();
				jdbcDao<Student, Integer> stu = new StudentDao();
				Student stud = new Student(rollno1,name,city);
				stu.add(stud);
				System.out.println("---------------------------------------");
				break;
			case 0:
				exit = false;
				System.out.println("Thank you for Visiting...!!!");
				break;
				default:
					System.out.println("Enter a Valid Choice...!!!");
			}
			
		}
		
		

	}

}
