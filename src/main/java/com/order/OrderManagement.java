package com.order;

import com.model.Item;
import com.model.Order;

import java.util.*;

public class OrderManagement {

    static Map<String, List<Order>> customerOrders=new HashMap();
    static Map<String,Double> items = new HashMap();
    static Order ongoingOrder=null;

    static {
        items.put("Espresso", 2.5);
        items.put("Cappuccino", 3.0);
        items.put("Latte", 3.5);
    }
    public static void showMenu() {
        System.out.println("******** Menu ********");
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.println(entry.getKey()+" $"+entry.getValue());
        }
        System.out.println();
    }
    public static void addDrink(Scanner scanner) {
        System.out.print("Enter your name:");
        String name=scanner.next();
        System.out.print("Enter drink name:");
        String drink=scanner.next();
        add(name, drink);
        System.out.println(drink+" was added to "+name+"'s order.");
        System.out.println();
    }

    public static void add(String name, String drink) {
        Double price=getPriceForDrink(drink);
        Item item=new Item(drink,price);
        if(ongoingOrder==null)
        {
            ongoingOrder=new Order();
            ongoingOrder.setName(name);
            List list=new ArrayList<>();
            list.add(item);
            ongoingOrder.setItems(list);
        }else {
            List list=ongoingOrder.getItems();
            list.add(item);
            ongoingOrder.setItems(list);
        }
    }

    public static void removeDrink(Scanner scanner) {
        System.out.print("Enter your name:");
        String name=scanner.next();
        System.out.print("Enter drink name:");
        String drink=scanner.next();
        remove(drink);
        System.out.println(drink+" was removed from "+name+"'s order.");
        System.out.println();
    }

    public static void remove(String drink) {
        List<Item> items= ongoingOrder.getItems();
        if(items.size()>0)
        {
            items.removeIf(t -> drink.equals(t.getDrinkName()));

            ongoingOrder.setItems(items);
        }else {
            System.out.println("No Item ware added in This Order");
        }
    }


    private static Double getPriceForDrink(String drink) {
        return items.get(drink);
    }

    public static void placeOrder(Scanner scanner) {
        System.out.println("Order Receipt:");
        Double totalPrice = order();
        System.out.println("Total : $"+totalPrice);
        System.out.println(ongoingOrder.getName()+"'s order was placed successfully");
        System.out.println("Thank you for shopping with us!");
        System.out.println();
        addOrderToHistory();
    }

    public static Double order() {
        List<Item> entries = ongoingOrder.getItems();
        Double totalPrice=0.0;
        for(Item item:entries)
        {
            System.out.println(item.getDrinkName()+"-$" +item.getPrice());
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public static void addOrderToHistory() {
        List<Order> orders=customerOrders.get(ongoingOrder.getName());
        if(orders!=null)
        {
            orders.add(ongoingOrder);
            customerOrders.put(ongoingOrder.getName(), orders);
        }else {
            List<Order> order=new ArrayList<>();
            order.add(ongoingOrder);
            customerOrders.put(ongoingOrder.getName(), order);
        }
        ongoingOrder=null;
    }

    public static void showHistory(Scanner scanner) {
        System.out.print("Enter your name:");
        String name=scanner.next();
        List<Order> orders=customerOrders.get(name);
        int count=1;
        System.out.print("*****************Order History****************");
        for (Order order : orders)
        {
            System.out.println("Order :"+count++);
            List<Item> items=order.getItems();
            for(Item item:items)
            {
                System.out.println(item.getDrinkName()+" $"+item.getPrice());
            }
        }
    }
}
