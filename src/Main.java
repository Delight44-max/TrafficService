import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrafficService service = new TrafficService();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TRAFFIC APP ===");

        while (true) {
            System.out.println("\n1. Register Vehicle");
            System.out.println("2. Register Officer");
            System.out.println("3. Issue Ticket");
            System.out.println("4. View Vehicle Tickets");
            System.out.println("5. Pay Ticket");
            System.out.println("0. Exit");
            System.out.print("> ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Vehicle id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Model: ");
                        String model = sc.nextLine();
                        System.out.print("Plate: ");
                        String plate = sc.nextLine();
                        System.out.print("Owner id: ");
                        String oid = sc.nextLine();
                        System.out.print("Owner name: ");
                        String oname = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        Owner owner = new Owner();
                        Vehicle v = new Vehicle(id, name, model, plate, owner);
                        service.registerVehicle(v);
                        System.out.println("Registered: " + v);
                    }
                    case "2" -> {
                        System.out.print("Officer id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Rank: ");
                        String rank = sc.nextLine();
                        Officer o = new Officer(id, name, rank);
                        service.registerOfficer(o);
                        System.out.println("Registered: " + o);
                    }
                    case "3" -> {
                        System.out.print("Vehicle id: ");
                        int vid = Integer.parseInt(sc.nextLine());
                        System.out.println("Offences: 0=ONE_WAY, 1=DRUNK_DRIVING, 2=NO_SEAT_BELT, 3=OVER_SPEEDING");
                        int offIdx = Integer.parseInt(sc.nextLine());
                        System.out.print("Officer id: ");
                        int oid = Integer.parseInt(sc.nextLine());
                        Ticket t = service.issueTicket(vid, Offence.values()[offIdx], oid);
                        System.out.println("Issued: " + t);
                    }
                    case "4" -> {
                        System.out.print("Vehicle id: ");
                        int vid = Integer.parseInt(sc.nextLine());
                        List<Ticket> list = service.viewTickets(vid);
                        list.forEach(System.out::println);
                    }
                    case "5" -> {
                        System.out.print("Ticket id: ");
                        int tid = Integer.parseInt(sc.nextLine());
                        service.payTicket(tid);
                        System.out.println("Ticket paid!");
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
