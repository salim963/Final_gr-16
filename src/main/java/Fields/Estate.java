package Fields;

import java.awt.*;

public class Estate extends Field {
    private int[] rent;
    private int propertyPrice;
    private String Owner;
    public Estate(String name, Color backgroundColor, int propertyPrice, int[] rent) {
        super(name, backgroundColor);
        this.propertyPrice=propertyPrice;
        this.rent = rent.clone();
    }


    public int[] getRent() {
        return rent;
    }
    public int getPropertyPrice() {
        return propertyPrice;
    }
    public String getOwner() {
        return Owner;
    }
    public void setOwner(String owner) {
        Owner = owner;
    }
    @Override
    public String toString() {
        return "Estate";
    }
}
