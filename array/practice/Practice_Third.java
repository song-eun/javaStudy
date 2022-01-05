package ksnu.eunjae.array.practice;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Practice_Third {
	
	public void win(String com, String user) {
		System.out.println("����� = "+user+", ��ǻ�� = "+com+", ����ڰ� �̰���ϴ�.");
	}
	
	public void lose(String com, String user){
		System.out.println("����� = "+user+", ��ǻ�� = "+com+", ����ڰ� �����ϴ�.");
	}
	
	public void even(String com, String user){
		System.out.println("����� = "+user+", ��ǻ�� = "+com+", �����ϴ�.");
	}
	
	public void match(String com, String user)
	{
		if(user.equals(com)) even(com,user);
		if(com.equals("����")){
			if(user.equals("��")) win(com,user);
			if(user.equals("����")) lose(com,user);
		}
		else if(com.equals("����")){
			if(user.equals("����")) win(com,user);
			if(user.equals("��")) lose(com,user);
		}
		else if(com.equals("��")){
			if(user.equals("����")) win(com,user);
			if(user.equals("����")) lose(com,user);
		}
	}
	public static void rockPaperScissors()
	{
		Practice_Third p = new Practice_Third();
		Scanner rd = new Scanner(System.in);
		String str[] = {"����","����","��","�׸�"};
		String user,com;
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		boolean run = true;	
		while(run)
		{
			int n = (int)(Math.random()*3);
			com = str[n];	
			System.out.print("���� ���� ��!>>");	
			user = rd.nextLine();
			if(user.equals("�׸�")) 
			{
				run = false;
				System.out.println("������ �����մϴ�...");
			}
			else p.match(com, user);	
		}
	}
}
