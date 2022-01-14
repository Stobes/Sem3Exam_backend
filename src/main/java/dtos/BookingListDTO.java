/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Booking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class BookingListDTO {
    
    List<BookingDTO> all = new ArrayList<>();
    
    public BookingListDTO(List<Booking> bEntities) {
        bEntities.forEach((b) -> {
            all.add(new BookingDTO(b));
        });
    }
    
    public List<BookingDTO> getAll() {
        return all;
    }
}
