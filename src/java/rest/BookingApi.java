package rest;

import com.google.gson.Gson;
import entity.Booking;
import facades.BookingFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Mato
 */
public class BookingApi {

    @Path("booking")
    @RolesAllowed("User")
    public class User {

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String getSomething() {
            return "{\"message\" : \"This message was delivered via a REST call accesible by only authenticated USERS\"}";
        }

        BookingFacade bf = new BookingFacade();

        @POST
        @Consumes("application/json")
        @Produces("application/json")
        public String registerBooking(String json) throws NoSuchAlgorithmException, InvalidKeySpecException {

            Gson g = new Gson();
            entity.Booking b = g.fromJson(json, Booking.class);

            
            bf.addBooking(b);
            return g.toJson(b);
        }
    }
}

