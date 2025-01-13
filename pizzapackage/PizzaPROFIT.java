package pizzapackage;
import random.ProfitComparator;
import java.util.ArrayList;
import java.util.Collections;

public class PizzaPROFIT  extends Pizzeria{
	public PizzaPROFIT(ArrayList<Order> listOfOrders,int totalTime,int numofclients) {
		super(listOfOrders, totalTime, numofclients);
		sortOrderList();
		this.name="PizzaPROFIT";
	}

	@Override
	public void sortOrderList() {
		// TODO Auto-generated method stub
		Collections.sort(this.listOfOrders,new ProfitComparator());  
	}
}
