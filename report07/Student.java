package ksnu.eunjae.report07;
import java.util.Scanner;
public class Student extends Person{
	int studentNumber;
	String dept;
	public Student(String citizenNumber, String name, int birthyear)
	{
		super(citizenNumber,name,birthyear);
		this.studentNumber = studentNumber;
		this.dept = dept;
	}
	
	public int getStudentNumber()
	{
		return studentNumber;
	}
	public String getDept()
	{
		return dept;
	}
	
	public void setStudentNumber(int studentNumber)
	{
		this.studentNumber=studentNumber;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}
	@Override
	public String toString() {
	   return super.toString()+" "+studentNumber+" "+dept+" ";
	}
}