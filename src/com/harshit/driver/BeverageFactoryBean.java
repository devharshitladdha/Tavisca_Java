package com.harshit.driver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeverageFactoryBean {

	//Menu
	private static final String CHAI = "chai";
    private static final String BANANA_SMOOTHIE = "banana smoothie";
    private static final String STRAWBERRY_SHAKE = "strawberry shake";
    private static final String MOJITO = "mojito";
    
    //Ingredients
    private static final String SUGAR = "sugar";
    private static final String WATER = "water";
    private static final String COFFEE = "coffee";
    private static final String MILK = "milk";
    private static final String SODA = "soda";
    private static final String MINT = "mint";
    private static final String STRAWBERRY = "strawberries";
    private static final String BANANA = "banana";
    private static final String TEA = "tea";
    private static final String LEMON = "lemon";
    
    //Price
    Map<String, Double> ingredientsPrice;
    Map<String, List<String>> baseToIngredientsMap;


	public BeverageFactoryBean() {
		populateIngredientsPrice();
		populateBaseToIngredientsMap();
	}
	
	 private void populateBaseToIngredientsMap() {

	        this.baseToIngredientsMap = new HashMap<>();
	        this.baseToIngredientsMap.put(COFFEE, Arrays.asList(MILK, SUGAR, WATER));
	        this.baseToIngredientsMap.put(CHAI, Arrays.asList(MILK, SUGAR, WATER));
	        this.baseToIngredientsMap.put(BANANA_SMOOTHIE, Arrays.asList(MILK, SUGAR, WATER));
	        this.baseToIngredientsMap.put(STRAWBERRY_SHAKE, Arrays.asList(WATER, MILK, SUGAR));
	        this.baseToIngredientsMap.put(MOJITO, Arrays.asList(SUGAR, WATER, SODA, MINT));
	    }
	
	private void populateIngredientsPrice() {
		this.ingredientsPrice=new HashMap<String, Double>();
		this.ingredientsPrice.put(MILK, 1.0d);
		this.ingredientsPrice.put(SUGAR, 0.5d);
		this.ingredientsPrice.put(SODA, 0.5d);
		this.ingredientsPrice.put(MINT, 0.5d);
		this.ingredientsPrice.put(WATER, 0.5d);
		this.ingredientsPrice.put(STRAWBERRY, 5.0d);
		this.ingredientsPrice.put(BANANA, 4.0d);
		this.ingredientsPrice.put(TEA, 2.0d);
		this.ingredientsPrice.put(LEMON, 5.5d);
		this.ingredientsPrice.put(COFFEE, 3.0d);
	}
	
	public Map<String, Double> getItemRates() {
		Map<String, Double> itemRates = new HashMap<>();
		itemRates.put(COFFEE, this.ingredientsPrice.get(COFFEE)+this.ingredientsPrice.get(MILK)+
				this.ingredientsPrice.get(WATER)+this.ingredientsPrice.get(SUGAR));
		itemRates.put(CHAI, this.ingredientsPrice.get(TEA)+this.ingredientsPrice.get(MILK)+
				this.ingredientsPrice.get(WATER)+this.ingredientsPrice.get(SUGAR));
		itemRates.put(BANANA_SMOOTHIE, this.ingredientsPrice.get(BANANA)+this.ingredientsPrice.get(MILK)+
				this.ingredientsPrice.get(WATER)+this.ingredientsPrice.get(SUGAR));
		itemRates.put(STRAWBERRY_SHAKE, this.ingredientsPrice.get(STRAWBERRY)+this.ingredientsPrice.get(MILK)+
				this.ingredientsPrice.get(WATER)+this.ingredientsPrice.get(SUGAR));
		itemRates.put(MOJITO, this.ingredientsPrice.get(LEMON)+this.ingredientsPrice.get(SODA)+
				this.ingredientsPrice.get(WATER)+this.ingredientsPrice.get(SUGAR)+this.ingredientsPrice.get(MINT));
		return itemRates;
	}

	public Map<String, Double> getIngredientsPrice() {
		return ingredientsPrice;
	}
	
	public Map<String, List<String>> getBaseToIngredientsMap() {
		return baseToIngredientsMap;
	}
    
    
}
