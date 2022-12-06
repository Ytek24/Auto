package backend.customer_manager;

public class Company extends Customer {

    private String name;
    private long siretNumber;

    public Company(String name, long siretNumber) {
        this.name = name;
        this.siretNumber = siretNumber;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSiretNumber() {
        return siretNumber;
    }

    public void setSiretNumber(long siretNumber) {
        this.siretNumber = siretNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ID=" + getID() +
                "\nname='" + name + '\'' +
                ",\nsiretNumber=" + siretNumber +
                "\n}";
    }

    @Override
    public String getIdentifier() {
        return name;
    }
}
