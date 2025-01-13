package pizzapackage;

import java.util.ArrayList;
import java.util.Collections;

import random.FifoComparator;
import random.ProfitComparator;

public class PizzaFIFO extends Pizzeria {
	public PizzaFIFO(ArrayList<Order> listOfOrders,int totalTime,int numofclients) {
		super(listOfOrders, totalTime,numofclients);
		sortOrderList() ;
		this.name="PizzaFIFO";
	}

	@Override
	public void sortOrderList() {
		// TODO Auto-generated method stub
		Collections.sort(this.listOfOrders,new FifoComparator());  
	}
}
