package ksnu.eunjae.report11;
public class Product
{
	int id;
	Product()
	{
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getModel_name()
	{
		return model_name;
	}
	public void setModel_name(String model_name)
	{
		this.model_name = model_name;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	String model_name;
	int price;
	int count;
	
	
}
