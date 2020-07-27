package com.harshit.test;

import org.junit.Assert;
import org.junit.Test;

import com.harshit.driver.BeveregeFactory;

public class BeveragePriceCalculatorTest {
	
    BeveregeFactory factory = new BeveregeFactory();

    @Test(expected = RuntimeException.class)
    public void testForBlankOrder() {
        String order = "";
        Assert.assertEquals(0.0d, factory.getCostForOrder(order), 0.0d);
    }
    
    @Test(expected = RuntimeException.class)
    public void testInvalidOrder() {
        String order = "ginger,milk";
        Assert.assertEquals(0.0d, factory.getCostForOrder(order), 0.0d);
    }

    @Test
    public void testOrder1() {
        Assert.assertEquals(2.5d, factory.getCostForOrder("Chai,-milk,-water"), 0.0d);
    }

    @Test()
    public void testlOrder2() {
        String order = "Chai,-milk,-water, Mojito,-mint, Banana Smoothie, Strawberry Shake";
        Assert.assertEquals(22.5d, factory.getCostForOrder(order), 0.0d);
    }


    @Test
    public void testForNoExclusions() {
        String order = "Chai,Banana Smoothie";
        Assert.assertEquals(10.0d, factory.getCostForOrder(order), 0.0d);
    }

    @Test(expected = RuntimeException.class)
    public void testWithAllExclusions() {
        String order = "Chai, -Tea, -milk,-sugar, -water";
        Assert.assertEquals(0.0d, factory.getCostForOrder(order), 0.0d);
    }

    @Test(expected = RuntimeException.class)
    public void testDuplicateIngredients() {
        String order = "Chai,  -water,-water, Coffee, Mojito";
        Assert.assertEquals(0.0d, factory.getCostForOrder(order), 0.0d);

    }

    @Test(expected = RuntimeException.class)
    public void testIllegalIngredientInOrder() {
        String order = "Chai,-money,-water, Coffee, Mojito";
        Assert.assertEquals(0.0d, factory.getCostForOrder(order), 0.0d);
    }
}
