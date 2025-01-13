package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import enumerations.Distance;
import enumerations.Ingredients;
import pizzapackage.Order;
import pizzapackage.Pizza;

public class Randomize {
	//private static int totalOperationTimeInMInutes;
	private static Random random  = new Random();
		
	public static ArrayList<Order> listOfOrders(int totalOperationTime,int numOfClients) {
		ArrayList<Order> orderList=new ArrayList<>();
		//num of orders
		int numOfOrders=numOfClients;
		for(int i=0;i<numOfOrders;i++) {
			Order o=randOrder(totalOperationTime);
			o.setOrderNum(i);
			orderList.add(o);
			//o.printinfo();
		}
		return  orderList;
	}
	
	private static Order randOrder(int totalOperationTimeInMInutes) {
		Distance d=distance();
		LinkedList<Pizza> pizzas=new LinkedList<>();
		//num of pizzas
		int pizzasNum=random.nextInt(5)+1;
		for(int i=0;i<pizzasNum;i++) {
			pizzas.add(randPizza());
			//pizzas.get(i).printinfo();
		}
		//ordertime
		int ordertime=random.nextInt(totalOperationTimeInMInutes);
		//customer name TODO !!!!!!!!!!!!!
		Order o=new Order(d,ordertime,pizzas);
		return o;
		
	}
	
	private static Distance distance() {
		int s=random.nextInt(3);
		if(s==0) {return Distance.A;}
		if(s==1) {return Distance.B;}
		else return Distance.C;
	}
	
	private static Pizza randPizza() {
		ArrayList<Ingredients> ingredients=new ArrayList<>();
		//num of ingredients 0 ews kai 7
		int ingredientsNum = random.nextInt(8);
		//which ingredients	
		for(int i = 0;i<ingredientsNum;i++) {
			ingredients.add(randIngredient());
			
		}
		//System.out.println(ingredients+" -> "+ingredientsNum);
		Pizza p=new Pizza(ingredientsNum,ingredients);
		return p;	
	}
	
	private static Ingredients randIngredient() {
		int i=random.nextInt(7); //8elw 0 ews kai 6
		if(i==0) {return Ingredients.chicken;}
		if(i==1) {return Ingredients.ham;}
		if(i==2) {return Ingredients.olives;}
		if(i==3) {return Ingredients.onion;}
		if(i==4) {return Ingredients.peperoni;}
		if(i==5) {return Ingredients.pineapple;}
		if(i==6) {return Ingredients.sausage;}
		else {return Ingredients.ham;}
		
	}

}
