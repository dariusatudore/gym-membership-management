package gymmanagement;

// generic interface used to calculate the price of memberships
public interface Calculator <T extends Number> {
    double calculatePrice(T clubID);
}
