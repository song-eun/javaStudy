package binarySearchTree;

public class AVLTree {
	private Node root;
	
	public void insert(String word, int count) {
		root = insert(root,word,count);
	}
	
	// 삽입 구현
	private Node insert(Node node, String word, int count) {
		
		// root가 비어있거나 leaf 노드인 경우 새로운 노드 생성
		if(node==null) {
			return (new Node(word,count));
		}
		
		/* 삽입할 데이터가 상위노드의 데이터보다 작으면 왼쪽 하위노드에 새로운 노드 생성
		                              크면 오른쪽 하위노드에 새로운 노드 생성 */
		if(word.compareTo(node.getWord())<0) {
			node.setLeftNode(insert(node.getLeftNode(),word,count));
		}
		else {
			node.setRightNode(insert(node.getRightNode(),word,count));
		}
		
		//삽입이 완료되고 노드의 높이 갱신
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		
		//삽입으로 인해 트리가 불균형이면 회전연산 수행
		node = settleViolation(word,count,node);
		
		return node;
	}
	
	//특정 노드의 높이 반환
	private int height(Node node) {
		if(node==null) {
			return -1;
		}
		return node.getHeight();
	}
	
	// 오른쪽 회전
	private Node rightRotation(Node parentNode) {
	    
		Node newParentNode = parentNode.getLeftNode(); // 왼쪽 자식노드가 새로운 부모노드가 됨
	    Node nullNode = newParentNode.getRightNode(); // 왼쪽 자식노드의 오른쪽 자식노드(null 노드)
	    
	    newParentNode.setRightNode(parentNode); // 새로운 부모노드의 오른쪽 자식노드에 기존의 부모노드를 세팅
	    parentNode.setLeftNode(nullNode); //기존의 부모노드의 왼쪽 자식노드를 null 노드로 세팅
	    
	    // 회전한 노드들의 높이 갱신
	    parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode()))+1);
	    newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode()))+1);

	    // 새로운 부모노드 반환
	    return newParentNode;
	}
	
	// 왼쪽 회전
	private Node leftRotation(Node parentNode){
	    
		Node newParentNode = parentNode.getRightNode();
	    Node nullNode = newParentNode.getLeftNode();
	    
	    newParentNode.setLeftNode(parentNode);
	    parentNode.setRightNode(nullNode);
	    
	    parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode()))+1);
	    newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode()))+1);

	    return newParentNode;
	}  	
	
	//회전 수행 : 삽입시
	private Node settleViolation(String word, int count, Node node){
		
		//트리의 불균형 여부 파악
    	int balance = getBalance(node);
    	
    	//LL: 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
    	if(balance>1&&word.compareTo(node.getWord())<0) {
    		return rightRotation(node);//오른쪽 회전 수행
    	}
    	
    	//RR: 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
    	if(balance<-1&&word.compareTo(node.getWord())>0) {
    		return leftRotation(node);//왼쪽 회전 수행
    	}
    	
    	//LR: 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
    	if(balance>1&&word.compareTo(node.getWord())>0) {
    		node.setLeftNode(leftRotation(node.getLeftNode()));//왼쪽 회전 수행
    		return rightRotation(node);//오른쪽 회전 수행
    	}
    	
    	//RL: 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
    	if(balance<-1&&word.compareTo(node.getWord())<0) {
    		node.setRightNode(rightRotation(node.getRightNode()));//오른쪽 회전 수행
    		return leftRotation(node);//왼쪽 회전 수행
    	}
    	
    	return node;
    }
	
	//트리 균형/불균형 여부 판단
    private int getBalance(Node node) {
    	
    	//트리가 비어있는 상태
    	if(node==null) {
    		return 0;
    	}
    	
    	//계산 결과가 1보다 큰 경우: LL or LR
    	//계산 결과가 -1보다 작은 경우: RR or RL
    	return height(node.getLeftNode()) - height(node.getRightNode());
    }

    //검색 구현
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
	
	//삭제 구현
	private Node delete(Node node, String word){
		
		if(node==null) {
			return node;
		}
		
		//삭제할 노드 탐색
		//삭제할 노드의 데이터가 부모노드의 데이터보다 작은 경우
		if(word.compareTo(node.getWord())<0) {
			node.setLeftNode(delete(node.getLeftNode(),word));//왼쪽 자식노드 방향으로 삭제 재귀호출
		}
		//삭제할 노드의 데이터가 부모노드의 데이터보다 큰 경우
		else if(word.compareTo(node.getWord())>0) {
			node.setRightNode(delete(node.getRightNode(),word));//오른쪽 자식노드 방향으로 삭제 재귀호출
		}
		//삭제할 노드를 찾은 경우
		else {
			
			//1. 삭제할 노드가 leaf 노드인 경우
			if(node.getLeftNode()==null&&node.getRightNode()==null) {
				return null;
			}
			
			//2. 삭제할 노드가 하나의 자식노드를 가진 경우
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

			//3. 삭제할 노드가 두개의 자식노드를 가진 경우
			Node tempNode = getPredecessor(node.getLeftNode()); //왼쪽 자식노드 중에서 가장 큰 노드
			node.setWord(tempNode.getWord()); //삭제할 노드의 데이터와 가장 큰 노드의 데이터 교환
			node.setCount(tempNode.getCount()); 
			node.setLeftNode(delete(node.getLeftNode(),tempNode.getWord())); //삭제 재귀호출
		}
		
		//높이 갱신
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		
		//삭제 완료후 트리 불균형 체크, 회전 수행
		return settleDeletion(node);
	}

	//회전 수행 : 삭제시
	private Node settleDeletion(Node node){
		int balance = getBalance(node);
		
		//LL or LR인 경우
		if(balance>1) {
			//LR
			if(getBalance(node.getLeftNode())<0) {
				node.setLeftNode(leftRotation(node.getLeftNode())); //왼쪽 회전
			}
			return rightRotation(node); //오른쪽 회전
		}    
		
		//RR or RL인 경우
		if(balance<-1) {
			if(getBalance(node.getRightNode())>0) {
				node.setRightNode(rightRotation(node.getRightNode())); //오른쪽 회전
			}
			return leftRotation(node); //왼쪽 회전
		}
		return node;
	}
	
	//왼쪽 하위 노드에서 가장 큰 노드 탐색
	private Node getPredecessor(Node node)
	{
		if(node.getRightNode()!=null) {
			return getPredecessor(node.getRightNode());
		}
		return node;
	}
	
	//루트 노드 반환
	public Node getRoot(){
		return this.root;
	}
	
	//k번째 작은 요소 반환
	public Node getKthSmallest(Node node, int k)
	{
		
		//왼쪽 하위 트리 갯수 + 루트 노드
		int n = treeSize(node.getLeftNode())+1;
		
		//가장 작은 요소를 찾을 경우
		if(n==k) {
			return node;
		}
		
		//찾는 요소가 왼쪽 하위 트리에 존재할 경우
		if(n>k) {
			return getKthSmallest(node.getLeftNode(),k);
		}
		
		//찾는 요소가 오른쪽 하위 트리에 존재할 경우
		return getKthSmallest(node.getRightNode(),k-n);
	}
	
	//트리 사이즈 반환
	private int treeSize(Node node) {
		if(node==null) {
			return 0;
		}
		
		//왼쪽 하위 트리 + 오른쪽 하위 트리의 사이즈를 구하기 위해 재귀호출
		//트리의 사이즈 = 왼쪽 하위 트리 사이즈 + 오른쪽 하위 트리 사이즈 + 1
		return (treeSize(node.getLeftNode())+treeSize(node.getRightNode())+1);
	}
	
	//입력한 빈도수보다 작은 빈도를 가진 노드 출력
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