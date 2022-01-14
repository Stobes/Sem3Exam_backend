package utils;


import entities.Booking;
import entities.Car;
import entities.Role;
import entities.User;
import entities.WashingAssistant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
    Car car = new Car("321#123", "Mercer", "somthing", 2010);
    User user = new User("userTest", "test123");
    User admin = new User("admin", "test321123");
    Booking booking = new Booking("13-01-2022", "14:30", 30);
    WashingAssistant washer1 = new WashingAssistant("Consuala", "something", 5, 60);
    WashingAssistant washer2 = new WashingAssistant("Gitte", "something", 4, 45);
    
    
    //WashingAssistant washer1 = new WashingAssistant("Consuala", )
    //if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
    //  throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    booking.addWasher(washer1);
    booking.addWasher(washer2);
    user.addRole(userRole);
    car.setUser(user);
    car.addBooking(booking);
    booking.setCar(car);
    admin.addRole(adminRole);

    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(car);
    em.persist(washer1);
    em.persist(washer2);
    em.persist(booking);
    
    em.persist(admin);
    em.getTransaction().commit();
    
   
  }

}
