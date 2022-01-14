/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.CarDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 45319
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Car.deleteAllRows", query = "DELETE from Car")
})
@Table(name = "cars")
public class Car implements Serializable {
    
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "registration_number", length = 25)
  private String registrationNumber;
  
  @Column(name = "brand")
  private String brand;
  
  @Column(name = "make")
  private String make;
  
  @Column(name = "year")
  private int year;
   
  @ManyToOne
  @JoinColumn(name = "user_name", referencedColumnName = "user_name")
  private User user;
  
  
  @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
  @OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST)
  private List<Booking> bookingList;
  
  public Car (){
  }
  
  public Car(String registrationNumber, String brand, String make, int year) {
      this.registrationNumber = registrationNumber;
      this.brand = brand;
      this.make = make;
      this.year = year;
      this.bookingList = new ArrayList<>();
  }
  
  public Car(CarDTO cDTO) {
      this.registrationNumber = cDTO.getRegistrationNumber();
      this.brand = cDTO.getBrand();
      this.make = cDTO.getMake();
      this.year = cDTO.getYear();
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
    
    public void addUser(User user) {
        this.user = user;
    }

    public List<Booking> getBooking() {
        return bookingList;
    }

    public void setBooking(List<Booking> booking) {
        this.bookingList = booking;
    }
    
    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }
    
    
  
  
  
  
}
