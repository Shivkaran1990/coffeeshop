package com.order;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderManagementTest {

    @BeforeAll
    public void setUpBeforeEachTest() throws Exception {
        System.out.println("before class");
        OrderManagement.items.put("Espresso", 2.5);
        OrderManagement.items.put("Cappuccino", 3.0);
        OrderManagement.items.put("Latte", 3.5);

    }

    @Test
    void drinkAddTest() {
        OrderManagement.add("Shiv","Latte");
        Assertions.assertEquals("Shiv", OrderManagement.ongoingOrder.getName());
        Assertions.assertEquals(1, OrderManagement.ongoingOrder.getItems().size());
    }

    @Test
    void drinkRemoveTest() {
        OrderManagement.remove("Latte");
        Assertions.assertEquals(0, OrderManagement.ongoingOrder.getItems().size());
    }
    @Test
    void addMultipleDrinkTest() {
        OrderManagement.add("Shiv","Latte");
        OrderManagement.add("Shiv","Cappuccino");
        Assertions.assertEquals("Shiv", OrderManagement.ongoingOrder.getName());
        Assertions.assertEquals(2, OrderManagement.ongoingOrder.getItems().size());
    }

    @Test
    void placeOrderTest() {
        OrderManagement.order();
        Assertions.assertEquals(null, OrderManagement.ongoingOrder);
    }
    @Test
    void customerOrderHistoryTest() {
        OrderManagement.order();
        Assertions.assertEquals(1, OrderManagement.customerOrders.size());
    }
}
