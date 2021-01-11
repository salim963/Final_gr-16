package Fields;

import java.awt.*;

public class ModelProperty extends Field{
    private int propertyPrice;
    private int mortgage;
    private int rent;
    private String owner;

    protected ModelProperty(String name, Color backgroundColor, int propertyPrice, int mortgage) {
        super(name, backgroundColor);
        this.propertyPrice = propertyPrice;
        this.mortgage = mortgage;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getRent() {
        return rent;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }


    public String toString() {
        return "Property";
    }

}
