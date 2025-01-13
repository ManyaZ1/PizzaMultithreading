package main;

import pizzapackage.Pizzeria;

public class TaskClass implements Runnable{
	private Pizzeria pizzeria;
	public TaskClass(Pizzeria p) {this.pizzeria=p;}
	public void run() {
		pizzeria.goTroughOrders();
	}

}
