package Fields;

import java.awt.*;

public class Tax extends Field{
    private int rent;

    public Tax(String name, Color backgroundColor, int rent) {
        super(name, backgroundColor);
        this.rent = rent;
    }

    public int getrent() {
        return rent;
    }

    public String toString() {
        return "Tax";
    }
}
