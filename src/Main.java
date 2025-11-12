import data.models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrafficService service = new TrafficService();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TRAFFIC APP ===");

        while (true) {
            System.out.println("\n1. Register data.models.Vehicle");
            System.out.println("2. Register data.models.Officer");
            System.out.println("3. Issue data.models.Ticket");
            System.out.println("4. View data.models.Vehicle Tickets");
            System.out.println("5. Pay data.models.Ticket");
            System.out.println("0. Exit");
            System.out.print("> ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("data.models.Vehicle id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Model: ");
                        String model = sc.nextLine();
                        System.out.print("Plate: ");
                        String plate = sc.nextLine();
                        System.out.print("data.models.Owner id: ");
                        String oid = sc.nextLine();
                        System.out.print("data.models.Owner name: ");
                        String ownerName = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        Owner owner = new Owner();
                        Vehicle vehicle = new Vehicle(id, name, model, plate, owner);
                        service.registerVehicle(vehicle);
                        System.out.println("Registered: " + vehicle);
                    }
                    case "2" -> {
                        System.out.print("data.models.Officer id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Rank: ");
                        String rank = sc.nextLine();
                        Officer officer = new Officer(id, name, rank);
                        service.registerOfficer(officer);
                        System.out.println("Registered: " + officer);
                    }
                    case "3" -> {
                        System.out.print("data.models.Vehicle id: ");
                        int vehicleId = Integer.parseInt(sc.nextLine());
                        System.out.println("Offences: 0=ONE_WAY, 1=DRUNK_DRIVING, 2=NO_SEAT_BELT, 3=OVER_SPEEDING");
                        int offenceIdx = Integer.parseInt(sc.nextLine());
                        System.out.print("data.models.Officer id: ");
                        int ownerId = Integer.parseInt(sc.nextLine());
                        Ticket ticket = service.issueTicket(vehicleId, Offence.values()[offenceIdx], ownerId);
                        System.out.println("Issued: " + ticket);
                    }
                    case "4" -> {
                        System.out.print("data.models.Vehicle id: ");
                        int vehicleId = Integer.parseInt(sc.nextLine());
                        List<Ticket> list = service.viewTickets(vehicleId);
                        list.forEach(System.out::println);
                    }
                    case "5" -> {
                        System.out.print("data.models.Ticket id: ");
                        int ticketId = Integer.parseInt(sc.nextLine());
                        service.payTicket(ticketId);
                        System.out.println("data.models.Ticket paid!");
                    }
                    case "0" -> {
                        System.out.println("Bye!");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
