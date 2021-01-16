package Fields;

import java.awt.*;

public class Ferry extends Field {
    private int rent;
    private int propertyPrice;
    private String Owner;

    public Ferry(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name, backgroundColor);
        this.propertyPrice=propertyPrice;
        this.rent= rent;


    }
    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public int getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Ferry";
    }
}
