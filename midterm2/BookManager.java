package ksnu.eunjae.midterm2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BookManager {
	public int inputException(int num)
	{
		Scanner rd = new Scanner(System.in);
		while(num==9)
		{
			try {
				num = rd.nextInt();
			}
			catch(InputMismatchException |NumberFormatException e){
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	public void searchPrice(Book[] book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ݹ����� �˻�");
		System.out.print("���ݹ����� �Է�");
		int start = inputException(9);
		int end = inputException(9);
		System.out.println("��ȣ  ����  ����  ���ǳ⵵  ���ǻ�  ����  �����Ǽ�");
		for(int i = 0 ;i<book.length;i++){
			if(book[i].getPrice()>start&&book[i].getPrice()<end){
				System.out.println(i +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getNumberOfStock());
			}
		}
	}
	public void searchAuthor(Book[]book)
	{
		System.out.println("���� ���� �˻�(���ڸ�)");
		System.out.print("���ڸ� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("��ȣ  ����  ����  ���ǳ⵵  ���ǻ�  ����  �����Ǽ�");
		for(int i = 0 ;i<book.length;i++)
		{
			if(book[i].getAuthor().equals(name))
			{
				System.out.println(i +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getNumberOfStock());
			}
		}
	}
	public float getAvg(Book[] book)
	{
		float avg = 0;
		float sum = 0;
		for(int i = 0 ;i<book.length;i++)
		{
			sum+=book[i].getPrice();
		}
		avg = sum/book.length;
		return avg;
	}
	public int getMin(Book[] book)
	{
		int min = 1000000;
		int minIndex = 0;
		for(int i = 0 ;i<book.length;i++)
		{
			if(book[i].getPrice()<min)
			{
				min=book[i].getPrice();
				minIndex=i;
			}
		}
		return minIndex;
	}
	public int getMax(Book[] book)
	{
		int max = 0;
		int maxIndex = 0;
		for(int i = 0 ;i<book.length;i++)
		{
			if(book[i].getPrice()>max)
			{
				max=book[i].getPrice();
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	public int getTotalBook(Book[]book)
	{
		int total = 0;
		for(int i = 0 ;i<book.length;i++)
		{
			total+=book[i].getNumberOfStock();
		}
		return total;
	}
	public void statsBook(Book[]book)
	{
		float avg=getAvg(book);
		int minindex = getMin(book);
		int maxindex = getMax(book);
		int total = getTotalBook(book);
		System.out.println("���� ��� ����");
		System.out.println("��ü ���� ���� �Ǽ� : "+total+"��");
		System.out.println("������ ��� ���� : "+avg+"��");
		System.out.println("�ְ��ݵ��� : "+book[maxindex].getTitle()+" "+book[maxindex].getPrice()+"��");
		System.out.println("�������ݵ��� : "+book[minindex].getTitle()+" "+book[minindex].getPrice()+"��");
	}
	public void modifyBook(Book[]book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���� �����ϱ�\n����index? ");
		int mnum=inputException(9);
		System.out.print("����: ");
		System.out.println(book[mnum].getTitle() + " " + book[mnum].getAuthor()+ "  " + book[mnum].getYear()+ "   " + book[mnum].getPublisher()+ " " + book[mnum].getPrice()+ "  " + book[mnum].getNumberOfStock());
		System.out.print("����: ");
		book[mnum]=addBook(mnum,book);
	}
	public void printBook(Book[] book)
	{
		System.out.println("���� ��� ����");
		System.out.println("��ȣ  ����  ����  ���ǳ⵵  ���ǻ�  ����  �����Ǽ�");
		for(int i =0;i<book.length;i++)
		{
			System.out.println(i +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getNumberOfStock());
		}
	}
	public Book[] inputBook(Book[]book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���� �Է�> ");
		int num=inputException(9);
		book = new Book[num];
		for(int i=0; i<book.length; i++) {
			System.out.print(i+"�� ���� ���� �Է�> ");
			addBook(i,book);
		}
		return book;
	}
	public Book addBook(int mnum,Book[]book)
	{
		Scanner scanner = new Scanner(System.in);
		String title = scanner.next();
		String author = scanner.next();
		String year = scanner.next();
		String publisher = scanner.next();
		int price = inputException(9);
		int numberOfStock = inputException(9);
		book[mnum] = new Book(title, author, year, publisher, price, numberOfStock);
		return book[mnum];
	}
}
