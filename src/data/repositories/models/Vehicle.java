package data.repositories.models;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int id;
    private String make;
    private String model;
    private Owner owner;
    private List<Ticket> tickets = new ArrayList<>();

    public Vehicle(int id, String make, String model, Owner owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "data.models.Vehicle{" + "id=" + id + ", make=" + make + ", model=" + model + ", plateNumber=" + ", owner=" + owner + (owner != null ? owner.getName() : "No data.models.Owner") +
                '}';
    }


    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}