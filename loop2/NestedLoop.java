package ksnu.eunjae.loop2;
import java.util.Scanner;
public class NestedLoop{
	public void Simplerun99() {
		int i,j;
		for (i = 1 ; i < 10; i++,System.out.println()) {
			for ( j = 1; j < 10; j++,System.out.print('\t')) {
				System.out.print(i + "*" + j + "=" + i*j);
			}
		}
	}
	public void run99more(int start, int end){
		int num1,num2;
		Scanner rd = new Scanner(System.in);
		System.out.println("어느 수부터 어느 수까지 곱할까요?(int, int):");
		num1 = rd.nextInt();
		num2 = rd.nextInt();	
		for(int i = start; i <= end; i++, System.out.println()) {
			for(int j = num1; j <= num2; j++, System.out.print('\t')) {
				System.out.print(i + "*" + j + "=" + i*j);
			}
		}
	}
	public void run99(){
		int start = 0, end = 0;
		Scanner rd = new Scanner(System.in);
		System.out.println("몇 단부터 몇 단까지 구구단을 출력할까요?(int, int)");
		start = rd.nextInt();
		end = rd.nextInt();
		run99more(start,end);
	}
}
