package pizzapackage;

import java.util.ArrayList;

import enumerations.Ingredients;

public class Pizza {
	private int cost=5;
	private int numofIngredients;
	private ArrayList<Ingredients> ingredients;
	
	//constructor
	public Pizza(int ingredientsNum,ArrayList<Ingredients> ingredients) {
		numofIngredients=ingredientsNum;
		this.ingredients=new ArrayList(ingredients);
		cost=calcCost();
	}
	private int calcCost() {
		this.cost+=numofIngredients*2;
		return this.cost;
	}
	public int getCost() {
		return this.cost;
	}
	public void printinfo() {
		System.out.println(ingredients);
	}
	
}
