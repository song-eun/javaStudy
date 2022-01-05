package ksnu.eunjae.array.practice;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
public class Practice_Main {
	
	public int menuDialog()
	{
		Scanner rd = new Scanner(System.in);
		System.out.println("배열 연습문제 풀기");
		System.out.println("1) 연습문제 8번");
		System.out.println("2) 연습문제 10번");
		System.out.println("3) 연습문제 16번");
		System.out.println("0) 종료(앞 화면으로 돌아가기)");
		System.out.print("입력: ");
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
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
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
