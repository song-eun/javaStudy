package binarySearchTree;

public class Node implements Comparable<Node>{
	
	private String word;
	private int count;
	
	private Node leftNode;
	private Node rightNode;
	private int height;
	
	public Node(String word,int count){
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "("+this.word+", "+this.count+")";
	}
	
	public int compareTo(Node node) {
		return this.word.compareTo(node.getWord());
	}
}
