package rest;

import booking_engine.BookEngine;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Airline;
import entity.Booking;
import exceptions.BookingException;
import facades.AirlineFacade;
import facades.BookingFacade;
import facades.UserFacade;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author Mato
 */
@Path("booking")
@RolesAllowed("User")
public class BookingApi {

    

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String getSomething() {
            return "{\"message\" : \"This message was delivered via a REST call accesible by only authenticated USERS\"}";
        }

        BookingFacade bf = new BookingFacade();
        AirlineFacade af = new AirlineFacade();
        UserFacade uf = new UserFacade();
        BookEngine be = new BookEngine();

        @POST
        @Consumes("application/json")
        @Produces("application/json")
        public Response registerBooking(String json) throws BookingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {
            JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
            entity.User reservee = uf.getUserByUserName(obj.get("username").getAsString());
            Airline airline = af.getAirlineByName(obj.get("airlineName").getAsString());
            Gson g = new Gson();
            entity.Booking b = g.fromJson(json, Booking.class);
            b.setReservee(reservee);
            b.setAirline(airline);
            
            JsonObject response = be.book(b);
            if (response.get("code").getAsInt() == 200) {
                bf.addBooking(b);
            } else {
                throw new BookingException(response.toString());
            }

            return Response.status(Response.Status.OK).entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
        }
}
