/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.BookingDTO;
import dtos.WashingAssistantDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 45319
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "WashingAssistant.deleteAllRows", query = "DELETE from WashingAssistant")
})

@Table(name = "washers")
public class WashingAssistant implements Serializable {
    
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", length = 25)
  private int id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "primary_language")
  private String pLanguage;
  
  @Column(name = "years_of_erxperience")
  private int yearsOfExperience;
  
  @Column(name = "price_pr_hr")
  private int pricePrHour;
  
  @ManyToMany(mappedBy = "washerList",  cascade = CascadeType.PERSIST)
  private List<Booking> bookingList;
  
  public WashingAssistant() {}
  
  public WashingAssistant(WashingAssistantDTO wDTO) {
      //this.id = wDTO.getId();
      this.name = wDTO.getName();
      this.pLanguage = wDTO.getpLanguage();
      this.yearsOfExperience = wDTO.getYearsOfExperience();
      this.pricePrHour = wDTO.getPricePrHour();
      //this.bookingList = wDTO.getBookingsList(wDTO.getBookingList());
  }

    public WashingAssistant(String name, String pLanguage, int yearsOfExperience, int pricePrHour) {
        this.name = name;
        this.pLanguage = pLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePrHour = pricePrHour;
        this.bookingList = new ArrayList<>();
    }
  
  
    public List<Booking> getWasherList() {
        return bookingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpLanguage() {
        return pLanguage;
    }

    public void setpLanguage(String pLanguage) {
        this.pLanguage = pLanguage;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getPricePrHour() {
        return pricePrHour;
    }

    public void setPricePrHour(int pricePrHour) {
        this.pricePrHour = pricePrHour;
    }

    

    public void setWasherList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
  
    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }
  
}
