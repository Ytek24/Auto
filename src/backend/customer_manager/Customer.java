package backend.customer_manager;

public abstract class Customer {

    private static int INCREASE = 0;
    private int ID;

    public Customer() {
        this.ID = INCREASE;
        INCREASE++;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                '}';
    }

    public String getIdentifier()
    {
        return String.valueOf(ID);
    }
}
