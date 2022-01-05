package ksnu.eunjae.array.practice;

public class Practice_Second {

	public void randomTwoArray(int[][]twoArray)
	{
		int count = 0;
		while(count!=10){
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			if(twoArray[y][x]==0){
				twoArray[y][x]=(int)(Math.random()*10+1);
				count++;
			}
		}		
		for(int i = 0;i < 4; i++) {
			for(int j = 0; j < 4; j++){
				System.out.print(twoArray[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static void twoArr()
	{
		int twoArray[][] = new int[4][4];
		Practice_Second p = new Practice_Second();
		p.randomTwoArray(twoArray);
	}
}
