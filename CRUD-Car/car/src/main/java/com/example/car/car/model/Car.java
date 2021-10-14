package com.example.car.car.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public int id;
    String model;
    String manufacturer;
    int price;
    int sales;
    String photo;


    public Car() {
    }


    public Car(int id, String model, String manufacturer, int price, int sales, String photo) {
           this.id = id;
           this.model = model;
           this.manufacturer = manufacturer;
           this.price = price;
           this.sales = sales;
           this.photo = photo;
    }


public int getId() {
       return id;
}


public void setId(int id) {
       this.id = id;
}


public String getModel() {
       return model;
}


public void setModel(String model) {
       this.model = model;
}


public String getManufacturer() {
       return manufacturer;
}


public void setManufacturer(String manufacturer) {
       this.manufacturer = manufacturer;
}


public int getPrice() {
       return price;
}


public void setPrice(int price) {
       this.price = price;
}


public int getSales() {
       return sales;
}


public void setSales(int sales) {
       this.sales = sales;
}


public String getPhoto() {
       return photo;
}


public void setPhoto(String photo) {
       this.photo = photo;
}
   
    

    
    
    
}
