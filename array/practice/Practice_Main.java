package ksnu.eunjae.array.practice;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
public class Practice_Main {
	
	public int menuDialog()
	{
		Scanner rd = new Scanner(System.in);
		System.out.println("�迭 �������� Ǯ��");
		System.out.println("1) �������� 8��");
		System.out.println("2) �������� 10��");
		System.out.println("3) �������� 16��");
		System.out.println("0) ����(�� ȭ������ ���ư���)");
		System.out.print("�Է�: ");
		int menu = rd.nextInt();
		return menu;
	}
	public void menu()
	{
		boolean run = true;
		int num=0;
		while(run){
			try {
				num = menuDialog();
			}
			catch(InputMismatchException |NumberFormatException e)
			{
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���!");
				continue;
			}
			switch(num){
				case 1: Practice_First.oneArr(); break;
				case 2: Practice_Second.twoArr(); break;
				case 3: Practice_Third.rockPaperScissors(); break;
				case 0: run = false;			
			}
		}
	}
	public static void main(String[] args)
	{
		Practice_Main p = new Practice_Main();
		p.menu();
	}
}
