package ksnu.eunjae.report10;
import java.util.Scanner;

public class Movie extends Event{
	
	Movie(){}
	
	private String director;
	private String actor;
	private String company;
	
	public String getDirector(){return director;}
	public String getActor(){return actor;}
	public String getCompany(){return company;}
	
	public void setDirector(String arg){director=arg;}
	public void setActor(String arg){actor=arg;}
	public void setCompany(String arg){company=arg;}
	
	
	public void Input()
	{
		super.Input();
		Scanner s=new Scanner(System.in);
		System.out.print("���� : ");
		setDirector(s.next());
		System.out.print("�⿬��� : ");
		setActor(s.next());
		System.out.print("��ȭ�� : ");
		setCompany(s.next());
		
	}
	
	public void Print()
	{
		super.Print();
		System.out.println("����:"+director+",�⿬���:"+actor+",��ȭ��:"+company);
	}
	

}

