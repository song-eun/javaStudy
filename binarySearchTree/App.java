package binarySearchTree;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class App {
	Scanner sc = new Scanner(System.in);
	AVLTree avlTree = new AVLTree();
	int inputException(int num)//����ó�� �ֱ�
	{
		Scanner rd = new Scanner(System.in);
		while(num==999){
			try {
				num = rd.nextInt();
			}
			catch(InputMismatchException|NumberFormatException e){
				System.out.println("������ �ƴմϴ�. �ٽ� �Է��ϼ���!");
				rd.next();
				continue;
			}			
		}
		return num;
	}
	void menu()
	{
		System.out.println("-------------------------------------");
		System.out.println("1. �ܾ� �߰�");
		System.out.println("2. �ܾ� �˻�");
		System.out.println("3. �ܾ� ����");
		System.out.println("4. k��° ���ĺ��� �ܾ�˻�");
		System.out.println("5. �󵵼��� j���� ���� �ܾ� ���");
		System.out.println("6. �Է´ܾ upper bound�� �ϴ� �ܾ� ���");
		System.out.println("0. ����");
		System.out.println("-------------------------------------");
	}
	String randomWord() //���� �ܾ� ����
	{
	    String str = "";
	    int length = 4;
	    for (int i = 0; i < length; i++)
	    {
	        int category = ((int) (Math.random() * 100) % 3);
	        // ���� ����
	        if (category == 0)
	        {
	            int num = (int) (Math.random() * 10);
	            str = str.concat(String.valueOf(num));
	        } // ���� �ҹ���
	        else if (category == 1)
	        {
	            int startnum = 97;
	            int num = ((int) (Math.random() * 100) % 26);
	            char character = (char)(startnum + num);
	            str = str.concat(String.valueOf(character));
	        } // ���� �빮��
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
	int randomCount() //���� �󵵼� ����
	{
        int num = (int)(Math.random() * 10);
        return num;
	}
	void addNode() //��� �߰�
	{
		String word = randomWord();
		int count = randomCount();
		System.out.println("("+word+", "+count+")");
		avlTree.insert(word,count);	
	}
	
	void searchWord() //�ܾ� �˻�
	{
		String str = sc.next();
		if(avlTree.search(str)==false)
			System.out.println("�ش� �ܾ�� �������� �ʽ��ϴ�.");
	}
	
	void deleteNode() //��� ����
	{
		String str = sc.next();
		avlTree.delete(str);
	}
	
	void kthWord() //k��° �ܾ� ã��
	{
		System.out.print("�� ��°: ");
		int num = inputException(999);
		System.out.println(avlTree.getKthSmallest(avlTree.getRoot(), num));
	}
	
	void countJLessThan() //�󵵼� j���� ���� ��� ã��
	{
		System.out.print("�� ��: ");
		int num = inputException(999);
		avlTree.countLessThan(avlTree.getRoot(), num);
		System.out.println("");
	}
	
	void wordUpperBound()
	{
		System.out.print("�Է� �ܾ�: ");
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
			System.out.print("�Է�: ");
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
