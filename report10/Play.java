package ksnu.eunjae.report10;

import java.util.Scanner;

public class Play extends Event{
	
	Play(){}
	
	private String director;
	private String actor;
	private String lightmanager;
	
	public String getDirector(){return director;}
	public String getActor(){return actor;}
	public String getLightManager(){return lightmanager;}
	
	
	public void setDirector(String arg){director=arg;}
	public void setActor(String arg){actor=arg;}
	public void setLightManager(String arg){lightmanager=arg;}
	
	public void Input()
	{
		super.Input();
		Scanner s=new Scanner(System.in);
		System.out.print("���� : ");
		setDirector(s.next());
		System.out.print("�⿬��� : ");
		setActor(s.next());
		System.out.print("������ : ");
		setLightManager(s.next());
		
	}
	
	public void Print()
	{
		super.Print();
		System.out.println("����:"+director+",�⿬���:"+actor+",������:"+lightmanager);
	}
	
}

	
