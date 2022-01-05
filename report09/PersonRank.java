package ksnu.eunjae.report09;

import java.util.Comparator;

public class PersonRank implements Comparable<PersonRank> {
	String name;
	int count;
	
	public int compareTo(PersonRank p1) {
		if(this.count<p1.count) return -1;
		if(this.count>p1.count) return 1;
		else return 0;
	}
	
	public PersonRank(String name, int count){
		this.name = name;
		this.count = count;
	}

	public int getCount() {return count;}
	public String getName() {return name;}
	
	public String toString() {return name+" "+count;}
}
