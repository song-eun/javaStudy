package ksnu.eunjae.report11;
public class Refrigerator extends Product
{
	Refrigerator()
	{
		liter = 0;
		type = null;
	}
	int liter;
	public int getLiter()
	{
		return liter;
	}
	public void setLiter(int liter)
	{
		this.liter = liter;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	String type;
	
}
