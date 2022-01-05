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
		System.out.println("<도서관 프로그램>");
		System.out.println("1.도서 정보 입력하기");
		System.out.println("2.도서 목록 보기");
		System.out.println("3.도서 정보 수정하기");
		System.out.println("4 도서 통계 보기");
		System.out.println("5. 도서정보 검색(저자명)");
		System.out.println("6. 가격 범위로 검색");
		System.out.println("7. 도서 정보 삭제");
		System.out.println("0. 메인메뉴로 돌아감");
		System.out.println("-------------------------------");
	}
	
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
	
	public void addBook(Book[] book)
	{
		Scanner scanner = new Scanner(System.in);
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(serialNumber+"번 도서 정보 입력> ");
			System.out.print("도서 제목> ");
			String title = scanner.next();
			System.out.print("저자이름>> ");
			String author = scanner.next();
			System.out.print("출판년도>> ");
			int year = inputException(999);
			System.out.print("출판사>> ");
			String publisher = scanner.next();
			System.out.print("책 가격>> ");
			int price = inputException(999);
			System.out.print("도서 보유권수> ");
			int stock = inputException(999);
			book[i] = new Book(serialNumber,title,author,year,publisher,price,stock);
			serialNumber++;
		}
	}
	public Book[] inputBook() {
		Scanner scanner = new Scanner(System.in);
		for(int i = 0;i<book.length;i++)
		{
			System.out.println(serialNumber+"번 도서 정보 입력> ");
			System.out.print("도서 제목> ");
			String title = scanner.next();
			System.out.print("저자이름>> ");
			String author = scanner.next();
			System.out.print("출판년도>> ");
			int year = inputException(999);
			System.out.print("출판사>> ");
			String publisher = scanner.next();
			System.out.print("책 가격>> ");
			int price = inputException(999);
			System.out.print("도서 보유권수> ");
			int stock = inputException(999);
			book[i] = new Book(serialNumber,title,author,year,publisher,price,stock);
			serialNumber++;
		}
		return book;
		
	}
	public void printBook()//도서 정보 전체 출력
	{
		System.out.println("도서 목록 보기");
		System.out.println("번호  제목  저자  출판년도  출판사  가격  보유권수");
		//for(int i = 0; i++)
			//System.out.println(book[i].getSerialNumber() +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getStock());
	}
	public Book[] managePro()
	{
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		lendService l = new lendService();
		//runMain r = new runMain();
		
		System.out.print("도서 개수 입력> ");
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
