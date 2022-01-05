package ksnu.eunjae.loop2;
import java.util.Scanner;

//import Bookstore.Book;
//import University.Person;
import ksnu.eunjae.grading.ReturnArray;
import ksnu.eunjae.array.practice.Practice_Main;
import ksnu.eunjae.midterm.MidtermMain;
import ksnu.eunjae.report07.report07Main;
import ksnu.eunjae.report08.report08Main;
import ksnu.eunjae.report09.LibraryMain;
import ksnu.eunjae.report08.Book;
import ksnu.eunjae.report07.Person;
public class Run99Main{
	
	Book[] book;
	Person[] person;
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
	public int menudialog()
	{
		Scanner rd = new Scanner(System.in);
		System.out.println("다음의 프로그램들 중에서 수행할 함수를 선택하세요.");
		System.out.println("구현자이름: 송은재   학번: 1801160");
		System.out.println("1) 커피 메뉴를 넣으면 가격을 출력해주는 프로그램");
		System.out.println("2) 입력된 수의 평균과 갯수 구하기에서 화면에 프린트하기");
		System.out.println("3) 알파벳 A부터 Z까지 프린트하기");
		System.out.println("4) 정수 x와 y를 입력받아, x부터 y까지 더하는 과정과 결과 보이기");
		System.out.println("5) 99단 단순 찍기");
		System.out.println("6) 99단 출력단수와 수의 범위 설정해서 프린트하기");
		System.out.println("7) 학생성적 처리 프로그램");
		System.out.println("8) 배열 연습문제 풀기");
		System.out.println("9) 성적처리 프로그램(중간고사 1차, 과제06)");
		System.out.println("10) 대학 DB 관리 프로그램(과제07)");
		System.out.println("11) 도서관 프로그램(과제08)");
		System.out.println("12) 도서관 프로그램-대여반납(과제09)");
		System.out.println("0) 종료");
		System.out.print("선택 :");
		int menu = rd.nextInt();
		return menu;
	}
	public void menuMain()
	{
		Scanner rd = new Scanner(System.in);
		NestedLoop l = new NestedLoop();
		ReturnArray s = new ReturnArray();
		Practice_Main p = new Practice_Main();
		MidtermMain m = new MidtermMain();
		report07Main r = new report07Main();
		report08Main e = new report08Main();
		LibraryMain n = new LibraryMain();
		boolean run = true;
		while(run){
			int a = menudialog();
			switch(a){
				case 0: run = false;
				case 1:	CoffeePrice.calcPrice(); break;
				case 2: WhileSample.getAverage(); break;
				case 3:	DoWhileSample.printAtoZ(); break;
				case 4:	SamplePlus.Plusmore(); break;
				case 5:l.Simplerun99(); break;
				case 6:l.run99(); break;
				case 7:s.studentGrade(); break;
				case 8:p.menu();break;
				case 9:m.menu();break;
				case 10:person = r.studentDB();break;
				case 11:book = e.bookPro();break;
				case 12:n.mainPro(person,book);break;
			}
		}		
	}
	public static void main(String[] args){
		Run99Main loop = new Run99Main();
		loop.menuMain();
	}
}