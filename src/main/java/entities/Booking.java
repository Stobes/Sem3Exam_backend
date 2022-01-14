/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.BookingDTO;
import dtos.WashingAssistantDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 45319
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Booking.deleteAllRows", query = "DELETE from Booking")
})

@Table(name = "bookings")
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;
    
    @Column(name = "duration")
    private int duration;
    
    @ManyToMany
    private List<WashingAssistant> washerList;
    
    
    @ManyToOne
    private Car car;
    
    public Booking() {
    }
    
    public Booking (String date, String time, int duration) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.washerList = new ArrayList<>();
    }
    
    public Booking (BookingDTO bDTO) {
        this.id = bDTO.getId();
        this.date = bDTO.getDate();
        this.time = bDTO.getTime();
        this.duration = bDTO.getDuration();
        this.washerList = bDTO.getWashingAssistantList(bDTO.getWasherList());
    }
    
    public List<WashingAssistantDTO> getWashersDTOList (List<WashingAssistant> washers) {
        ArrayList<WashingAssistantDTO> list = new ArrayList<>();
        if (washers != null) {
            for(WashingAssistant w : washers) {
                list.add(new WashingAssistantDTO(w));
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

    public List<WashingAssistant> getWasherList() {
        return washerList;
    }

    public void setWasherList(List<WashingAssistant> washerList) {
        this.washerList = washerList;
    }
    
    public void addWasher(WashingAssistant washer) {
        washerList.add(washer);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
    
    
    
    
}
