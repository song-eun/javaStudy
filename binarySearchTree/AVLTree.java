package binarySearchTree;

public class AVLTree {
	private Node root;
	
	public void insert(String word, int count) {
		root = insert(root,word,count);
	}
	
	// ���� ����
	private Node insert(Node node, String word, int count) {
		
		// root�� ����ְų� leaf ����� ��� ���ο� ��� ����
		if(node==null) {
			return (new Node(word,count));
		}
		
		/* ������ �����Ͱ� ��������� �����ͺ��� ������ ���� ������忡 ���ο� ��� ����
		                              ũ�� ������ ������忡 ���ο� ��� ���� */
		if(word.compareTo(node.getWord())<0) {
			node.setLeftNode(insert(node.getLeftNode(),word,count));
		}
		else {
			node.setRightNode(insert(node.getRightNode(),word,count));
		}
		
		//������ �Ϸ�ǰ� ����� ���� ����
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		
		//�������� ���� Ʈ���� �ұ����̸� ȸ������ ����
		node = settleViolation(word,count,node);
		
		return node;
	}
	
	//Ư�� ����� ���� ��ȯ
	private int height(Node node) {
		if(node==null) {
			return -1;
		}
		return node.getHeight();
	}
	
	// ������ ȸ��
	private Node rightRotation(Node parentNode) {
	    
		Node newParentNode = parentNode.getLeftNode(); // ���� �ڽĳ�尡 ���ο� �θ��尡 ��
	    Node nullNode = newParentNode.getRightNode(); // ���� �ڽĳ���� ������ �ڽĳ��(null ���)
	    
	    newParentNode.setRightNode(parentNode); // ���ο� �θ����� ������ �ڽĳ�忡 ������ �θ��带 ����
	    parentNode.setLeftNode(nullNode); //������ �θ����� ���� �ڽĳ�带 null ���� ����
	    
	    // ȸ���� ������ ���� ����
	    parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode()))+1);
	    newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode()))+1);

	    // ���ο� �θ��� ��ȯ
	    return newParentNode;
	}
	
	// ���� ȸ��
	private Node leftRotation(Node parentNode){
	    
		Node newParentNode = parentNode.getRightNode();
	    Node nullNode = newParentNode.getLeftNode();
	    
	    newParentNode.setLeftNode(parentNode);
	    parentNode.setRightNode(nullNode);
	    
	    parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode()))+1);
	    newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode()))+1);

	    return newParentNode;
	}  	
	
	//ȸ�� ���� : ���Խ�
	private Node settleViolation(String word, int count, Node node){
		
		//Ʈ���� �ұ��� ���� �ľ�
    	int balance = getBalance(node);
    	
    	//LL: ���� ���̰� 1���� ũ��, ���Ե� �����Ͱ� ��������� �����ͺ��� ���� ���
    	if(balance>1&&word.compareTo(node.getWord())<0) {
    		return rightRotation(node);//������ ȸ�� ����
    	}
    	
    	//RR: ���� ���̰� -1���� �۰�, ���Ե� �����Ͱ� ��������� �����ͺ��� ū ���
    	if(balance<-1&&word.compareTo(node.getWord())>0) {
    		return leftRotation(node);//���� ȸ�� ����
    	}
    	
    	//LR: ���� ���̰� 1���� ũ��, ���Ե� �����Ͱ� ��������� �����ͺ��� ū ���
    	if(balance>1&&word.compareTo(node.getWord())>0) {
    		node.setLeftNode(leftRotation(node.getLeftNode()));//���� ȸ�� ����
    		return rightRotation(node);//������ ȸ�� ����
    	}
    	
    	//RL: ���� ���̰� -1���� �۰�, ���Ե� �����Ͱ� ��������� �����ͺ��� ���� ���
    	if(balance<-1&&word.compareTo(node.getWord())<0) {
    		node.setRightNode(rightRotation(node.getRightNode()));//������ ȸ�� ����
    		return leftRotation(node);//���� ȸ�� ����
    	}
    	
    	return node;
    }
	
	//Ʈ�� ����/�ұ��� ���� �Ǵ�
    private int getBalance(Node node) {
    	
    	//Ʈ���� ����ִ� ����
    	if(node==null) {
    		return 0;
    	}
    	
    	//��� ����� 1���� ū ���: LL or LR
    	//��� ����� -1���� ���� ���: RR or RL
    	return height(node.getLeftNode()) - height(node.getRightNode());
    }

    //�˻� ����
    public boolean search(String word)
    {
    	Node tmp = root;
    	while(tmp!=null) {
		   	if(tmp.getWord().equals(word))
		    {
		    	System.out.println(tmp);
		    	return true;
		    }    
		   	else if(word.compareTo(tmp.getWord())<0)
		   	{
		   		tmp = tmp.getLeftNode();
		   	}
		   	else tmp = tmp.getRightNode();
    	}
    	return false;
    }
	
	public void delete(String word) {
		if(root!=null) {
			root=delete(root,word);
		}
	}
	
	//���� ����
	private Node delete(Node node, String word){
		
		if(node==null) {
			return node;
		}
		
		//������ ��� Ž��
		//������ ����� �����Ͱ� �θ����� �����ͺ��� ���� ���
		if(word.compareTo(node.getWord())<0) {
			node.setLeftNode(delete(node.getLeftNode(),word));//���� �ڽĳ�� �������� ���� ���ȣ��
		}
		//������ ����� �����Ͱ� �θ����� �����ͺ��� ū ���
		else if(word.compareTo(node.getWord())>0) {
			node.setRightNode(delete(node.getRightNode(),word));//������ �ڽĳ�� �������� ���� ���ȣ��
		}
		//������ ��带 ã�� ���
		else {
			
			//1. ������ ��尡 leaf ����� ���
			if(node.getLeftNode()==null&&node.getRightNode()==null) {
				return null;
			}
			
			//2. ������ ��尡 �ϳ��� �ڽĳ�带 ���� ���
			if(node.getLeftNode()==null) {
				Node tempNode = node.getRightNode();
				node = null;
				return tempNode;
			}
			else if(node.getRightNode()==null) {
				Node tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			}

			//3. ������ ��尡 �ΰ��� �ڽĳ�带 ���� ���
			Node tempNode = getPredecessor(node.getLeftNode()); //���� �ڽĳ�� �߿��� ���� ū ���
			node.setWord(tempNode.getWord()); //������ ����� �����Ϳ� ���� ū ����� ������ ��ȯ
			node.setCount(tempNode.getCount()); 
			node.setLeftNode(delete(node.getLeftNode(),tempNode.getWord())); //���� ���ȣ��
		}
		
		//���� ����
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		
		//���� �Ϸ��� Ʈ�� �ұ��� üũ, ȸ�� ����
		return settleDeletion(node);
	}

	//ȸ�� ���� : ������
	private Node settleDeletion(Node node){
		int balance = getBalance(node);
		
		//LL or LR�� ���
		if(balance>1) {
			//LR
			if(getBalance(node.getLeftNode())<0) {
				node.setLeftNode(leftRotation(node.getLeftNode())); //���� ȸ��
			}
			return rightRotation(node); //������ ȸ��
		}    
		
		//RR or RL�� ���
		if(balance<-1) {
			if(getBalance(node.getRightNode())>0) {
				node.setRightNode(rightRotation(node.getRightNode())); //������ ȸ��
			}
			return leftRotation(node); //���� ȸ��
		}
		return node;
	}
	
	//���� ���� ��忡�� ���� ū ��� Ž��
	private Node getPredecessor(Node node)
	{
		if(node.getRightNode()!=null) {
			return getPredecessor(node.getRightNode());
		}
		return node;
	}
	
	//��Ʈ ��� ��ȯ
	public Node getRoot(){
		return this.root;
	}
	
	//k��° ���� ��� ��ȯ
	public Node getKthSmallest(Node node, int k)
	{
		
		//���� ���� Ʈ�� ���� + ��Ʈ ���
		int n = treeSize(node.getLeftNode())+1;
		
		//���� ���� ��Ҹ� ã�� ���
		if(n==k) {
			return node;
		}
		
		//ã�� ��Ұ� ���� ���� Ʈ���� ������ ���
		if(n>k) {
			return getKthSmallest(node.getLeftNode(),k);
		}
		
		//ã�� ��Ұ� ������ ���� Ʈ���� ������ ���
		return getKthSmallest(node.getRightNode(),k-n);
	}
	
	//Ʈ�� ������ ��ȯ
	private int treeSize(Node node) {
		if(node==null) {
			return 0;
		}
		
		//���� ���� Ʈ�� + ������ ���� Ʈ���� ����� ���ϱ� ���� ���ȣ��
		//Ʈ���� ������ = ���� ���� Ʈ�� ������ + ������ ���� Ʈ�� ������ + 1
		return (treeSize(node.getLeftNode())+treeSize(node.getRightNode())+1);
	}
	
	//�Է��� �󵵼����� ���� �󵵸� ���� ��� ���
	public void countLessThan(Node node, int count)
	{
		if(node!=null)
		{
			if(node.getCount()<=count)
			{
				System.out.print(node+" ");
			}						
			countLessThan(node.getLeftNode(),count);
			countLessThan(node.getRightNode(),count);
		}
	}
	
	public void getUpperBound(String word)
	{
		int cnt = 0;
		if(getUpperBound(root,word)) {
			cnt++;
			if(cnt>0) return;
		}
	}
	
	private boolean getUpperBound(Node node, String word) {
		Node temp = null;
		int size = treeSize(root);
		if(node.getLeftNode()!=null)
		{
			getUpperBound(node.getLeftNode(),word);	
		}					
		if(word.compareTo(node.getWord())<=0)	
		{
			System.out.print(node+" ");
			return true;
		}
		if(node.getRightNode()!=null)
		{
			getUpperBound(node.getRightNode(),word);
		}
		return false;
	}
}