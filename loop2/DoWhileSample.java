package ksnu.eunjae.loop2;

public class DoWhileSample {
	public static void printAtoZ()
	{
		char a = 'a';
		do {
			System.out.print(a);
			a=(char)(a+1);
		}while(a<='z');
		System.out.print("\n");
	}
}
