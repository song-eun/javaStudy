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
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	public void searchPrice(Book[] book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("가격범위로 검색");
		System.out.print("가격범위로 입력");
		int start = inputException(9);
		int end = inputException(9);
		System.out.println("번호  제목  저자  출판년도  출판사  가격  보유권수");
		for(int i = 0 ;i<book.length;i++){
			if(book[i].getPrice()>start&&book[i].getPrice()<end){
				System.out.println(i +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getNumberOfStock());
			}
		}
	}
	public void searchAuthor(Book[]book)
	{
		System.out.println("도서 정보 검색(저자명)");
		System.out.print("저자명 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("번호  제목  저자  출판년도  출판사  가격  보유권수");
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
		System.out.println("도서 통계 보기");
		System.out.println("전체 보유 도서 권수 : "+total+"권");
		System.out.println("도서당 평균 가격 : "+avg+"원");
		System.out.println("최고가격도서 : "+book[maxindex].getTitle()+" "+book[maxindex].getPrice()+"원");
		System.out.println("최저가격도서 : "+book[minindex].getTitle()+" "+book[minindex].getPrice()+"원");
	}
	public void modifyBook(Book[]book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("도서 정보 수정하기\n도서index? ");
		int mnum=inputException(9);
		System.out.print("현재: ");
		System.out.println(book[mnum].getTitle() + " " + book[mnum].getAuthor()+ "  " + book[mnum].getYear()+ "   " + book[mnum].getPublisher()+ " " + book[mnum].getPrice()+ "  " + book[mnum].getNumberOfStock());
		System.out.print("수정: ");
		book[mnum]=addBook(mnum,book);
	}
	public void printBook(Book[] book)
	{
		System.out.println("도서 목록 보기");
		System.out.println("번호  제목  저자  출판년도  출판사  가격  보유권수");
		for(int i =0;i<book.length;i++)
		{
			System.out.println(i +"  "+ book[i].getTitle() + "  " + book[i].getAuthor()+ "  " + book[i].getYear()+ "  " + book[i].getPublisher()+ "  " + book[i].getPrice()+ "  " + book[i].getNumberOfStock());
		}
	}
	public Book[] inputBook(Book[]book)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("도서 개수 입력> ");
		int num=inputException(9);
		book = new Book[num];
		for(int i=0; i<book.length; i++) {
			System.out.print(i+"번 도서 정보 입력> ");
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
