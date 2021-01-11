package Fields;

import java.awt.*;

public class Estate extends ModelProperty {


    public int[] getRent() {
        return rent;
    }

    private int[] rent;
    private int amountOfHouses;

    public void setRent(int[] rent) {
        this.rent = rent;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    public void setAmountOfHouses(int amountOfHouses) {
        this.amountOfHouses = amountOfHouses;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    private int housePrice;


    public Estate(String name, Color backgroundColor, int propertyPrice, int[] rent, int mortgage) {
        super(name, backgroundColor, propertyPrice, propertyPrice/2);
        this.rent = rent.clone();
    }


    @Override
    public String toString() {
        return "Estate";
    }
}
