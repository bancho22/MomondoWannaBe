/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import exceptions.NoFlightsFoundException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import search_engine.SearchEngine;

/**
 *
 * @author Bancho
 */
@Path("flightinfo")
public class FlightSearchApi {
    
    private SearchEngine searchEngine;
        
    public FlightSearchApi(){
        searchEngine = new SearchEngine();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{numTickets}")
    public Response getFlightResults(@PathParam("from") String from, @PathParam("date") String date, @PathParam("numTickets") String numTickets) throws NoFlightsFoundException{
        
        List<String> flightsByAirlines = searchEngine.findFlights(from, date, numTickets);
        
        if(flightsByAirlines.isEmpty()){
            throw new NoFlightsFoundException();
        }
        
        JsonArray jsonFlights = new JsonArray();
        for (String flight : flightsByAirlines) {
            jsonFlights.add(new JsonParser().parse(flight).getAsJsonObject());
        }
        
        return Response.status(Response.Status.OK).entity(jsonFlights.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numTickets}")
    public Response getFlightResults2(@PathParam("from") String from, @PathParam("from") String to, @PathParam("date") String date, @PathParam("numTickets") String numTickets) throws NoFlightsFoundException{
        
        List<String> flightsByAirlines = searchEngine.findFlights(from, to, date, numTickets);
        
        if(flightsByAirlines.isEmpty()){
            throw new NoFlightsFoundException();
        }
        
        JsonArray jsonFlights = new JsonArray();
        for (String flight : flightsByAirlines) {
            jsonFlights.add(new JsonParser().parse(flight).getAsJsonObject());
        }
        
        return Response.status(Response.Status.OK).entity(jsonFlights.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
