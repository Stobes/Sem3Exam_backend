/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.BookingListDTO;
import dtos.UserDTO;
import dtos.WashingAssistantDTO;
import entities.Booking;
import entities.Car;
import entities.Role;
import entities.User;
import entities.WashingAssistant;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author 45319
 */





public class UserFacadeTest {
    
    private static EntityManagerFactory emf;
    private static UserFacade facade; 
    
    User u1,u2,u3;

    
    public UserFacadeTest() {}
    
    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = UserFacade.getUserFacade(emf);
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
            Role userRole = new Role("user");
            Role adminRole = new Role("admin");
            Booking booking1 = new Booking("14-01-22", "04:47", 30);
            Car car = new Car("321#123", "Mercer", "somthing", 2010);
            
            u2 = new User("user2", "test321");
            u3 = new User("user3", "test3");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Booking.deleteAllRows").executeUpdate();
            em.createNamedQuery("Car.deleteAllRows").executeUpdate();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            em.createNamedQuery("Role.deleteAllRows").executeUpdate();
            em.createNamedQuery("WashingAssistant.deleteAllRows").executeUpdate();
            car.setUser(u2);
            car.addBooking(booking1);
            booking1.setCar(car);
            em.persist(userRole);
            em.persist(adminRole);
            em.persist(u2);
            em.persist(u3);
            em.persist(car);
            em.persist(booking1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }  
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
//        emf.close();
    }
    
    @Test
    void getAllBookings() throws Exception {
        System.out.println("Testing getAllBookings(String userName)");
        BookingListDTO actual = facade.getAllBookings(u2.getUserName());
        int expected = 1;
        assertEquals(expected, actual.getAll().size());
    }
    
    @Test
    void createWasher() throws Exception {
        System.out.println("Testing createWasher(WashingAssistantDTO wDTO)");
        WashingAssistant washer = new WashingAssistant("test", "test", 5, 5);
        WashingAssistantDTO washer1 = new WashingAssistantDTO(washer);
        String actual = facade.createWasher(washer1).getName();
        String expected = washer.getName();
        assertEquals(expected, actual);
        
    }
    }
    
    
    

