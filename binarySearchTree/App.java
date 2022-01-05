package binarySearchTree;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class App {
	Scanner sc = new Scanner(System.in);
	AVLTree avlTree = new AVLTree();
	int inputException(int num)//예외처리 넣기
	{
		Scanner rd = new Scanner(System.in);
		while(num==999){
			try {
				num = rd.nextInt();
			}
			catch(InputMismatchException|NumberFormatException e){
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	void menu()
	{
		System.out.println("-------------------------------------");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 삭제");
		System.out.println("4. k번째 알파벳순 단어검색");
		System.out.println("5. 빈도수가 j보다 작은 단어 출력");
		System.out.println("6. 입력단어를 upper bound로 하는 단어 출력");
		System.out.println("0. 종료");
		System.out.println("-------------------------------------");
	}
	String randomWord() //랜덤 단어 생성
	{
	    String str = "";
	    int length = 4;
	    for (int i = 0; i < length; i++)
	    {
	        int category = ((int) (Math.random() * 100) % 3);
	        // 랜덤 숫자
	        if (category == 0)
	        {
	            int num = (int) (Math.random() * 10);
	            str = str.concat(String.valueOf(num));
	        } // 랜덤 소문자
	        else if (category == 1)
	        {
	            int startnum = 97;
	            int num = ((int) (Math.random() * 100) % 26);
	            char character = (char)(startnum + num);
	            str = str.concat(String.valueOf(character));
	        } // 랜덤 대문자
	        else
	        {
	            int startnum = 65;
	            int num = ((int) (Math.random() * 100) % 26);
	            char character = (char)(startnum + num);
	            str = str.concat(String.valueOf(character));
	        }
	    }
	    return str;
	}
	int randomCount() //랜덤 빈도수 생성
	{
        int num = (int)(Math.random() * 10);
        return num;
	}
	void addNode() //노드 추가
	{
		String word = randomWord();
		int count = randomCount();
		System.out.println("("+word+", "+count+")");
		avlTree.insert(word,count);	
	}
	
	void searchWord() //단어 검색
	{
		String str = sc.next();
		if(avlTree.search(str)==false)
			System.out.println("해당 단어는 존재하지 않습니다.");
	}
	
	void deleteNode() //노드 삭제
	{
		String str = sc.next();
		avlTree.delete(str);
	}
	
	void kthWord() //k번째 단어 찾기
	{
		System.out.print("몇 번째: ");
		int num = inputException(999);
		System.out.println(avlTree.getKthSmallest(avlTree.getRoot(), num));
	}
	
	void countJLessThan() //빈도수 j보다 작은 노드 찾기
	{
		System.out.print("빈도 수: ");
		int num = inputException(999);
		avlTree.countLessThan(avlTree.getRoot(), num);
		System.out.println("");
	}
	
	void wordUpperBound()
	{
		System.out.print("입력 단어: ");
		String str = sc.next();

		avlTree.getUpperBound(str);
		System.out.println("");
	}
	
	void process()
	{
		boolean run = true;
		while(run)
		{
			menu();
			System.out.print("입력: ");
			int choice = inputException(999);
			if(choice == 1) addNode();
			if(choice == 2) searchWord();
			if(choice == 3) deleteNode();
			if(choice == 4) kthWord();
			if(choice == 5) countJLessThan();
			if(choice == 6) wordUpperBound();
			if(choice == 0) run = false;
		}
	}
	
	public static void main(String[] args) {
		App a = new App();
		a.process();
	}
}
