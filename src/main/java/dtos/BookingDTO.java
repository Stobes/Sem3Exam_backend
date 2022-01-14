/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Booking;
import entities.WashingAssistant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class BookingDTO {
    private long id;
    private String date;
    private String time;
    private int duration;
    private List<WashingAssistantDTO> washerList;
    
    public BookingDTO() {
    }
    
    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.date = booking.getDate();
        this.time = booking.getTime();
        this.duration = booking.getDuration();
        this.washerList = booking.getWashersDTOList(booking.getWasherList());
    }
    
    public BookingDTO(String date, String time, int duration, List<WashingAssistantDTO> washerList) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.washerList = washerList;
    }

    public List<WashingAssistant> getWashingAssistantList(List<WashingAssistantDTO> washers) {
        ArrayList<WashingAssistant> list = new ArrayList<>();
        if(washers != null) {
            for(WashingAssistantDTO w : washers) {
                list.add(new WashingAssistant(w));
            }
        }
        return list;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<WashingAssistantDTO> getWasherList() {
        return washerList;
    }

    public void setWasherList(List<WashingAssistantDTO> washerList) {
        this.washerList = washerList;
    }
    
    
    
    
    
    
}
