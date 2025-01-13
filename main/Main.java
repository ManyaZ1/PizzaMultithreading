package main;
import java.util.ArrayList;
import java.util.Scanner;

import gui.MainScreen;
import pizzapackage.Order;
import pizzapackage.PizzaFIFO;
import pizzapackage.PizzaPROFIT;
import pizzapackage.PizzaRANDOM;
import random.Randomize;

public class Main {
	int totalOperationTime;
	static ArrayList<Order> list;
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		MainScreen m=new MainScreen(400,300);		
	}
	public static void simulate(int h,int n) {
		//create orders and pizzerias
				list=Randomize.listOfOrders(h, n);
				ArrayList<Order> l2=cloneList(list);
				ArrayList<Order> l3=cloneList(list);
				PizzaRANDOM pizzaRANDOM= new PizzaRANDOM(list,h,n);
				//pizzaRANDOM.printListOfOrders();
				PizzaPROFIT pizzaPROFIT=new PizzaPROFIT(l2,h,n);
				//pizzaPROFIT.printListOfOrders();
				PizzaFIFO pizzaFIFO=new PizzaFIFO(l3,h,n);
				//pizzaFIFO.printListOfOrders();
				
				
				TaskClass t1=new TaskClass(pizzaRANDOM);
				TaskClass t2=new TaskClass(pizzaFIFO);
				TaskClass t3=new TaskClass(pizzaPROFIT);
				Thread thread = new Thread(t1);
				Thread thread2 = new Thread(t2);
				Thread thread3 = new Thread(t3);
				
				thread.start();
				thread2.start();
				thread3.start();
	}
	
	private static int getMinutes() {
		System.out.println("hours:");
		int h=input.nextInt();
		int minutes=h*60;
		return minutes;
	}
	private static int getnumofclients() {
		System.out.println("clients:");
		int c=input.nextInt();
		return c;
	}
	public static ArrayList<Order> cloneList(ArrayList<Order> list) {
		ArrayList<Order> clone = new ArrayList<Order>(list.size());
		try {
	    for (Order item : list) clone.add((Order) item.clone());}
		catch(Exception e) {System.out.println(e.getMessage());}
	    return clone;
	}

}
