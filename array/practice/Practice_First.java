package ksnu.eunjae.array.practice;
import java.util.*;
import java.util.InputMismatchException;
public class Practice_First 
{
	public int[] randomArray(int[] arr){
		int high = 100;
		int[] numbers = new int[high];
		for(int i=1;i<=100;i++) numbers[i-1] = i;
	    for(int i=0; i<arr.length; i++)
	    {
	    	int j = (int)(Math.random()*high);
	    	arr[i] = numbers[j];
	        numbers[j] = numbers[high-1];
	        high--;
	    }
		return arr;
	}
	public static void oneArr()
	{
		Practice_First p = new Practice_First();
		Scanner rd = new Scanner(System.in);
        int num = 1 ;
        int[] arr = null;
        while(num != 0 )
        {
          System.out.print("정수 몇개?");
           try {
              num = rd.nextInt();
              arr = new int[num];
              arr = p.randomArray(arr);
              for(int i=0;i<num;i++){
            	  if(i%10==0&&i!=0) System.out.println(" ");
            	  System.out.print(arr[i]+" ");
              }System.out.println(" ");
              break;
           }
           catch(InputMismatchException e) {
              System.out.println("정수가 아닙니다. 다시 입력하세요!");
              rd.next();
              continue;
             
           }
        }		  


	}
}
