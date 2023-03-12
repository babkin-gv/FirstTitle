package elementGrafics;

import java.awt.*;

public class StringWithPosition {
    private String str;
    private Point position;
    public StringWithPosition(String str, Point position){
        this.str = str;
        this.position = position;
    }
    public String getStr() {
        return str;
    }
    public Point getPosition() {
        return position;
    }
}
