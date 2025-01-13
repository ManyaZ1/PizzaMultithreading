package pizzapackage;

import java.util.LinkedList;

import enumerations.Distance;

public class Order implements Cloneable{
	private int order_num;
	private int done=-1;
	private int timeOrdered;
	private int waitingTime=-1;
	private String clientName;
	private int totalCost;
	private Distance distance;
	private int timetoTravel;
	public LinkedList<Pizza> listofPizzas=new LinkedList<Pizza>();
	
	//constructor
	public Order(Distance d,int timeOrdered,LinkedList<Pizza> list) {
		
		distance=d;
		calcTime();
		this.timeOrdered=timeOrdered;
		//sec_list = (LinkedList) list.clone();
		listofPizzas=(LinkedList) list.clone();
		clacTotalCost();
	}
@Override public Object clone() throws CloneNotSupportedException {
    return super.clone();
}
	public int getOrderNum() {return this.order_num;}
	public void setOrderNum(int x) {this.order_num=x;}
	public int getCost() {
		return totalCost;
	}
	public int getTimeOrdered() {
		return timeOrdered;
	}
	public int getTimeToTravel() {
		return this.timetoTravel;
	}
	public void setWaitingTime(int currentTime) {
		this.waitingTime=currentTime-this.timeOrdered;
	}
	public int getWaitingTime() {
		return this.waitingTime;
	}
	private void clacTotalCost() {
		for(int i=0;i<listofPizzas.size();i++) {
			Pizza p=listofPizzas.get(i);
			int c=p.getCost();
			this.totalCost+=c;
		}
		return ;
	}
	
	private int calcTime() {
		int t;
		if(this.distance==Distance.A) {t=5;}
		else if(this.distance==Distance.B) {t=10;}
		else {t=15;}
		this.timetoTravel=t;
		return t;
	}
	
	public void printinfo() {
		System.out.println("distance: "+distance+"\n"+"time to travel: "+timetoTravel+"\n"+"time ordered: "+timeOrdered);
		for(int i=0;i<listofPizzas.size();i++) {
			Pizza p=listofPizzas.get(i);
			int c=p.getCost();
			//p.printinfo();
			//System.out.println(c);
		}
		System.out.println("totalCost "+this.totalCost);
		if(done==1) {System.out.println("done");}
	}

	/*public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}*/
}
