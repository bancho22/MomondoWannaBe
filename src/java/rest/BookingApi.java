package rest;

import booking_engine.BookEngine;
import com.google.gson.Gson;
import entity.Booking;
import exceptions.BookingError;
import facades.BookingFacade;
import java.io.IOException;
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
        BookEngine be = new BookEngine();

        @POST
        @Consumes("application/json")
        @Produces("application/json")
        public String registerBooking(String json) throws BookingError, NoSuchAlgorithmException, InvalidKeySpecException, IOException {

            Gson g = new Gson();
            entity.Booking b = g.fromJson(json, Booking.class);
            boolean isValid = be.Book(b);
            if (isValid) {
                bf.addBooking(b);
            } else {
                throw new BookingError("Invalid booking");
            }

            return g.toJson(b);
        }
    }
}
