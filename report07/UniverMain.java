package ksnu.eunjae.report07;
import java.util.Scanner;
public class UniverMain
{
	Person[] person = new Person[100];	
	
	void delateDB(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �����ϱ� ");
		System.out.print("������ index?");
		int size = 0;
		int index = scanner.nextInt();
		for(int i=0;i<person.length;i++){
			Person p = person[i];
			if(p==null) {
				size = i;
				break;
			}
		}
		for(int i = 0; person[i]!=null; i++){
			if(i>index){
				person[i-1]=person[i];
				if(i==size-1){
					person[i]=null;
					size--;
				}
			}
		}
		System.out.println(index+"�� �����͸� �����Ͽ����ϴ�.");
		printAll();
	}
	
	void changeDB()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �����ϱ� ");
		printAll();
		System.out.println("���� �߿� �����ϼ���.");	
		System.out.print("1.�̸� ���� 2. ����⵵ ����\n>");
		int selection = scanner.nextInt();
		System.out.print("������ index?");
		int index = scanner.nextInt();
		if(selection == 1)//�̸� ����
		{
			System.out.print("���� �̸�: ");
			System.out.println(person[index].getName());
			System.out.print("������ �̸�: ");
			String changeName = scanner.next();
			person[index].setName(changeName);
		}
		else if(selection == 2)//����⵵ ����
		{
			System.out.print("���� ����⵵: ");
			System.out.println(person[index].getBirthYear());
			System.out.print("������ ����⵵: ");
			int changeYear = scanner.nextInt();
			person[index].setBirthYear(changeYear);
		}
		System.out.println(index+"�� �����͸� �����Ͽ����ϴ�.");
		printAll();
	}	
	
	void searchBy()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �߿� �����ϼ���.");
		System.out.print("1.�̸����� �˻� 2. ���̷� �˻�\n>");
		int selection = scanner.nextInt();
		if(selection == 1)//�̸����� �˻�
		{
			System.out.print("�̸� �Է�: ");
			String name = scanner.next();
			System.out.println("�˻���� ");
			for(Person p:person)
			{
				if(p!=null && name.equals(p.getName())) {
					System.out.println(p.toString());
				}
			}
		}
		else if(selection == 2)
		{
			System.out.print("���� ���� �Է�: ");
			int startage = scanner.nextInt();
			int endage = scanner.nextInt();
			startage = 2022-startage;
			endage = 2022-endage;
			System.out.println("�˻����" );
			for(Person p:person){	
				if(p!=null&&p.getBirthYear()<startage&&p.getBirthYear()>endage)
				{
					System.out.println(p.toString());
				}
			}
		}
	}
	
	void printAll(){
		for(Person p:person)
		{
			if(p!=null) {
				if(p instanceof Student)
				    System.out.print("Student: "+p.toString());
				else if(p instanceof Person)
				    System.out.print("Person :"+p.toString());
			    System.out.println();				
			}
			else break;
		}
	}
	
	public Person[] inputDB(){
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���� �Է��Ͻðڽ��ϱ�?\n�Է�>");
		int size = sc.nextInt();
		for(int i = 0; i<size;i++){
			System.out.println("�������� ���¸� �����ϼ���.");
			System.out.print("1.�Ϲ��� 2.�л� 3.������ 4.����\n�Է�>");
			int selection = sc.nextInt();
			System.out.print("�ֹε�Ϲ�ȣ: ");
			String citizenNumber = sc.next();
			System.out.print("�̸�: ");
			String name=sc.next();
			System.out.print("����⵵: ");
			int birthyear = sc.nextInt();
			if(selection==1)
			{
				Person p = new Person(citizenNumber,name,birthyear);
				person[i] = p;	
			}
			else if(selection==2)
			{
				Student s = new Student(citizenNumber,name,birthyear);
				System.out.print("�й�: ");
				int studentnumber = sc.nextInt();
				s.setStudentNumber(studentnumber);
				System.out.print("����: ");
				String dept = sc.next();
				s.setDept(dept);
				person[i] = s;	
			}
			else if(selection==3)
			{
				
			}
			else if(selection==4)
			{
				
			}
		}
		return person;	
	}
	
	public void manual()
	{
		System.out.println("-------------------------");
		System.out.println("<����DB���� ���α׷�>");
		System.out.println("1. ���� ������ ������ �Է�");
		System.out.println("2. ���� ������ ������ ��ü ���");
		System.out.println("3. ���� ������ ������ ���� �˻�");
		System.out.println("4. ���� ������ ������ ����");
		System.out.println("5. ���� ������ ������ ����");
		System.out.println("0. ���� �޴��� ���ư���");
		System.out.println("-------------------------");
	}
	
	public Person[] studentDB()
	{
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while(run){
			manual();
			System.out.print("�޴� �Է�>");
			int menu = scanner.nextInt();
			switch(menu){
				case 1: person = inputDB();break;
				case 2: printAll();break;
				case 3: searchBy();break;
				case 4: changeDB();break;
				case 5: delateDB();break;
				case 0: run = false;
			}
		}
		return person;
	}

	public static void main(String[] args)
	{
		UniverMain d = new UniverMain();
		d.studentDB();
	}
}
