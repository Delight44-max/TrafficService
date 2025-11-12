package data.models;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int id;
    private String make;
    private String model;
    private String plateNumber;
    private Owner owner;
    private List<Ticket> tickets = new ArrayList<>();

    public Vehicle(int id, String make, String model, String plateNumber, Owner owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.plateNumber = plateNumber;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Owner getOwner() {
        return owner;
    }

@Override
    public String toString() {
        return "data.models.Vehicle{" + "id=" + id + ", make=" + make + ", model=" + model + ", plateNumber=" + plateNumber + ", owner=" + owner + (owner != null ? owner.getName() : "No data.models.Owner") +
                '}';
}




}
