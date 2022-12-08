package backend.order_manager;

public enum State
{
    IN_PROGRESS("IN_PROGRESS"),
    APPROUVED("APPROUVED"),
    DELIVERED("DELIVERED");


    public final String label;
    private State(String label)
    {
        this.label = label;
    }

}