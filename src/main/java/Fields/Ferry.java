package Fields;

import java.awt.*;

public class Ferry extends ModelProperty {
    private int rent;

    public Ferry(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name, backgroundColor, propertyPrice, propertyPrice/2);
        rent = Math.max(rent, 0);
    }

    public int getrent() {
        return rent;
    }
    @Override
    public String toString() {
        return "Ferry";
    }
}
