package ksnu.eunjae.loop2;
import java.util.Scanner;
public class SamplePlus {
	public static void Plusmore(){
		int x, y;
		int sum = 0;
		Scanner rd = new Scanner(System.in);
		x = rd.nextInt();
		y = rd.nextInt();
		for (int i = x ; i < y; i++,System.out.println()) {
			sum+=i;
				System.out.print(sum + "+" + (i+1) + "=" + (sum+i+1));
		}
	}
}
