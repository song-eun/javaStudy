package ksnu.eunjae.report10;
import java.util.Scanner;

public class Concert extends Event{
	
	Concert(){}
	
	private String singer;
	private String music;
	private String agent;
	private String danceTeam;
	
	public String getSinger(){return singer;}
	public String getMusic(){return music;}
	public String getAgent(){return agent;}
	public String getDanceTeam(){return danceTeam;}
	
	public void setSinger(String arg){singer=arg;}
	public void setMusic(String arg){music=arg;}
	public void setAgent(String arg){agent=arg;}
	public void setDanceTeam(String arg){danceTeam=arg;}
	
	
	public void Input()
	{
		super.Input();
		Scanner s=new Scanner(System.in);
		System.out.print("���� : ");
		setSinger(s.next());
		System.out.print("���� : ");
		setMusic(s.next());
		System.out.print("��ȹ�� : ");
		setAgent(s.next());
		System.out.print("����� : ");
		setDanceTeam(s.next());
	}
	
	public void Print()
	{
		super.Print();
		System.out.println("����:"+singer+",����"+music+",��ȹ��:"+agent+",�����:"+danceTeam);
	}
}

		
	


