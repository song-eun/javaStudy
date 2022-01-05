package ksnu.eunjae.report09;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import ksnu.eunjae.report07.Person;
import ksnu.eunjae.report08.Book;

public class lendService {
	Book[] book;
	Person[] person;
	ArrayList<History> lendHistory = new ArrayList<History>();//id title �뿩/�ݳ� ���
	ArrayList<PersonRank> pr = new ArrayList<PersonRank>();
	ArrayList<BookRank> br = new ArrayList<BookRank>();
	
	public int inputException(int num)//����ó�� �ֱ�
	{
		Scanner rd = new Scanner(System.in);
		while(num==999){
			try {
				num = rd.nextInt();
			}
			catch(InputMismatchException|NumberFormatException e){
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	void menu()//�޴�
	{
	      System.out.println("-------------------------------");
	      System.out.println("<������ ���α׷�-�뿩�ݳ�>");
	      System.out.println("1. ���� �뿩�ϱ�(1���� 1���� �ִ� 5���� å �뿩����)");//
	      System.out.println("2. ���� �ݳ� �ϱ�(�ټ��� å �ѹ��� �ݳ� ����)");//
	      System.out.println("3. ���� �뿩/�ݳ� ��ü ��� ����(�����뿩/�ݳ� task�� �ð� ������ �����ؼ� ����)");//
	      System.out.println("4. �뿩�ں� �뿩/�ݳ� ��� ����(citizenNumber�˻�)");
	      System.out.println("5. ������ �뿩 ��� ����(�����Ϸù�ȣ�˻�)");
	      System.out.println("6. ���� �뿩/�ݳ� ��� ����(�뿩�� Ranking, �α⵵�� Ranking ���� ��ü ����)");
	      System.out.println("0. ���θ޴��� ���ư�");//
	      System.out.println("-------------------------------");
	}
	public void setPerson(Person[] person)//��� ������ �޾ƿ���
	{
		this.person = person;
	}
	public void setBook(Book[] book)//å ������ �޾ƿ���
	{
		this.book = book;
	}

	public void printBook() //�����ϰ��ִ� å ���
	{
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(book[i]);
		}
	}
	void secondStats()//�ι�° ����ڷ�
	{
    	for(int i = 0;i<book.length;i++)
    	{
    		int count = 0;
    		int index = 0;
    		for(int j = 0;j<lendHistory.size();j++){
	    		if(lendHistory.get(j).getBookNumber()==book[i].getSerialNumber()){
	    			count++;
	    			index = i;
	    		}
    		}
    		br.add(new BookRank(book[index].getTitle(),count));
    	}
    	Collections.reverse(br);
	   for(BookRank b:br)
	   {
		   System.out.println(b.getTitle()+" "+b.getBookCount()+" ");
	   }
	   br.clear();
	}
	void firstStats()//ù��° ����ڷ�
	{
		for(int i = 0;i<person.length;i++){
    		int count = 0;
    		int index = 0;
    		for(int j = 0;j<lendHistory.size();j++){
	    		if(lendHistory.get(j).getCitizenNumber().equals(person[i].getCitizenNumber())){
	    			count++;
	    			index = i;
	    		}
    		}
    		pr.add(new PersonRank(person[index].getName(),count));
    	}
    	Collections.reverse(pr);
	    for(PersonRank p:pr){
	 	   System.out.println(p.getName()+" "+p.getCount()+" ");
	    }
	    pr.clear();
	}
	void viewStatistics()//��� ��� �����ϴ°�
	{
		Scanner scanner = new Scanner(System.in);
	    System.out.println("���� ���");
	    System.out.println("1)�뿩�� ���� 2)��ü �α⵵�� ����");
	    System.out.print("�޴� �Է�>");
	    int stats_menu = inputException(999);
	    if(stats_menu==1) {
	    	System.out.println("�뿩�� ����");
	    	firstStats();
	    }
	    else if(stats_menu==2)
	    {
	    	System.out.println("��ü �α⵵�� ����");
	    	secondStats();
	    }
	}
	void viewHistoryByBook()//å ��ȣ�� ��� ����
	{
		Scanner scanner = new Scanner(System.in);
	   System.out.println("������ �뿩 ���");
	   System.out.print("å �Ϸù�ȣ �Է�: " );
	   int book_number =  inputException(999);
		for(int i = 0; i<book.length;i++)
		{
			for(int j = 0; j<lendHistory.size();j++)
			{
				if(book[i].getSerialNumber()==book_number)
				{
					if(lendHistory.get(j).getBookNumber()==book_number)
					{
						System.out.println(lendHistory.get(j));
					}
				}
			}
		}
	}
	void viewHistoryByLender() //�뿩�ں��� ��Ϻ���
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("�뿩�ں� �뿩/�ݳ� ���");
	    System.out.print("�ֹ� ��ȣ �Է�: " );
		String citizen_number = scanner.next();
		for(int i = 0; i<person.length;i++)
		{
			for(int j = 0; j<lendHistory.size();j++)
			{
				if(person[i].getCitizenNumber().equals(citizen_number))
				{
					if(lendHistory.get(j).getCitizenNumber().equals(citizen_number))
					{
						System.out.println(lendHistory.get(j));
					}
				}				
			}
		}
	}
	void viewFullList()//��ü ��� ����
	{
		System.out.println("���� �뿩/�ݳ� ��ü ��� ����");
	    for(int i = 0;i < lendHistory.size();i++)
	    {	
	    	System.out.println(lendHistory.get(i));
	    }
	}
	void returnBook2(String citizen_number)//�ݳ��ϱ�
	{
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("�ݳ��� ���� �Ǽ�: " );
	     int num =  inputException(999);
	     for(int i = 0;i<num;i++){
		   System.out.print("å �Ϸù�ȣ �Է�: " );
		   int book_number =  inputException(999);
		   for(int j = 0;j<book.length;j++){
			   if(book[j].getSerialNumber()==book_number){
			   		String title = book[j].getTitle();
			   		lendHistory.add(new History(citizen_number,book_number,title,"�ݳ�"));
			   		book[j].AddStock();
			   }	    	
		   }		   
	   }
	}
	void returnBook()//�ݳ��� Ȯ��
	{
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("���� �ݳ�\n�ֹ� ��ȣ �Է�: ");
	   String citizen_number = scanner.next();
	   System.out.println("���� �뿩�� ���� list");
	   for(int i = 0; i<person.length;i++)
	   {
		   for(int j = 0; j<lendHistory.size();j++)
		   {
			   if(person[i].getCitizenNumber().equals(citizen_number)){
				   if(lendHistory.get(j).getCitizenNumber().equals(citizen_number)&&lendHistory.get(j).getState().equals("�뿩")){
					   System.out.println(lendHistory.get(j));
				   }
			   }			   
		   }

	   }
	   returnBook2(citizen_number);
	}
	public void lendBook2(String citizen_number,int num)//å�����ֱ�
	{
		Scanner scanner = new Scanner(System.in);
    	for(int i = 0; i<num;i++)
    	{
		    System.out.print("å �Ϸù�ȣ �Է�: " );
		    int book_number =  inputException(999);
		    for(int j = 0;j<book.length;j++)
		    {
			    if(book[j].getSerialNumber()==book_number&&book[j].getStock()!=0)
			    {
			    	String title = book[j].getTitle();
			    	lendHistory.add(new History(citizen_number,book_number,title,"�뿩"));
			    	book[j].SubstractStock();
			    }	    	
		    }		    		
    	}
	}
	public void lendBook()//å �����ֱ��� Ȯ�δܰ�
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �뿩\n�ֹ� ��ȣ �Է�: ");
	    String citizen_number = scanner.next();
	    System.out.println("������ �������� list");
	    printBook();
	    System.out.print("�뿩�� å �Ǽ�(�ִ� 5��): " );
	    int num =  inputException(999);
	    if(num<=5)
	    {
	    	lendBook2(citizen_number,num);
	    }
	    else System.out.println("�ѹ��� �ִ� 5�� �뿩 �����մϴ�.");
	}
	
	public void serviceMain(Book[] book, Person[] person) //�������� ����
	{
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		setBook(book);
		setPerson(person);
		while(run){
			menu();
			int num = inputException(999);
			switch(num){
				case 1:lendBook();break;
				case 2:returnBook();break;
				case 3:viewFullList();break;
				case 4:viewHistoryByLender();break;
				case 5:viewHistoryByBook();break;
				case 6:viewStatistics(); break;
				case 0:run = false;
			}
		}
	}
}
