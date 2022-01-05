package ksnu.eunjae.report10;
import java.util.Scanner;

public class Event {
	
	private String title;
	private String date;
	private String manager;
	private int price;
	
	Event(){}
	
	public String getTitle(){return title;}
	public void setTitle(String _t){title=_t;}
	public String getDate(){return date;}
	public void setDate(String _d){date=_d;}
	public String getManager(){return manager;}
	public void setManager(String _m){manager=_m;}
	public int getPrice(){return price;}
	public void setPrice(int _p){price=_p;}
	
	public void Input()
	{
		Scanner s=new Scanner(System.in);
		System.out.print("공연 제목 : ");
		setTitle(s.next());
		System.out.print("날짜 : ");
		setDate(s.next());
		System.out.print("담당자 : ");
		setManager(s.next());
		System.out.print("계약금액 : ");
		setPrice(s.nextInt());
	}
	
	public void Print()
	{
		System.out.print(date+" \t "+manager+" \t "+price+" \t ");
	}

}
