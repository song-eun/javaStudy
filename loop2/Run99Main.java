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
		System.out.println("������ ���α׷��� �߿��� ������ �Լ��� �����ϼ���.");
		System.out.println("�������̸�: ������   �й�: 1801160");
		System.out.println("1) Ŀ�� �޴��� ������ ������ ������ִ� ���α׷�");
		System.out.println("2) �Էµ� ���� ��հ� ���� ���ϱ⿡�� ȭ�鿡 ����Ʈ�ϱ�");
		System.out.println("3) ���ĺ� A���� Z���� ����Ʈ�ϱ�");
		System.out.println("4) ���� x�� y�� �Է¹޾�, x���� y���� ���ϴ� ������ ��� ���̱�");
		System.out.println("5) 99�� �ܼ� ���");
		System.out.println("6) 99�� ��´ܼ��� ���� ���� �����ؼ� ����Ʈ�ϱ�");
		System.out.println("7) �л����� ó�� ���α׷�");
		System.out.println("8) �迭 �������� Ǯ��");
		System.out.println("9) ����ó�� ���α׷�(�߰���� 1��, ����06)");
		System.out.println("10) ���� DB ���� ���α׷�(����07)");
		System.out.println("11) ������ ���α׷�(����08)");
		System.out.println("12) ������ ���α׷�-�뿩�ݳ�(����09)");
		System.out.println("0) ����");
		System.out.print("���� :");
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