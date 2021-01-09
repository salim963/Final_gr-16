package Fields;

import java.awt.*;

public class Brewery extends ModelProperty {
    private int rent;

    public Brewery(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name, backgroundColor, propertyPrice, propertyPrice/2);
        rent = Math.max(rent, 0);
    }

    public String toString() {
        return "Brewery";
    }
}
