package ksnu.eunjae.loop2;
import java.util.Scanner;
public class CoffeePrice {
	Scanner scanner = new Scanner(System.in);
	public void ordercoffee() {
		String order = scanner.next();
		int price = 0;
		switch(order) {
			case"����������":
			case"īǪġ��":
			case"ī���":
				price = 3500;
				break;
			case"�Ƹ޸�ī��":
				price = 2000;
				break;
			default:
				System.out.println("�޴��� �����ϴ�!");
		}
		if(price!=0)
			System.out.println(order+"��"+price+"���Դϴ�");
	}
	public static void calcPrice()
	{
		CoffeePrice l = new CoffeePrice();
		System.out.print("���� Ŀ�� �帱���?");
		l.ordercoffee();
	}
}
