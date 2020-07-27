package com.harshit.driver;

public class BeverageFactoryDriver {
	
	public static void main(String[] args) {
		
		BeveregeFactory factory=new BeveregeFactory();
		
		String mainOrder= " Chai ,-milk, -water,  Coffee, Mojito";
			Double costForOrder = factory.getCostForOrder(mainOrder);
			System.out.println("Total Cost for given order is : "+costForOrder);
		
		
	}
}
