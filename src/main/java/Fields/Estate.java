package Fields;

import java.awt.*;

public class Estate extends Field {


    public int[] getRent() {
        return rent;
    }

    public void setRent(int[] rent) {
        this.rent = rent;
    }

    private int[] rent;

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    private int propertyPrice;

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    private String Owner;


    public Estate(String name, Color backgroundColor, int propertyPrice, int[] rent) {
        super(name, backgroundColor);
        this.propertyPrice=propertyPrice;
        this.rent = rent.clone();
    }


    @Override
    public String toString() {
        return "Estate";
    }
}
