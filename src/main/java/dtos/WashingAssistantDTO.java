/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Booking;
import entities.WashingAssistant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class WashingAssistantDTO {
    private int id;
    private String name;
    private String pLanguage;
    private int yearsOfExperience;
    private int pricePrHour;
    private List<BookingDTO> bookingList;
    
    public WashingAssistantDTO() {}
    
    public WashingAssistantDTO(WashingAssistant wAssistant) {
        this.id = wAssistant.getId();
        this.name = wAssistant.getName();
        this.pLanguage = wAssistant.getpLanguage();
        this.yearsOfExperience = wAssistant.getYearsOfExperience();
        this.pricePrHour = wAssistant.getPricePrHour();
//        this.bookingList = wAssistant.getBookingDTOList(wAssistant.getWasherList());
    }
    
    public List<Booking> getBookingsList (List<BookingDTO> bookings) {
        ArrayList<Booking> list = new ArrayList<>();
        if (bookings != null) {
            for(BookingDTO b : bookings) {
                list.add(new Booking(b));
            }
        }
        return list;
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

    public List<BookingDTO> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<BookingDTO> bookingList) {
        this.bookingList = bookingList;
    }
    
    
    
}
