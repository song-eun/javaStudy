package ksnu.eunjae.array.practice;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Practice_Third {
	
	public void win(String com, String user) {
		System.out.println("사용자 = "+user+", 컴퓨터 = "+com+", 사용자가 이겼습니다.");
	}
	
	public void lose(String com, String user){
		System.out.println("사용자 = "+user+", 컴퓨터 = "+com+", 사용자가 졌습니다.");
	}
	
	public void even(String com, String user){
		System.out.println("사용자 = "+user+", 컴퓨터 = "+com+", 비겼습니다.");
	}
	
	public void match(String com, String user)
	{
		if(user.equals(com)) even(com,user);
		if(com.equals("바위")){
			if(user.equals("보")) win(com,user);
			if(user.equals("가위")) lose(com,user);
		}
		else if(com.equals("가위")){
			if(user.equals("바위")) win(com,user);
			if(user.equals("보")) lose(com,user);
		}
		else if(com.equals("보")){
			if(user.equals("가위")) win(com,user);
			if(user.equals("바위")) lose(com,user);
		}
	}
	public static void rockPaperScissors()
	{
		Practice_Third p = new Practice_Third();
		Scanner rd = new Scanner(System.in);
		String str[] = {"가위","바위","보","그만"};
		String user,com;
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		boolean run = true;	
		while(run)
		{
			int n = (int)(Math.random()*3);
			com = str[n];	
			System.out.print("가위 바위 보!>>");	
			user = rd.nextLine();
			if(user.equals("그만")) 
			{
				run = false;
				System.out.println("게임을 종료합니다...");
			}
			else p.match(com, user);	
		}
	}
}
