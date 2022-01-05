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
	ArrayList<History> lendHistory = new ArrayList<History>();//id title 대여/반납 기록
	ArrayList<PersonRank> pr = new ArrayList<PersonRank>();
	ArrayList<BookRank> br = new ArrayList<BookRank>();
	
	public int inputException(int num)//예외처리 넣기
	{
		Scanner rd = new Scanner(System.in);
		while(num==999){
			try {
				num = rd.nextInt();
			}
			catch(InputMismatchException|NumberFormatException e){
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	void menu()//메뉴
	{
	      System.out.println("-------------------------------");
	      System.out.println("<도서관 프로그램-대여반납>");
	      System.out.println("1. 도서 대여하기(1명이 1번에 최대 5권의 책 대여가능)");//
	      System.out.println("2. 도서 반납 하기(다수의 책 한번에 반납 가능)");//
	      System.out.println("3. 도서 대여/반납 전체 목록 보기(도서대여/반납 task를 시간 순으로 나열해서 보기)");//
	      System.out.println("4. 대여자별 대여/반납 기록 보기(citizenNumber검색)");
	      System.out.println("5. 도서별 대여 기록 보기(도서일련번호검색)");
	      System.out.println("6. 도서 대여/반납 통계 보기(대여자 Ranking, 인기도서 Ranking 포함 자체 설계)");
	      System.out.println("0. 메인메뉴로 돌아감");//
	      System.out.println("-------------------------------");
	}
	public void setPerson(Person[] person)//사람 데이터 받아오기
	{
		this.person = person;
	}
	public void setBook(Book[] book)//책 데이터 받아오기
	{
		this.book = book;
	}

	public void printBook() //보유하고있는 책 출력
	{
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(book[i]);
		}
	}
	void secondStats()//두번째 통계자료
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
	void firstStats()//첫번째 통계자료
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
	void viewStatistics()//모든 통계 동작하는곳
	{
		Scanner scanner = new Scanner(System.in);
	    System.out.println("도서 통계");
	    System.out.println("1)대여자 순위 2)전체 인기도서 순위");
	    System.out.print("메뉴 입력>");
	    int stats_menu = inputException(999);
	    if(stats_menu==1) {
	    	System.out.println("대여자 순위");
	    	firstStats();
	    }
	    else if(stats_menu==2)
	    {
	    	System.out.println("전체 인기도서 순위");
	    	secondStats();
	    }
	}
	void viewHistoryByBook()//책 번호로 기록 보기
	{
		Scanner scanner = new Scanner(System.in);
	   System.out.println("도서별 대여 기록");
	   System.out.print("책 일련번호 입력: " );
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
	void viewHistoryByLender() //대여자별로 기록보기
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("대여자별 대여/반납 기록");
	    System.out.print("주민 번호 입력: " );
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
	void viewFullList()//전체 기록 보기
	{
		System.out.println("도서 대여/반납 전체 목록 보기");
	    for(int i = 0;i < lendHistory.size();i++)
	    {	
	    	System.out.println(lendHistory.get(i));
	    }
	}
	void returnBook2(String citizen_number)//반납하기
	{
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("반납할 도서 권수: " );
	     int num =  inputException(999);
	     for(int i = 0;i<num;i++){
		   System.out.print("책 일련번호 입력: " );
		   int book_number =  inputException(999);
		   for(int j = 0;j<book.length;j++){
			   if(book[j].getSerialNumber()==book_number){
			   		String title = book[j].getTitle();
			   		lendHistory.add(new History(citizen_number,book_number,title,"반납"));
			   		book[j].AddStock();
			   }	    	
		   }		   
	   }
	}
	void returnBook()//반납전 확인
	{
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("도서 반납\n주민 번호 입력: ");
	   String citizen_number = scanner.next();
	   System.out.println("내가 대여한 도서 list");
	   for(int i = 0; i<person.length;i++)
	   {
		   for(int j = 0; j<lendHistory.size();j++)
		   {
			   if(person[i].getCitizenNumber().equals(citizen_number)){
				   if(lendHistory.get(j).getCitizenNumber().equals(citizen_number)&&lendHistory.get(j).getState().equals("대여")){
					   System.out.println(lendHistory.get(j));
				   }
			   }			   
		   }

	   }
	   returnBook2(citizen_number);
	}
	public void lendBook2(String citizen_number,int num)//책빌려주기
	{
		Scanner scanner = new Scanner(System.in);
    	for(int i = 0; i<num;i++)
    	{
		    System.out.print("책 일련번호 입력: " );
		    int book_number =  inputException(999);
		    for(int j = 0;j<book.length;j++)
		    {
			    if(book[j].getSerialNumber()==book_number&&book[j].getStock()!=0)
			    {
			    	String title = book[j].getTitle();
			    	lendHistory.add(new History(citizen_number,book_number,title,"대여"));
			    	book[j].SubstractStock();
			    }	    	
		    }		    		
    	}
	}
	public void lendBook()//책 빌려주기전 확인단계
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("도서 대여\n주민 번호 입력: ");
	    String citizen_number = scanner.next();
	    System.out.println("도서관 보유도서 list");
	    printBook();
	    System.out.print("대여할 책 권수(최대 5권): " );
	    int num =  inputException(999);
	    if(num<=5)
	    {
	    	lendBook2(citizen_number,num);
	    }
	    else System.out.println("한번에 최대 5권 대여 가능합니다.");
	}
	
	public void serviceMain(Book[] book, Person[] person) //도서관리 메인
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
