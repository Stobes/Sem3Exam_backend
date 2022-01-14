package facades;

import dtos.BookingDTO;
import dtos.BookingListDTO;
import dtos.UserDTO;
import dtos.WasherListDTO;
import dtos.WashingAssistantDTO;
import entities.Booking;
import entities.Car;
import entities.Role;
import entities.User;
import entities.WashingAssistant;
import errorhandling.API_Exception;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public UserDTO create(UserDTO u) throws Exception {
        EntityManager em = getEntityManager();
        User user = null;
        try {
            user = new User(u);
            em.getTransaction().begin();
            if(em.find( User.class, u.getUserName())!=null) {
                throw new API_Exception("Username already exists");
            }
            Role role = em.find(Role.class, "user");
            user.addRole(role);
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new UserDTO(user);
    }
    
    public WasherListDTO getAllWashers() throws Exception {
        EntityManager em = getEntityManager();
        List<WashingAssistant> washers;
        TypedQuery<WashingAssistant> query = em.createQuery("SELECT wa FROM WashingAssistant wa", WashingAssistant.class);
        washers = query.getResultList();
        return new WasherListDTO(washers);
    }
    
    public BookingListDTO getAllBookings(String userName) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> bookings;
        TypedQuery<Booking> query = em.createQuery("SELECT b FROM Booking b JOIN b.car c WHERE c.user.userName = :userName", Booking.class);
        query.setParameter("userName", userName);
        bookings = query.getResultList();
        return new BookingListDTO(bookings);
    }
    
    public BookingDTO createBookingWithWashers(BookingDTO bDTO) throws Exception {
        EntityManager em = getEntityManager();
        Booking booking = null;
        try {
            booking = new Booking(bDTO);
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BookingDTO(booking);
    }
    
    
    public WashingAssistantDTO createWasher(WashingAssistantDTO wDTO) throws Exception {
        EntityManager em = getEntityManager();
        WashingAssistant washer = null;
        try {
            washer = new WashingAssistant(wDTO);
            em.getTransaction().begin();
            em.persist(washer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new WashingAssistantDTO(washer);
    }
    public BookingDTO deleteBooking(long id) throws Exception {
        EntityManager em = getEntityManager();
        Booking booking;
        try {
            em.getTransaction().begin();
            booking = em.find(Booking.class, id);
            if (booking == null){
                throw new Exception("could not delete, no id found");
            }
            em.remove(booking);
            em.getTransaction().commit();
            return new BookingDTO(booking);
        } finally {
            em.close();
        }
    }
}