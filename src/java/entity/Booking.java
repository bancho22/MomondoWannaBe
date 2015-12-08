/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mato
 */
@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightID, ReserveeName, ReservePhone, ReserveEmail;
    private int numberOfSeats;
    private ArrayList<String> passengers;

    public Long getId() {
        return id;
    }

    public Booking(String flightID, String ReserveeName, String ReservePhone, String ReserveEmail, int numberOfSeats, ArrayList<String> passengers) {
        this.flightID = flightID;
        this.ReserveeName = ReserveeName;
        this.ReservePhone = ReservePhone;
        this.ReserveEmail = ReserveEmail;
        this.numberOfSeats = numberOfSeats;
        this.passengers = passengers;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getReserveeName() {
        return ReserveeName;
    }

    public void setReserveeName(String ReserveeName) {
        this.ReserveeName = ReserveeName;
    }

    public String getReservePhone() {
        return ReservePhone;
    }

    public void setReservePhone(String ReservePhone) {
        this.ReservePhone = ReservePhone;
    }

    public String getReserveEmail() {
        return ReserveEmail;
    }

    public void setReserveEmail(String ReserveEmail) {
        this.ReserveEmail = ReserveEmail;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public ArrayList<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<String> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Booking{" + "flightID=" + flightID + ", ReserveeName=" + ReserveeName + ", ReservePhone=" + ReservePhone + ", ReserveEmail=" + ReserveEmail + ", numberOfSeats=" + numberOfSeats + ", passengers=" + passengers + '}';
    }

}