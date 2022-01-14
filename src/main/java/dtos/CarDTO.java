/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Car;
import entities.User;

/**
 *
 * @author 45319
 */
public class CarDTO {
    private String registrationNumber;
    private String brand;
    private String make;
    private int year;
    private User user;
    
    public CarDTO (){
    }
    
    public CarDTO(Car car) {
        this.registrationNumber = car.getRegistrationNumber();
        this.brand = car.getBrand();
        this.make = car.getMake();
        this.year = car.getYear();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
