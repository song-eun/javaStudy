package ksnu.eunjae.report09;

public class History {
	private String citizen_number;
	private int book_number;
	private String title;
	public String state;
	public History(String citizen_number,int book_number,String title,String state)
	{
		this.citizen_number = citizen_number;
		this.book_number = book_number;
		this.title = title;
		this.state = state;
	}
	
	public String getCitizenNumber() {return citizen_number;}
	public int getBookNumber() {return book_number;}
	public String getTitle() {return title;}
	public String getState() {return state;}
	
	public String toString()
	{
		return book_number+" "+title+" "+state;
	}
}
