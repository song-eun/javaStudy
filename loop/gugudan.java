package ksnu.eunjae.loop;
import java.util.Scanner;
public class gugudan{
	public void run99() 
	{
		int start = 1, end = 1;
		int num1,num2;
		int temp = 0;
		Scanner rd = new Scanner(System.in);
		while(true)
		{
			System.out.println("�� �ܺ��� �� �ܱ��� �������� ����ұ��?(int, int):");
			start = rd.nextInt();
			end = rd.nextInt();
			if(start == 0 && end == 0){
				break;
			}
			System.out.println("��� ������ ��� ������ ���ұ��?(int, int):");
			num1 = rd.nextInt();
			num2 = rd.nextInt();
			if(start > end){
				temp = start;
				start = end;
				end = temp;
			}
			if(num1 > num2){
				temp = num1;
				num1 = num2;
				num2 = temp;
			}
			for(int i = start; i <= end; i++, System.out.println()) {
				for(int j = num1; j <= num2; j++, System.out.print('\t')) {
					System.out.print(i + "*" + j + "=" + i*j);
				}
			}				
		}		
	}
	public static void main(String[] args)
	{
		gugudan aBot = new gugudan();
		aBot.run99();
	}
}