package random;

import pizzapackage.Order;
import java.util.Comparator;
public class FifoComparator implements Comparator{
	public int compare(Object ob1,Object ob2){  
		Order o1=(Order)ob1;  
		Order o2=(Order)ob2;  
		int t1=o1.getTimeOrdered();
		int t2=o2.getTimeOrdered();
		if(t1==t2) {
			return 0;
		}
		if(t1>t2) {
			return 1;
		}
		else  {
			return -1;
		}
		//return s1.name.compareTo(s2.name);  
		}  

}
