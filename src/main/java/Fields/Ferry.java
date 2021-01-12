package Fields;

import java.awt.*;

public class Ferry extends Field {
    private int rent;
    private int propertyPrice;

    public Ferry(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name, backgroundColor);
        this.propertyPrice=propertyPrice;
        this.rent= rent;

    }

    public int getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Ferry";
    }
}
