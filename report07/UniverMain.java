package ksnu.eunjae.report07;
import java.util.Scanner;
public class UniverMain
{
	Person[] person = new Person[100];	
	
	void delateDB(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 삭제하기 ");
		System.out.print("삭제할 index?");
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
		System.out.println(index+"번 데이터를 삭제하였습니다.");
		printAll();
	}
	
	void changeDB()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 수정하기 ");
		printAll();
		System.out.println("다음 중에 선택하세요.");	
		System.out.print("1.이름 수정 2. 출생년도 수정\n>");
		int selection = scanner.nextInt();
		System.out.print("수정할 index?");
		int index = scanner.nextInt();
		if(selection == 1)//이름 수정
		{
			System.out.print("현재 이름: ");
			System.out.println(person[index].getName());
			System.out.print("수정할 이름: ");
			String changeName = scanner.next();
			person[index].setName(changeName);
		}
		else if(selection == 2)//출생년도 수정
		{
			System.out.print("현재 출생년도: ");
			System.out.println(person[index].getBirthYear());
			System.out.print("수정할 출생년도: ");
			int changeYear = scanner.nextInt();
			person[index].setBirthYear(changeYear);
		}
		System.out.println(index+"번 데이터를 수정하였습니다.");
		printAll();
	}	
	
	void searchBy()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("다음 중에 선택하세요.");
		System.out.print("1.이름으로 검색 2. 나이로 검색\n>");
		int selection = scanner.nextInt();
		if(selection == 1)//이름으로 검색
		{
			System.out.print("이름 입력: ");
			String name = scanner.next();
			System.out.println("검색결과 ");
			for(Person p:person)
			{
				if(p!=null && name.equals(p.getName())) {
					System.out.println(p.toString());
				}
			}
		}
		else if(selection == 2)
		{
			System.out.print("나이 범위 입력: ");
			int startage = scanner.nextInt();
			int endage = scanner.nextInt();
			startage = 2022-startage;
			endage = 2022-endage;
			System.out.println("검색결과" );
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
		System.out.println("몇 명을 입력하시겠습니까?\n입력>");
		int size = sc.nextInt();
		for(int i = 0; i<size;i++){
			System.out.println("구성원의 형태를 선택하세요.");
			System.out.print("1.일반인 2.학생 3.연구원 4.교수\n입력>");
			int selection = sc.nextInt();
			System.out.print("주민등록번호: ");
			String citizenNumber = sc.next();
			System.out.print("이름: ");
			String name=sc.next();
			System.out.print("출생년도: ");
			int birthyear = sc.nextInt();
			if(selection==1)
			{
				Person p = new Person(citizenNumber,name,birthyear);
				person[i] = p;	
			}
			else if(selection==2)
			{
				Student s = new Student(citizenNumber,name,birthyear);
				System.out.print("학번: ");
				int studentnumber = sc.nextInt();
				s.setStudentNumber(studentnumber);
				System.out.print("전공: ");
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
		System.out.println("<대학DB관리 프로그램>");
		System.out.println("1. 대학 구성원 데이터 입력");
		System.out.println("2. 대학 구성원 데이터 전체 출력");
		System.out.println("3. 대학 구성원 데이터 조건 검색");
		System.out.println("4. 대학 구성원 데이터 변경");
		System.out.println("5. 대학 구성원 데이터 삭제");
		System.out.println("0. 메인 메뉴로 돌아가기");
		System.out.println("-------------------------");
	}
	
	public Person[] studentDB()
	{
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while(run){
			manual();
			System.out.print("메뉴 입력>");
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
