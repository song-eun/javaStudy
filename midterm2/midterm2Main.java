package ksnu.eunjae.midterm2;
public class midterm2Main {
	public void dialog()
	{
		System.out.println("----------------------");
		System.out.println("<������ ���α׷�>");
		System.out.println("1.���� ���� �Է��ϱ�");
		System.out.println("2.���� ��� ����");
		System.out.println("3.���� ���� �����ϱ�");
		System.out.println("4.���� ��� ����");
		System.out.println("5.�������� �˻�(���ڸ�)");
		System.out.println("6.���� ������ �˻�");
		System.out.println("0.���θ޴� ���ư���");
		System.out.println("----------------------");
	}
	public boolean menu(boolean run,Book[] book)
	{
		BookManager bm = new BookManager();
		while(run)
		{
			System.out.println("�Է�: ");
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
