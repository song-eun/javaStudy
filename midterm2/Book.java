package ksnu.eunjae.midterm2;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private String year;
	private String publisher;
	private int price;
	private int numberOfStock;
	
	public Book() {};
	public Book(String title,String author,String year,String publisher,int price,int numberOfStock)
	{
		//this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.year = year;
		this.publisher = publisher;
		this.price = price;
		this.numberOfStock = numberOfStock;
	}
	/*public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(int numberOfStock) {
		this.numberOfStock = numberOfStock;
	}
	public String toString() {
		return " " + title+", "+author+", "+year+", "+publisher+", "+price+", "+numberOfStock + " ";
	}
}
