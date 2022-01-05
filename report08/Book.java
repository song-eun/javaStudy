package ksnu.eunjae.report08;

public class Book {
	int serialNumber;
	String title;
	String author;
	int year;
	String publisher;
	int price;
	int stock;
	int count;
	public Book(int serialNumber,String title,String author,int year,String publisher,int price,int stock)
	{
		this.serialNumber = serialNumber;
		this.title = title;
		this.author = author;
		this.year = year;
		this.publisher = publisher;
		this.price = price;
		this.stock = stock;
	}
	
	public int getSerialNumber() { return serialNumber; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public int getYear() {return year;}
	public String getPublisher() {return publisher;}
	public int getStock() { return stock; }
	public int getCount() { return count;}
	public int getPrice() {return price;}
	
	public void setSerialNumber(int serialNumber) {this.serialNumber = serialNumber;}
	public void setTitle(String title) {this.title = title;}
	public void setAuthor(String author) {this.author = author;}
	public void setYear(int year) {this.year = year;}	
	public void setPublisher(String publisher) {this.publisher = publisher;}
	public void setPrice(int price) {this.price = price;}
	public void setStock(int stock) {this.stock = stock;}
	
	void updateStock(int new_stock) { this.stock+=new_stock; }
	public void AddStock() { this.stock+=1; }
	public void SubstractStock() { this.stock -=1; }
	public void addCount() { this.count+=1;}
	
	public String toString()
	{
		return serialNumber+" "+title+" "+author+" "+year+" "+publisher+" "+price+" "+stock;
	}
}
