public class Customer {
    private int id;
    private int ordertime;
    private int traveltime;

    static int customerCount = 0;

    public Customer(int ordertime, int traveltime) {
        this.id = ++customerCount;
        this.ordertime = ordertime;
        this.traveltime = traveltime;
    }

    public int getId() {
        return id;
    }

    public int getOrderTime() {
        return ordertime;
    }

    public int getTravelTime() {
        return traveltime;
    }

    @Override
    public String toString() {
        return "C" + id + " (Order: " + ordertime + ", Travel: " + traveltime + ")";
    }
}