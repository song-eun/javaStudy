package ksnu.eunjae.reportMain;
import java.util.InputMismatchException;
import java.util.Scanner;

import ksnu.eunjae.report07.Person;
import ksnu.eunjae.report07.PersonManage;
import ksnu.eunjae.report07.UniverMain;
import ksnu.eunjae.report08.Book;
import ksnu.eunjae.report08.BookManage;
import ksnu.eunjae.report09.lendService;
public class runMain {
	Book[] book;
	Person[] person;
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
	public Book[] setBook(Book[] book)
	{
		this.book = book;
		return book;	
	}
	public Person[] setPerson(Person[] person)
	{
		this.person = person;
		return person;
	}
	void dialog()
	{
		System.out.println("1) 대학 DB 관리 프로그램(과제07)");
		System.out.println("2) 도서관 프로그램(과제08)");
		System.out.println("3) 도서관 프로그램-대여반납(과제09)");
		System.out.println("0) 종료");
		System.out.print("선택 :");
	}
	void menu()
	{
		Scanner scanner = new Scanner(System.in);
		lendService l = new lendService();
		BookManage m = new BookManage();
		UniverMain pm = new UniverMain();
		while(true)
		{
			dialog();
			setBook(book);
			setPerson(person);
			int num = inputException(999);
			switch(num)
			{
			case 1: person = pm.studentDB();break;
			case 2: book=m.managePro();break;
			case 3: l.serviceMain(book,person);break;
			}
		}
	}
	public static void main(String[] args)
	{
		runMain r = new runMain();
		r.menu();
	}
}
