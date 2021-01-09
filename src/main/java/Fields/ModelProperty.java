package Fields;

import java.awt.*;

public class ModelProperty  extends Field{
    private int propertyPrice;
    private int mortgage;
    private  int rent;
    private String owner;


    public void setRent(int rent) {
        this.rent = rent;
    }



    public String get_owner() {
        return owner;
    }

    public void set_owner(String _owner) {
        this.owner = owner;
    }


    protected ModelProperty(String name, Color backgroundColor, int propertyPrice, int mortgage) {
        super(name, backgroundColor);
        this.propertyPrice = propertyPrice;
        this.mortgage = mortgage;
    }
    public int get_propertyPrice() {
        return propertyPrice;
    }


    public String toString() {
        return "Property";
    }

}
