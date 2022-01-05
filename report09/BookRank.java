package ksnu.eunjae.report09;
import java.util.Comparator;
public class BookRank implements Comparable<BookRank>{
	String title;
	int bookCount;

	public int compareTo(BookRank b1) {
		if(this.bookCount<b1.bookCount) return -1;
		if(this.bookCount>b1.bookCount) return 1;
		else return 0;
	}
	
	public BookRank(String title, int bookCount)
	{
		this.title = title;
		this.bookCount = bookCount;
	}
	
	public int getBookCount() {return bookCount;}
	
	public String getTitle() {return title;}
	public String toString(){return title+" "+bookCount;}
}
