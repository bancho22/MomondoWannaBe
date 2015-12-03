package facades;

import deploy.DeploymentConfiguration;
import entity.Booking;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BookingFacade {

    private EntityManagerFactory emf;

    public BookingFacade() {
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /*
     Return the Roles if users could be authenticated, otherwise null
     */
   

    public Booking addBooking(Booking booking){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return booking;
    }
    
   
    public Booking getBookingByUser(String lName){
        EntityManager em = getEntityManager();
        Booking booking = null;
        try{
            Query query = em.createQuery("SELECT b FROM Booking b WHERE b.lName = :lName");
            query.setParameter("lName", lName);
            booking = (Booking) query.getSingleResult();
        }catch(NoResultException ex){
            //return null
        }finally{
            em.close();
        }
        return booking;
    }
    
    
    
   
}
