/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.WashingAssistant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class WasherListDTO {
    
    List<WashingAssistantDTO> all = new ArrayList<>();
    
    public WasherListDTO(List<WashingAssistant> waEntities) {
        waEntities.forEach((wa) -> {
            all.add(new WashingAssistantDTO(wa));
        });
    }
    
    public List<WashingAssistantDTO> getAll() {
        return all;
    }
}
