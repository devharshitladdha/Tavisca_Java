package com.harshit.driver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BeveregeFactory {
	
	BeverageFactoryBean bean=new BeverageFactoryBean();
	
	public Double getCostForOrder(String mainOrder) {
		double cost=0.0d;
		List<String> orders=getAllItemsFromOrder(mainOrder);
		for(String order:orders) {
			isValidOrder(order);
			List<String> itemIngredients = getIngredientFromOrder(order);
			cost+=calcInvoice(itemIngredients);
		}
		return cost;
	}
	
	private void isValidOrder(String order) {
		List<String> itemIngredients = getIngredientFromOrder(order);
		
		if(!bean.getBaseToIngredientsMap().containsKey(itemIngredients.get(0))) {
			throw new RuntimeException("Invalid Order");
		}
		
		List<String> allIngredients = bean.getBaseToIngredientsMap().get(itemIngredients.get(0));
		
		Optional<String> multipleIngr = itemIngredients.stream().filter(item -> Collections.frequency(itemIngredients, item)>1).findFirst();
		if(multipleIngr.isPresent()) {
			throw new RuntimeException("Invalid Order");
		}
		
		 List<String> ingredientsPresent = itemIngredients.subList(1, itemIngredients.size());
		 boolean validIngredients = ingredientsPresent.stream().allMatch(t -> allIngredients.stream().anyMatch(t::contains));
		 
		 if (!validIngredients){
			 throw new RuntimeException("Invalid Order");
		 }
		 
		 if (itemIngredients.size() == allIngredients.size() + 1) {
			 throw new RuntimeException("Invalid Order");
		 }
	}
	
	private Double calcInvoice(List<String> itemWithIngredients) {
		Map<String, Double> itemRates = bean.getItemRates();
		Map<String, Double> ingredientsPrice = bean.getIngredientsPrice();
        Double itemValue = itemRates.get(itemWithIngredients.get(0));
        Double ingredientsValue = 0.0d;
        if (itemWithIngredients.size() > 1)
            for (int i = 1; i < itemWithIngredients.size(); i++) {
                ingredientsValue = ingredientsValue + ingredientsPrice.get(itemWithIngredients.get(i));
            }
        return itemValue - ingredientsValue;
    }
	public List<String> getAllItemsFromOrder(String order) {
		order=order.trim();
        return Arrays.stream(order.split("(?!,\\s*-),")).map(String::trim).map(String::toLowerCase).collect(Collectors.toList());
    }
	
	private List<String> getIngredientFromOrder(String item) {
     return Arrays.stream(item.split(",")).map(s -> s.replace("-", "")).map(String::trim).collect(Collectors.toList());
 }
}
