package data.repositories.models;

public class Ticket {
    private static int counter = 1;
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private Officer officer;
    private boolean paid;

    public Ticket(Vehicle vehicle, Offence offence, Officer officer) {
        this.id = counter++;
        this.vehicle = vehicle;
        this.offence = offence;
        this.officer = officer;
        this.paid = false;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Offence getOffence() {
        return offence;
    }

    public void setOffence(Offence offence) {
        this.offence = offence;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void pay() {
        this.paid = true;
    }

    public void setId(int id) {
        this.id = id;

    }
}
