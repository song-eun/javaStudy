package ksnu.eunjae.report07;
public class Person {
	String citizenNumber;
	String name;
	int birthyear;
	
	public Person(String citizenNumber, String name, int birthyear){
		this.citizenNumber = citizenNumber;
		this.name = name;
		this.birthyear = birthyear;
	}
	
	public String getCitizenNumber() { return citizenNumber; }
	public String getName() { return name; }
	public int getBirthYear() {return birthyear;}
	
	public void setCitizenNumber(String citizenNumber) { this.citizenNumber=citizenNumber;}
	public void setBirthYear(int birthyear){ this.birthyear=birthyear;}
	public void setName(String name){ this.name=name; }
	
	@Override
	public String toString() {
	   return citizenNumber+" "+name +" "+ birthyear+" ";
	}
}
