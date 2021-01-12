package Fields;

import java.awt.*;

public class Brewery extends Field {
    private int rent;

    public Brewery(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name, backgroundColor);
        this.rent=rent;
    }

    public String toString() {
        return "Brewery";
    }
}
