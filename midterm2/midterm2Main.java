package ksnu.eunjae.midterm2;
public class midterm2Main {
	public void dialog()
	{
		System.out.println("----------------------");
		System.out.println("<도서관 프로그램>");
		System.out.println("1.도서 정보 입력하기");
		System.out.println("2.도서 목록 보기");
		System.out.println("3.도서 정보 수정하기");
		System.out.println("4.도서 통계 보기");
		System.out.println("5.도서정보 검색(저자명)");
		System.out.println("6.가격 범위로 검색");
		System.out.println("0.메인메뉴 돌아가기");
		System.out.println("----------------------");
	}
	public boolean menu(boolean run,Book[] book)
	{
		BookManager bm = new BookManager();
		while(run)
		{
			System.out.println("입력: ");
			int num = bm.inputException(9);
			switch(num)
			{
				case 0: run = false;break;
				case 1: book = bm.inputBook(book);break;
				case 2: bm.printBook(book);break;
				case 3: bm.modifyBook(book);break;
				case 4: bm.statsBook(book);break;
				case 5: bm.searchAuthor(book);break;
				case 6: bm.searchPrice(book);break;
			}
		}
		return false;
	}
	public void mainPro()
	{
		dialog();
		boolean run = true;
		Book[] book = null;
		run = menu(run,book);
	}
	public static void main(String[] args)
	{
		midterm2Main m = new midterm2Main();
		m.mainPro();
	}
}
