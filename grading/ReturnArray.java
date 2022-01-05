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
	 	System.out.println("�������:"+avg.getAvg(studentArr));
	 	System.out.println("������:"+mid.getMid(result));
	}
	public void viewMaxMin(int[]studentArr)
	{
		System.out.println("�ְ�����:"+max.getMax(studentArr));
	    System.out.println("��������:"+min.getMin(studentArr));
	}
	public void viewBynum(int[] studentArr)
	{
		Scanner rd = new Scanner(System.in);
		System.out.println("�˻��� �л��� ��ȣ�� �Է��ϼ���: ");
		int num = rd.nextInt();		
		System.out.println((num)+"�� �л��� ������ "+ studentArr[num-1]+"�Դϴ�.");		
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
		System.out.println("ó���� �л��� ���� �Է��ϼ���(�ִ�100��):");
		int studentnum = rd.nextInt();
		int[] temp = new int[studentnum];
		for(int i=0;i<temp.length;i++)
		{
			System.out.println((i+1)+"�� �л� ����:");
			temp[i]=rd.nextInt();
		}
		return temp;
	}
	public int menuInsert()
	{
		Scanner rd = new Scanner(System.in);
	    System.out.println("<�л� ���� ó�� ���α׷�>");
	    System.out.println("1) �л� ���� �Է�");
	    System.out.println("2) �л� ��ü ���� ����Ʈ ����");
	    System.out.println("3) �л��� ��ȣ�� ���� ����");
	    System.out.println("4) ���� �ְ� ����, ���� ���� ����");
	    System.out.println("5) ���� ��� ����, ������ ���� ����");
	    System.out.println("6) ���� �����ؼ� ����");
	    System.out.println("0) ���� �޴��� ���ư�");
	    System.out.print("�Է� :");
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
