package ksnu.eunjae.report10;
import java.util.Scanner;

public class Main {
	final int MAX=1000;
	
	private Event[] event=null;
	private int idx=0;
	
	Main()
	{
		event=new Event[MAX];
	}
	
	public void ShowInterface()
	{
		System.out.println("<Interface>");
		System.out.println("1. 공연 데이터 입력 \t \t 2. 공연 리스트 보기(입력순)");
		System.out.println("3. 공연 리스트 보기(날짜순) \t \t 4. 담당자 이름으로 검색");
		System.out.println("5. 계약 공연 개수, 금액 총계 및 평균 보기 \t \t 6. 종료");
	}
	
	public int InputMenu()
	{
		ShowInterface();
		System.out.print("입력 : ");
		Scanner s=new Scanner(System.in);
		int ret=s.nextInt();
		return ret;
	}
	
	public void InputInform()
	{
		System.out.print("공연 종류 : ");
		Scanner s=new Scanner(System.in);
		String text=s.next();
		if(text.equals("콘서트"))
		{
			event[idx]=new Concert(); 
		}else if(text.equals("영화"))
		{
			event[idx]=new Movie();
		}else if(text.equals("연극"))
		{
			event[idx]=new Play();
		}else
		{
			System.out.println("잘못된 입력입니다.");
			return;
		}
		event[idx++].Input();
		
	}
	
	public void PrintList(Event[] event,int i)
	{
		System.out.println("번호 \t 공연명 \t 공연형태  \t 날짜 \t 담당자  \t 계약금액 \t 공연별 세부사항");
		
			System.out.print((i+1)+" \t "+event[i].getTitle()+" \t ");
			if(event[i] instanceof Concert)
			{
				System.out.print("콘서트\t ");
				((Concert)event[i]).Print();
			}else if(event[i] instanceof Movie)
			{
				System.out.print("영화\t ");
				((Movie)event[i]).Print();
			}
			else if(event[i] instanceof Play)
			{
				System.out.print("연극\t ");
				((Play)event[i]).Print();
			}else
				System.out.println("잘못된 입력입니다.");
	}
	
	public void PrintList(Event[] event)
	{
		System.out.println("번호 \t 공연명 \t 공연형태  \t 날짜 \t 담당자  \t 계약금액 \t 공연별 세부사항");
		for(int i=0;i<idx;i++)
		{
			System.out.print((i+1)+" \t "+event[i].getTitle()+" \t ");
			if(event[i] instanceof Concert)
			{
				System.out.print("콘서트\t ");
				((Concert)event[i]).Print();
			}else if(event[i] instanceof Movie)
			{
				System.out.print("영화\t ");
				((Movie)event[i]).Print();
			}
			else if(event[i] instanceof Play)
			{
				System.out.print("연극\t ");
				((Play)event[i]).Print();
			}else
				System.out.println("리스트가 비어있습니다.");
		}
	}
	
	public void DeepCopy(Event[] a,Event[] b)
	{
		for(int i=0;i<a.length;i++)
			b[i]=a[i];
	}
	
	public void PrintListByDateOdr()
	{
		Event[] e=new Event[event.length];
		DeepCopy(event,e);
		for(int i=0;i<idx-1;i++)
		{
			for(int j=i+1;j<idx;j++)
			{
				if(Integer.parseInt(e[i].getDate())>Integer.parseInt(e[j].getDate()))
				{
					Event tmp=e[i];
					e[i]=e[j];
					e[j]=tmp;
				}
			}
		}
		PrintList(e);
	}
	
	public void FindEventByName()
	{
		System.out.print("담당자 이름 : ");
		Scanner s=new Scanner(System.in);
		String name=s.next();
		for(int i=0;i<idx;i++)
		{
			if(event[i].getManager().equals(name))
			{
				PrintList(this.event,i);
			}
		}
	}
	
	public void PrintResult()
	{
		System.out.println("계약 공연 개수 : "+idx);
		int sum = 0;
		for(int i=0;i<idx;i++)
			sum+=event[i].getPrice();
		try{
			int avr=sum/idx;
			if(idx==0)throw new ArithmeticException();
			
			System.out.println("총계 : "+sum);
			System.out.println("평균 : "+avr);
		
		}catch(ArithmeticException e)
		{
			System.out.println("공연 수가 없어 평균을 구할 수 없습니다.");
		}
	}
	
	public void Run()
	{
		boolean r=true;
		while(r)
		{
			switch(InputMenu())
			{
			case 1:
				InputInform();
				break;
			case 2:
				PrintList(this.event);
				break;
			case 3:
				PrintListByDateOdr();
				break;
			case 4:
				FindEventByName();
				break;
			case 5:
				PrintResult();
				break;
			case 6:
				r=false;
				break;
			}
		}
		System.out.println("Bye.");
	}
	
	public static void main(String[] args)
	{
		new Main().Run();
	}
}
