package com.model;

public class Item {
    String drinkName;
    double price;

    public Item(String dName, double price)
    {
        this.drinkName=dName;
        this.price=price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
