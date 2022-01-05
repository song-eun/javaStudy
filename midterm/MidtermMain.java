package ksnu.eunjae.midterm;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MidtermMain {
	String[] str = {"국어", "영어", "수학"};
	public void dialog()
	{
		System.out.println("---------------------");
	    System.out.println("<성적처리 프로그램>");
	    System.out.println("1) 성적 입력하기(3과목)");
	    System.out.println("2) 성적보기");
	    System.out.println("3) 성적 수정하기");
	    System.out.println("4) 평균 성적보기");
	    System.out.println("5) 최고/최저 성적보기");
	    System.out.println("6) 성적 정렬해서 보기");
	    System.out.println("0) 메인메뉴로 돌아가기");
	    System.out.println("---------------------");
	}
	public int[][] makearray()
	{
		Scanner rd = new Scanner(System.in);	
		System.out.println("성적입력명수>");
		int studentnum = rd.nextInt();
		int[][] temp = new int[studentnum][3];
		for(int i=0;i<temp.length;i++){
			System.out.println(i+"번 학생 성적 입력> ");
			for(int j = 0;j<3;j++){
				temp[i][j]=rd.nextInt();
			}
		}
		return temp;
	}
	public void viewGrade(int[][]studentArr)
	{
		System.out.println("성적보기");
		System.out.println("index  국어  영어  수학");
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
		System.out.print("성적수정하기\n 학생 index 번호?");
		int mnum = rd.nextInt();
		System.out.print("현재 : ");
		for(int i=0;i<studentArr[mnum].length;i++){
			System.out.print(studentArr[mnum][i]+" ");
		}System.out.println(" ");
		System.out.print("새로운 성적 : ");
		for(int i=0;i<studentArr[mnum].length;i++){
			studentArr[mnum][i] = rd.nextInt();
		}
	}
	public void getAvg(int[][]studentArr)
	{
		int cnt =0;
		System.out.println("평균 성적보기");
		while(cnt<3){
			float sum=0;
			for(int i=0;i<studentArr.length;i++){
			 	sum+=studentArr[i][cnt];
			}
			System.out.println(str[cnt]+"성적 평균 : "+(sum/studentArr.length));
			cnt++;
		}
	}
	
	public void getMaxMin(int[][]studentArr,int cnt)
	{
		System.out.println("최고, 최저 성적보기");
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
			}System.out.println(str[cnt]+" 최고/최저 : "+ "최고 "+maxindex+"번 "+ max+", 최저 "+minindex+"번 "+min);
			cnt++;
		}
	}
	public int inputException(int num)
	{
		while(num==0)
		{
			Scanner rd = new Scanner(System.in);
			try {
				System.out.print("선택> ");
				num = rd.nextInt();
			}
			catch(InputMismatchException |NumberFormatException e){
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
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
