package random;

import java.util.Comparator;

import pizzapackage.Order;

public class ProfitComparator implements Comparator{
	public int compare(Object ob1,Object ob2){  
		Order o1=(Order)ob1;  
		Order o2=(Order)ob2;  
		int c1=o1.getCost();
		int c2=o2.getCost();
		if(c1==c2) {
			return 0;
		}
		if(c1>c2) {
			return -1;
		}
		else  {
			return 1;
		}
		//return s1.name.compareTo(s2.name);  
		}  

}
