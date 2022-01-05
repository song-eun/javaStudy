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
		System.out.print("�Է� : ");
		int key = scan.nextInt();
		return key;
	}

	public void Create_Product()
	{

		System.out.println("1. ����� 2. ����� 3. �����");
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
			System.out.print("��ǰ �� : ");
			name = scan.next();
			System.out.print("��ǰ ��ȣ: ");
			id = scan.nextInt();
			System.out.print("�ػ� : ");
			resolution = scan.next();
			System.out.print("ũ��: ");
			type = scan.next();
			System.out.print("����  : ");
			price = scan.nextInt();
			System.out.print("���� ���� : ");
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

			System.out.print("��ǰ �� : ");
			name = scan.next();
			System.out.print("��ǰ ��ȣ: ");
			id = scan.nextInt();
			System.out.print("����  : ");
			price = scan.nextInt();
			System.out.print("���� ���� : ");
			count = scan.nextInt();
			System.out.print("�뷮 : ");
			liter = scan.nextInt();
			System.out.print("Ÿ�� : ");
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
			System.out.print("��ǰ ��ȣ: ");
			id = scan.nextInt();
			System.out.print("��ǰ �� : ");
			name = scan.next();
			System.out.print("����  : ");
			price = scan.nextInt();
			System.out.print("���� ���� : ");
			count = scan.nextInt();
			System.out.print("���� ��� : ");
			amp = scan.nextInt();
			System.out.print("Ʃ�� ���� ����: ");
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
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");

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
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� : " + P[i].getPrice());

			} else if (P[i] instanceof Refrigerator)
			{
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� :" + P[i].getPrice());

			} else if (P[i] instanceof audio)
			{
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� :" + P[i].getPrice());

			}

		}
		
	}

	public void Print_product() throws NullPointerException
	{
		for (int i = 0; i < P.length; i++)
		{
			if (P[i] instanceof Monitor)
			{
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� : " + P[i].getPrice());
				System.out.println("��� ���� : " + P[i].getCount());
				System.out.println("��ǰ ��ȣ : " + P[i].getId());
				System.out.println("�ػ� : " + ((Monitor) P[i]).getResolution());
				System.out.println("ũ�� : " + ((Monitor) P[i]).getType());
			} else if (P[i] instanceof Refrigerator)
			{
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� :" + P[i].getPrice());
				System.out.println("��� ����" + P[i].getCount());
				System.out.println("��ǰ ��ȣ : " + P[i].getId());
				System.out.println("�뷮:" + ((Refrigerator) P[i]).getLiter());
				System.out.println("Ÿ��:" + ((Refrigerator) P[i]).getType());
			} else if (P[i] instanceof audio)
			{
				System.out.println("��ǰ�� : " + P[i].getModel_name());
				System.out.println("���� :" + P[i].getPrice());
				System.out.println("��� ����" + P[i].getCount());
				System.out.println("��ǰ ��ȣ : " + P[i].getId());
				System.out.println("���� ��� (w) : " + ((audio) P[i]).getAmp());
				System.out.println("Ʃ�� ���� ���� : " + ((audio) P[i]).getTunor());
			}
		}
	}

	public void Menu_view()
	{
		System.out.println("��ǰ �Է�(1) ��ǰ ����Ʈ ����(2) ���ݼ� ����Ʈ ����(3) ��ǰ�� �˻� (4) ��ǰ ���� �ݾ� �Ѱ� �� ���(5) ���� (6)");
	}

	public boolean find_model()
	{
		String name;
		System.out.print("�𵨸� : ");
		name = scan.next();

		for (int i = 0; i < P.length; i++)
		{
			if (P[i] == null)
				continue;
			if (P[i].getModel_name().equals(name))
			{
				if (P[i] instanceof Monitor)
				{
					System.out.println("��ǰ�� : " + P[i].getModel_name());
					System.out.println("���� : " + P[i].getPrice());
					System.out.println("��� ���� : " + P[i].getCount());
					System.out.println("��ǰ ��ȣ : " + P[i].getId());
					System.out.println("�ػ� : " + ((Monitor) P[i]).getResolution());
					System.out.println("ũ�� : " + ((Monitor) P[i]).getType());
				} else if (P[i] instanceof Refrigerator)
				{
					System.out.println("��ǰ�� : " + P[i].getModel_name());
					System.out.println("���� :" + P[i].getPrice());
					System.out.println("��� ����" + P[i].getCount());
					System.out.println("��ǰ ��ȣ : " + P[i].getId());
					System.out.println("�뷮:" + ((Refrigerator) P[i]).getLiter());
					System.out.println("Ÿ��:" + ((Refrigerator) P[i]).getType());
				} else if (P[i] instanceof audio)
				{
					System.out.println("��ǰ�� : " + P[i].getModel_name());
					System.out.println("���� :" + P[i].getPrice());
					System.out.println("��� ����" + P[i].getCount());
					System.out.println("��ǰ ��ȣ : " + P[i].getId());
					System.out.println("���� ��� (w) : " + ((audio) P[i]).getAmp());
					System.out.println("Ʃ�� ���� ���� : " + ((audio) P[i]).getTunor());
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
		System.out.println("��ǰ ���� : " + count);
		System.out.println("�Ѱ� : " + price);
		System.out.println("��� : " + average);
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
						System.out.println("�ش� �𵨸��� �����ϴ�");
					}

				} else if (num == 5)
				{
					total_product();
				} else if (num == 6)
				{
					System.out.print("���� �մϴ�.");
					T = false;
				} else
				{
					System.out.print("�޴� ������ �ùٸ����ʽ��ϴ�.");
				}
			}
		} catch (InputMismatchException e)
		{
			System.out.print("�߸� �� �Է� �Դϴ�");
		} catch (NullPointerException e)
		{
			System.out.print("�����Ͱ� �����ϴ�");
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
