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
		System.out.println("1. ���� ������ �Է� \t \t 2. ���� ����Ʈ ����(�Է¼�)");
		System.out.println("3. ���� ����Ʈ ����(��¥��) \t \t 4. ����� �̸����� �˻�");
		System.out.println("5. ��� ���� ����, �ݾ� �Ѱ� �� ��� ���� \t \t 6. ����");
	}
	
	public int InputMenu()
	{
		ShowInterface();
		System.out.print("�Է� : ");
		Scanner s=new Scanner(System.in);
		int ret=s.nextInt();
		return ret;
	}
	
	public void InputInform()
	{
		System.out.print("���� ���� : ");
		Scanner s=new Scanner(System.in);
		String text=s.next();
		if(text.equals("�ܼ�Ʈ"))
		{
			event[idx]=new Concert(); 
		}else if(text.equals("��ȭ"))
		{
			event[idx]=new Movie();
		}else if(text.equals("����"))
		{
			event[idx]=new Play();
		}else
		{
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		event[idx++].Input();
		
	}
	
	public void PrintList(Event[] event,int i)
	{
		System.out.println("��ȣ \t ������ \t ��������  \t ��¥ \t �����  \t ���ݾ� \t ������ ���λ���");
		
			System.out.print((i+1)+" \t "+event[i].getTitle()+" \t ");
			if(event[i] instanceof Concert)
			{
				System.out.print("�ܼ�Ʈ\t ");
				((Concert)event[i]).Print();
			}else if(event[i] instanceof Movie)
			{
				System.out.print("��ȭ\t ");
				((Movie)event[i]).Print();
			}
			else if(event[i] instanceof Play)
			{
				System.out.print("����\t ");
				((Play)event[i]).Print();
			}else
				System.out.println("�߸��� �Է��Դϴ�.");
	}
	
	public void PrintList(Event[] event)
	{
		System.out.println("��ȣ \t ������ \t ��������  \t ��¥ \t �����  \t ���ݾ� \t ������ ���λ���");
		for(int i=0;i<idx;i++)
		{
			System.out.print((i+1)+" \t "+event[i].getTitle()+" \t ");
			if(event[i] instanceof Concert)
			{
				System.out.print("�ܼ�Ʈ\t ");
				((Concert)event[i]).Print();
			}else if(event[i] instanceof Movie)
			{
				System.out.print("��ȭ\t ");
				((Movie)event[i]).Print();
			}
			else if(event[i] instanceof Play)
			{
				System.out.print("����\t ");
				((Play)event[i]).Print();
			}else
				System.out.println("����Ʈ�� ����ֽ��ϴ�.");
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
		System.out.print("����� �̸� : ");
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
		System.out.println("��� ���� ���� : "+idx);
		int sum = 0;
		for(int i=0;i<idx;i++)
			sum+=event[i].getPrice();
		try{
			int avr=sum/idx;
			if(idx==0)throw new ArithmeticException();
			
			System.out.println("�Ѱ� : "+sum);
			System.out.println("��� : "+avr);
		
		}catch(ArithmeticException e)
		{
			System.out.println("���� ���� ���� ����� ���� �� �����ϴ�.");
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
