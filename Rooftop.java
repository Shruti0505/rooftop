import java.util.*;

public class Rooftop {
    private List<DeliveryDriver> drivers;
    private List<Customer> customers;

    public Rooftop(int numDrivers) {
        drivers = new ArrayList<>();
        customers = new ArrayList<>();
        for (int i = 0; i < numDrivers; i++) {
            drivers.add(new DeliveryDriver());
        }
    }

    private void addCustomer(int orderTime, int travelTime) {
        // ensure we add the customer in sorted order based on order time
        Customer newCustomer = new Customer(orderTime, travelTime);
        int i = 0;
        while (i < customers.size() && customers.get(i).getOrderTime() < orderTime) {
            i++;
        }
        customers.add(i, newCustomer);
    }

    public void simulateDelivery() {
        //for assigning
        for (Customer customer : customers) {
            boolean assigned = false;
            for (DeliveryDriver driver : drivers) {
                if (driver.isAvailable(customer.getOrderTime())) {
                    driver.setAvailableAt(customer.getOrderTime() + customer.getTravelTime());
                    System.out.println("C" + customer.getId() + " - D" + driver.getId());
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                System.out.println("C" + customer.getId() + " - No Food :-(");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read m (number of customers) and n (number of drivers)
        System.out.println("Enter the number of customers and drivers seperated by comma (c,d)");
        String[] firstLine = scanner.nextLine().split(",");
        int m = Integer.parseInt(firstLine[0].trim());
        int n = Integer.parseInt(firstLine[1].trim());

        Rooftop rooftop = new Rooftop(n);

        // Read m customers
        for (int i = 0; i < m; i++) {
            String[] customerLine = scanner.nextLine().split(",");
            int orderTime = Integer.parseInt(customerLine[0].trim());
            int travelTime = Integer.parseInt(customerLine[1].trim());
            rooftop.addCustomer(orderTime, travelTime);
        }

        rooftop.simulateDelivery();
        scanner.close();
    }

}
