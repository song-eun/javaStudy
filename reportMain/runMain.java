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
		System.out.println("1) ���� DB ���� ���α׷�(����07)");
		System.out.println("2) ������ ���α׷�(����08)");
		System.out.println("3) ������ ���α׷�-�뿩�ݳ�(����09)");
		System.out.println("0) ����");
		System.out.print("���� :");
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
