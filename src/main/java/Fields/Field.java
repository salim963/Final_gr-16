package Fields;

import java.awt.*;

public class Field {

    private String name;
    private Color backgroundColor;

    public Field(String name, Color backgroundColor){
        this.name = name;
        this.backgroundColor = backgroundColor;
    }

    public String get_name() {
        return name;
    }



}
