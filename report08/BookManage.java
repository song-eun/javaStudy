package ksnu.eunjae.report08;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import ksnu.eunjae.reportMain.runMain;
import ksnu.eunjae.report09.lendService;

public class BookManage {
	int serialNumber;
	Book[] book;
	void menu()
	{
		System.out.println("-------------------------------");
		System.out.println("<������ ���α׷�>");
		System.out.println("1.���� ���� �Է��ϱ�");
		System.out.println("2.���� ��� ����");
		System.out.println("3.���� ���� �����ϱ�");
		System.out.println("4 ���� ��� ����");
		System.out.println("5. �������� �˻�(���ڸ�)");
		System.out.println("6. ���� ������ �˻�");
		System.out.println("7. ���� ���� ����");
		System.out.println("0. ���θ޴��� ���ư�");
		System.out.println("-------------------------------");
	}
	
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
	
	public void addBook(Book[] book)
	{
		Scanner scanner = new Scanner(System.in);
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(serialNumber+"�� ���� ���� �Է�> ");
			System.out.print("���� ����> ");
			String title = scanner.next();
			System.out.print("�����̸�>> ");
			String author = scanner.next();
			System.out.print("���ǳ⵵>> ");
			int year = inputException(999);
			System.out.print("���ǻ�>> ");
			String publisher = scanner.next();
			System.out.print("å ����>> ");
			int price = inputException(999);
			System.out.print("���� �����Ǽ�> ");
			int stock = inputException(999);
			book[i] = new Book(serialNumber,title,author,year,publisher,price,stock);
			serialNumber++;
		}
	}
	public Book[] inputBook() {
		Scanner scanner = new Scanner(System.in);
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(serialNumber+"�� ���� ���� �Է�> ");
			System.out.print("���� ����> ");
			String title = scanner.next();
			System.out.print("�����̸�>> ");
			String author = scanner.next();
			System.out.print("���ǳ⵵>> ");
			int year = inputException(999);
			System.out.print("���ǻ�>> ");
			String publisher = scanner.next();
			System.out.print("å ����>> ");
			int price = inputException(999);
			System.out.print("���� �����Ǽ�> ");
			int stock = inputException(999);
			book[i] = new Book(serialNumber,title,author,year,publisher,price,stock);
			serialNumber++;
		}
		return book;
		
	}
	public void printBook()//���� ���� ��ü ���
	{
		System.out.println("���� ��� ����");
		System.out.println("��ȣ  ����  ����  ���ǳ⵵  ���ǻ�  ����  �����Ǽ�");
		//for(int i = 0; i++)
			//System.out.println(book[i].getSerialNumber() +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getStock());
	}
	public Book[] managePro()
	{
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		lendService l = new lendService();
		//runMain r = new runMain();
		
		System.out.print("���� ���� �Է�> ");
		int size = inputException(999);
		//Book[] book = new Book[size];
		
		while(run)
		{
			int choice = scanner.nextInt();
			switch(choice){
			case 1: inputBook(); break;
			case 0: run=false;
			}
		}

		addBook(book);
		l.setBook(book);
		return book;

	}
}
