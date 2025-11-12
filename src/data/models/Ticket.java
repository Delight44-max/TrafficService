package data.models;

public class Ticket {
    private static int counter = 1;
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private Officer officer;
    private boolean hasPaid;

    public Ticket(Vehicle vehicle, Offence offence, Officer officer) {
        this.id = counter++;
        this.vehicle = vehicle;
        this.offence = offence;
        this.officer = officer;
        this.hasPaid = false;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Offence getOffence() {
        return offence;
    }

    public Officer getOfficer() {
        return officer;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void pay() {
        this.hasPaid = true;
    }
}
