package ksnu.eunjae.report11;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Productprocess
{
	static Scanner scan = new Scanner(System.in);
	Product[] P;
	int i;

	Productprocess()
	{
		P = new Product[50];
		i = 0;
	}

	public int Select_key()
	{
		System.out.print("입력 : ");
		int key = scan.nextInt();
		return key;
	}

	public void Create_Product()
	{

		System.out.println("1. 모니터 2. 냉장고 3. 오디오");
		int key = Select_key();

		if (key == 1)
		{
			String name;
			int price;
			int count;
			String resolution;
			String type;
			int id;
			P[i] = new Monitor();
			System.out.print("제품 명 : ");
			name = scan.next();
			System.out.print("제품 번호: ");
			id = scan.nextInt();
			System.out.print("해상도 : ");
			resolution = scan.next();
			System.out.print("크기: ");
			type = scan.next();
			System.out.print("가격  : ");
			price = scan.nextInt();
			System.out.print("제고 수량 : ");
			count = scan.nextInt();

			((Monitor) P[i]).setModel_name(name);
			((Monitor) P[i]).setPrice(price);
			((Monitor) P[i]).setCount(count);
			((Monitor) P[i]).setResolution(resolution);
			((Monitor) P[i]).setType(type);
			((Monitor) P[i]).setId(id);
			i++;
		}

		else if (key == 2)
		{
			String name;
			int price;
			int count;
			int liter;
			int id;
			String type;
			P[i] = new Refrigerator();

			System.out.print("제품 명 : ");
			name = scan.next();
			System.out.print("제품 번호: ");
			id = scan.nextInt();
			System.out.print("가격  : ");
			price = scan.nextInt();
			System.out.print("제고 수량 : ");
			count = scan.nextInt();
			System.out.print("용량 : ");
			liter = scan.nextInt();
			System.out.print("타입 : ");
			type = scan.next();
			
			((Refrigerator) P[i]).setModel_name(name);
			((Refrigerator) P[i]).setCount(count);
			((Refrigerator) P[i]).setPrice(price);
			((Refrigerator) P[i]).setCount(count);
			((Refrigerator) P[i]).setLiter(liter);
			((Refrigerator) P[i]).setType(type);
			((Refrigerator) P[i]).setId(id);

			i++;
		} else if (key == 3)
		{
			String name;
			int price;
			int count;
			int amp;
			String type;
			int id;
			P[i] = new audio();
			System.out.print("제품 번호: ");
			id = scan.nextInt();
			System.out.print("제품 명 : ");
			name = scan.next();
			System.out.print("가격  : ");
			price = scan.nextInt();
			System.out.print("제고 수량 : ");
			count = scan.nextInt();
			System.out.print("앰프 출력 : ");
			amp = scan.nextInt();
			System.out.print("튜너 지원 여부: ");
			type = scan.next();

			((audio) P[i]).setId(id);
			((audio) P[i]).setModel_name(name);
			((audio) P[i]).setPrice(price);
			((audio) P[i]).setCount(count);
			((audio) P[i]).setAmp(amp);
			((audio) P[i]).setTunor(type);
			i++;
		}
		else
		{
			System.out.println("잘못 입력하셨습니다.");

		}
	}

	public void high_price()
	{
		Product Price[];
		Price = new Product[i];
		
		for (int i = 0; i < Price.length; i++)
		{
			if (Price[i+1] == null)
				break;
			for (int j = 0; j < Price.length - (i + 1); j++)
			{
				
				if (P[j].getPrice() > P[j + 1].getPrice())
				{
					Product temp = P[j];
					Price[j] = Price[j + 1];
					Price[j + 1] = temp;
				}
			}
		}
		print_Product_price(Price);
	}

	public void print_Product_price(Product[] P) 
	{
	
		for (int i = 0; i < P.length; i++)
		{

			if (P[i] instanceof Monitor)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 : " + P[i].getPrice());

			} else if (P[i] instanceof Refrigerator)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 :" + P[i].getPrice());

			} else if (P[i] instanceof audio)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 :" + P[i].getPrice());

			}

		}
		
	}

	public void Print_product() throws NullPointerException
	{
		for (int i = 0; i < P.length; i++)
		{
			if (P[i] instanceof Monitor)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 : " + P[i].getPrice());
				System.out.println("재고 수량 : " + P[i].getCount());
				System.out.println("제품 번호 : " + P[i].getId());
				System.out.println("해상도 : " + ((Monitor) P[i]).getResolution());
				System.out.println("크기 : " + ((Monitor) P[i]).getType());
			} else if (P[i] instanceof Refrigerator)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 :" + P[i].getPrice());
				System.out.println("재고 수량" + P[i].getCount());
				System.out.println("제품 번호 : " + P[i].getId());
				System.out.println("용량:" + ((Refrigerator) P[i]).getLiter());
				System.out.println("타입:" + ((Refrigerator) P[i]).getType());
			} else if (P[i] instanceof audio)
			{
				System.out.println("제품명 : " + P[i].getModel_name());
				System.out.println("가격 :" + P[i].getPrice());
				System.out.println("재고 수량" + P[i].getCount());
				System.out.println("제품 번호 : " + P[i].getId());
				System.out.println("앰프 출력 (w) : " + ((audio) P[i]).getAmp());
				System.out.println("튜너 지원 여부 : " + ((audio) P[i]).getTunor());
			}
		}
	}

	public void Menu_view()
	{
		System.out.println("제품 입력(1) 제품 리스트 보기(2) 가격순 리스트 보기(3) 제품명 검색 (4) 제품 개수 금액 총계 및 평균(5) 종료 (6)");
	}

	public boolean find_model()
	{
		String name;
		System.out.print("모델명 : ");
		name = scan.next();

		for (int i = 0; i < P.length; i++)
		{
			if (P[i] == null)
				continue;
			if (P[i].getModel_name().equals(name))
			{
				if (P[i] instanceof Monitor)
				{
					System.out.println("제품명 : " + P[i].getModel_name());
					System.out.println("가격 : " + P[i].getPrice());
					System.out.println("재고 수량 : " + P[i].getCount());
					System.out.println("제품 번호 : " + P[i].getId());
					System.out.println("해상도 : " + ((Monitor) P[i]).getResolution());
					System.out.println("크기 : " + ((Monitor) P[i]).getType());
				} else if (P[i] instanceof Refrigerator)
				{
					System.out.println("제품명 : " + P[i].getModel_name());
					System.out.println("가격 :" + P[i].getPrice());
					System.out.println("재고 수량" + P[i].getCount());
					System.out.println("제품 번호 : " + P[i].getId());
					System.out.println("용량:" + ((Refrigerator) P[i]).getLiter());
					System.out.println("타입:" + ((Refrigerator) P[i]).getType());
				} else if (P[i] instanceof audio)
				{
					System.out.println("제품명 : " + P[i].getModel_name());
					System.out.println("가격 :" + P[i].getPrice());
					System.out.println("재고 수량" + P[i].getCount());
					System.out.println("제품 번호 : " + P[i].getId());
					System.out.println("앰프 출력 (w) : " + ((audio) P[i]).getAmp());
					System.out.println("튜너 지원 여부 : " + ((audio) P[i]).getTunor());
				}

				return true;
			}
		}
		return false;
	}

	public void total_product() 
	{
		int price = 0;
		double average = 0;
		int count = 0;
		
		for (int i = 0; i < P.length; i++)
		{
			if(P[i] == null)
				break;
			price += P[i].getPrice();
			count++;
		}
		average = price / count;
		System.out.println("제품 개수 : " + count);
		System.out.println("총계 : " + price);
		System.out.println("평균 : " + average);
	}

	public void Menu_select()
	{
		boolean T = true;
		try
		{
			while (T)
			{
				Menu_view();
				int num = Select_key();

				if (num == 1)
				{
					Create_Product();
				} else if (num == 2)
				{
					Print_product();
				} else if (num == 3)
				{
					high_price();
				} else if (num == 4)
				{
					if (!find_model())
					{
						System.out.println("해당 모델명이 없습니다");
					}

				} else if (num == 5)
				{
					total_product();
				} else if (num == 6)
				{
					System.out.print("종료 합니다.");
					T = false;
				} else
				{
					System.out.print("메뉴 선택이 올바르지않습니다.");
				}
			}
		} catch (InputMismatchException e)
		{
			System.out.print("잘못 된 입력 입니다");
		} catch (NullPointerException e)
		{
			System.out.print("데이터가 없습니다");
		}
	}

	public void Run()
	{
		Menu_select();

	}

	public static void main(String args[])
	{
		Productprocess P = new Productprocess();
		P.Run();
	}

}
