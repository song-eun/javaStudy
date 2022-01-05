package ksnu.eunjae.grading;
import java.util.Arrays;
import java.util.Scanner;
class sorted{
	private static int[]sortedArr = null;
	public static int[] runSort(int[]studentArr)
	{
		sortedArr=studentArr.clone();
		Arrays.sort(sortedArr);
		return sortedArr;
	}
}
class avg{
	private static int sum = 0;
	private static int avg = 0;
	public static int getAvg(int[]studentArr)
	{
		for(int i=0;i<studentArr.length;i++)
		{
			sum += studentArr[i];
		}
		avg = sum/studentArr.length;
		return avg;
	}
}
class min{
	private static int min = 100;
	public static int getMin(int[]studentArr)
	{
		for(int i = 0; i<studentArr.length;i++)
		{
			if(studentArr[i]<min)min=studentArr[i];
		}
		return min;
	}
}
class max{
	private static int max = 0;
	public static int getMax(int[]studentArr)
	{
		for(int i = 0; i<studentArr.length;i++)
		{
			if(studentArr[i]>max)max=studentArr[i];
		}
		return max;
	}
}
class mid{
	private static int mid = 0;
	private static int sum = 0;
	public static int getMid(int[]result)
	{
		if(result.length%2==0)
		{
			sum = result[result.length/2]+result[result.length/2-1];
			mid = sum/2;
		}
		else
		{
			mid = result[result.length/2];
		}
		return mid;
	}
}

public class ReturnArray
{
	public void viewSort(int[]result,int[]studentArr)
	{
		result = sorted.runSort(studentArr);
	    for(int i=0;i<studentArr.length;i++)
	    {
	    	System.out.println((i+1)+":"+result[i]);
	    }
	}
	public void viewAvgMid(int[] result, int[]studentArr)
	{
	 	result = sorted.runSort(studentArr);
	 	System.out.println("평균점수:"+avg.getAvg(studentArr));
	 	System.out.println("중위값:"+mid.getMid(result));
	}
	public void viewMaxMin(int[]studentArr)
	{
		System.out.println("최고점수:"+max.getMax(studentArr));
	    System.out.println("최저점수:"+min.getMin(studentArr));
	}
	public void viewBynum(int[] studentArr)
	{
		Scanner rd = new Scanner(System.in);
		System.out.println("검색할 학생의 번호를 입력하세요: ");
		int num = rd.nextInt();		
		System.out.println((num)+"번 학생의 성적은 "+ studentArr[num-1]+"입니다.");		
	}
	public void viewAllGrade(int[] studentArr) 
	{
		for(int i=0;i<studentArr.length;i++)
		{
			System.out.println((i+1)+": "+ studentArr[i]);
		}
	}
	public int[] makearray()
	{
		Scanner rd = new Scanner(System.in);	
		System.out.println("처리할 학생의 수를 입력하세요(최대100점):");
		int studentnum = rd.nextInt();
		int[] temp = new int[studentnum];
		for(int i=0;i<temp.length;i++)
		{
			System.out.println((i+1)+"번 학생 성적:");
			temp[i]=rd.nextInt();
		}
		return temp;
	}
	public int menuInsert()
	{
		Scanner rd = new Scanner(System.in);
	    System.out.println("<학생 성적 처리 프로그램>");
	    System.out.println("1) 학생 성적 입력");
	    System.out.println("2) 학생 전체 성적 리스트 보기");
	    System.out.println("3) 학생의 번호로 성적 보기");
	    System.out.println("4) 성적 최고 점수, 최저 점수 보기");
	    System.out.println("5) 성적 평균 점수, 중위값 점수 보기");
	    System.out.println("6) 성적 정렬해서 보기");
	    System.out.println("0) 메인 메뉴로 돌아감");
	    System.out.print("입력 :");
		int menu = rd.nextInt();
		return menu;
	}
	public void studentGrade() 
	{
		ReturnArray p = new ReturnArray();
		int[] studentArr = null;
		int[] result = null;
		boolean run = true;
		while(run){
			int menu = menuInsert();
			switch(menu){
			    case 1: studentArr = p.makearray(); break;
	     	 	case 2: p.viewAllGrade(studentArr); break;
	     	 	case 3: p.viewBynum(studentArr); break;
	     	 	case 4: p.viewMaxMin(studentArr); break;
	     	 	case 5: p.viewAvgMid(result, studentArr); break;
	     	 	case 6: p.viewSort(result, studentArr); break;
	     	 	case 0: run = false;
			}
		}
	}
	public static void main (String[] args)
	{
		ReturnArray loop = new ReturnArray();
		loop.studentGrade();
	}
}
