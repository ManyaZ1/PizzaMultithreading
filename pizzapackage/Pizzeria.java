package pizzapackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pizzeria {
	protected int numofclients;
	protected ArrayList<Order>ordersDONE=new ArrayList<Order>();
	protected String name;
	protected int income;
	protected int totalTime;
	protected int currentTime;
	protected ArrayList<Order> listOfOrders;
	//constructor
	public Pizzeria(ArrayList<Order> listOfOrders,int totalTime,int numofclients) {
		this.listOfOrders=new ArrayList<Order>(listOfOrders);
		this.totalTime=totalTime;
		this.numofclients=numofclients;
		income=0;
	}
	//koinh
	private int getTotalTime() {return totalTime;}
	private void addToFile() {
		try {
		      File myfile = new File("Pizza.txt");
		      if (myfile.createNewFile()) {
		        System.out.println("File created: " + myfile.getName());
		      } else {
		    	  myfile.delete();
		    	  myfile.createNewFile();
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try {	FileWriter myWriter = new FileWriter("Pizza.txt",true);
myWriter.write("------------------------------------------------------------------------------------------------------");
		  myWriter.write("\noperation time: "+this.totalTime+" minutes\n\n");
	      myWriter.write("income of "+this.name+": "+ this.income+"\n\n");
	      myWriter.write("orders received: "+this.numofclients+"\n");
	      myWriter.write("orders delivered: "+(ordersDONE.size()+1)+"\n");
	      myWriter.write("average waiting time: "+calculateDeliveryTime()+"\n\n");
	      myWriter.write("maximum waiting time: "+findMaxTime()+"\nminimum waiting time: "+findMinTime()+"\n\n");
	      myWriter.write("orders delivered(details): \n");
	      writeListOfOrders(myWriter);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } 
	catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
	}
	private boolean checkifdelivered(int x,ArrayList<Integer> deliveredOrders) {
		for(int i=0;i<deliveredOrders.size();i++) {
			if(x==deliveredOrders.get(i)) {return true;}
		}
		return false;
	}
	
	public void goTroughOrders() {
		ArrayList<Integer> deliveredOrders=new ArrayList<Integer>();
		for(currentTime=0;currentTime<this.totalTime;currentTime++) {
			for(int i=0;i<listOfOrders.size();i++) {
				Order o=listOfOrders.get(i);
				if(checkifdelivered(o.getOrderNum(),deliveredOrders)) {continue;}
				else if(o.getTimeOrdered()<=currentTime) {
					this.income+=o.getCost();
					this.currentTime+=2*o.getTimeToTravel();
					o.setWaitingTime(currentTime);
					//o.setDone(1);
					deliveredOrders.add(o.getOrderNum());
					ordersDONE.add(o);
					break;
				} 
			}
		}
		System.out.println("income of "+this.name+": "+ this.income);
		//printDONEorders();
		synchronized (this) {addToFile();}
	}
	/*public void goTroughOrders1() {
		
		while(currentTime<this.totalTime) {
			for(int i=0;i<listOfOrders.size();i++) {
				if(currentTime>this.totalTime) {break;}
				Order o=listOfOrders.get(i);
				//if(o.getDone()==1) {continue;}
				else if(o.getTimeOrdered()>currentTime) {continue;}
				else {
					this.income+=o.getCost();
					this.currentTime+=o.getTimeToTravel();
					System.out.println(this.currentTime);
					o.setWaitingTime(currentTime);
					//o.setDone(1);
					i=0;
					//o.printinfo();
				}
			}
			currentTime++;
		}
		System.out.println("income of "+this.name+": "+ this.income);
		//printDONEorders();
	}*/
	public void printListOfOrders() {
		for(int i=0;i<this.listOfOrders.size();i++) {
			Order o=listOfOrders.get(i);
			System.out.println("order no:"+o.getOrderNum());
			System.out.println("time ordered: "+o.getTimeOrdered()+" cost: "+o.getCost());
			o.printinfo();
			System.out.println("");
		}
	}
	private void writeListOfOrders(FileWriter myWriter) {
		for(int i=0;i<this.ordersDONE.size();i++) {
			Order o=ordersDONE.get(i);
			try {
				
			myWriter.write("order no: "+o.getOrderNum()+"\n");
			myWriter.write("time ordered: "+o.getTimeOrdered()+" cost: "+o.getCost()+" waiting time: "+o.getWaitingTime()+"\n");
			}
			catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();}
		}
		
	}
	private double calculateDeliveryTime() {
		int i;
		double total=0;
		for(i=0;i<ordersDONE.size();i++) {
			total+=ordersDONE.get(i).getWaitingTime();
		}
		total=(double)total/(double)(i);
		return total;
	}
	public void printDONEorders() {
		for(int i=0;i<ordersDONE.size();i++) {
			System.out.print(ordersDONE.get(i).getOrderNum()+", ");
		}
		System.out.print("\n");
	}
private int findMaxTime() {
	int t=0;
	for(int i=0;i<ordersDONE.size();i++) {
		if(ordersDONE.get(i).getWaitingTime()>=t) {t=ordersDONE.get(i).getWaitingTime();}
	}
	return t;
}
private int findMinTime() {
	int t=100;
	for(int i=0;i<ordersDONE.size();i++) {
		if(ordersDONE.get(i).getWaitingTime()<=t) {t=ordersDONE.get(i).getWaitingTime();}
	}
	return t;
}
	//oles diaforetika
	public abstract void  sortOrderList();
}
