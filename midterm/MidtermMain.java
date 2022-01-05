package ksnu.eunjae.midterm;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MidtermMain {
	String[] str = {"����", "����", "����"};
	public void dialog()
	{
		System.out.println("---------------------");
	    System.out.println("<����ó�� ���α׷�>");
	    System.out.println("1) ���� �Է��ϱ�(3����)");
	    System.out.println("2) ��������");
	    System.out.println("3) ���� �����ϱ�");
	    System.out.println("4) ��� ��������");
	    System.out.println("5) �ְ�/���� ��������");
	    System.out.println("6) ���� �����ؼ� ����");
	    System.out.println("0) ���θ޴��� ���ư���");
	    System.out.println("---------------------");
	}
	public int[][] makearray()
	{
		Scanner rd = new Scanner(System.in);	
		System.out.println("�����Է¸��>");
		int studentnum = rd.nextInt();
		int[][] temp = new int[studentnum][3];
		for(int i=0;i<temp.length;i++){
			System.out.println(i+"�� �л� ���� �Է�> ");
			for(int j = 0;j<3;j++){
				temp[i][j]=rd.nextInt();
			}
		}
		return temp;
	}
	public void viewGrade(int[][]studentArr)
	{
		System.out.println("��������");
		System.out.println("index  ����  ����  ����");
		for(int i = 0; i < studentArr.length; i++){
			System.out.print(i+"      ");
			for(int j = 0; j < 3; j++){
				System.out.print(studentArr[i][j]+"   ");
			}System.out.println(" ");
		}
	}
	public void modifyGrade(int[][]studentArr)
	{
		Scanner rd = new Scanner(System.in);	
		System.out.print("���������ϱ�\n �л� index ��ȣ?");
		int mnum = rd.nextInt();
		System.out.print("���� : ");
		for(int i=0;i<studentArr[mnum].length;i++){
			System.out.print(studentArr[mnum][i]+" ");
		}System.out.println(" ");
		System.out.print("���ο� ���� : ");
		for(int i=0;i<studentArr[mnum].length;i++){
			studentArr[mnum][i] = rd.nextInt();
		}
	}
	public void getAvg(int[][]studentArr)
	{
		int cnt =0;
		System.out.println("��� ��������");
		while(cnt<3){
			float sum=0;
			for(int i=0;i<studentArr.length;i++){
			 	sum+=studentArr[i][cnt];
			}
			System.out.println(str[cnt]+"���� ��� : "+(sum/studentArr.length));
			cnt++;
		}
	}
	
	public void getMaxMin(int[][]studentArr,int cnt)
	{
		System.out.println("�ְ�, ���� ��������");
		while(cnt<3){
			int min = 100, max=0, maxindex=0, minindex=0;
			for(int i=0;i<studentArr.length;i++){
				if(studentArr[i][cnt]<min){
					min=studentArr[i][cnt]; 
					minindex=i;
				}
				if(studentArr[i][cnt]>max){
					max=studentArr[i][cnt]; 
					maxindex=i;
				}
			}System.out.println(str[cnt]+" �ְ�/���� : "+ "�ְ� "+maxindex+"�� "+ max+", ���� "+minindex+"�� "+min);
			cnt++;
		}
	}
	public int inputException(int num)
	{
		while(num==0)
		{
			Scanner rd = new Scanner(System.in);
			try {
				System.out.print("����> ");
				num = rd.nextInt();
			}
			catch(InputMismatchException |NumberFormatException e){
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	public void menu()
	{
		dialog();
		Scanner rd = new Scanner(System.in);
		boolean run = true;
		int[][] studentArr = null;
		while(run){
			int num = 0;
			num=inputException(num);
			switch(num){
		 	 	case 0: run = false;
			    case 1: studentArr = makearray(); break;
		 	 	case 2: viewGrade(studentArr); break;
		 	 	case 3: modifyGrade(studentArr); break;
		 	 	case 4: getAvg(studentArr); break;
		 	 	case 5: getMaxMin(studentArr,0); break;
		 	 	//default: menuSelect(num,studentArr);
			}
		}
	}
	public static void main(String[]args)
	{
		MidtermMain gp = new MidtermMain();
		gp.menu();
	}
}
