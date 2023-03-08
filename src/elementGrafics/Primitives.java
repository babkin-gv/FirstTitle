package elementGrafics;

import java.awt.*;
import java.util.ArrayList;

public class Primitives {
    private ArrayList<Rectangle> lines = new ArrayList<>();
    private ArrayList<StringWithPosition> text = new ArrayList<>();
    private ArrayList<Rectangle> circles = new ArrayList<>();
    public void drawCircle(Point center, int radius)
    {
        circles.add(new Rectangle(center.x, center.y, radius, radius));
    }
    public void drawEllipse(Point center, int radiusX, int radiusY){
        circles.add(new Rectangle(center.x, center.y, radiusX, radiusY));
    }
    public void drawLine(Point start, Point end){
        lines.add(new Rectangle(start, new Dimension(end.x, end.y)));
    }
    public void drawString(Point start, String parm)
    {
        text.add(new StringWithPosition(parm, start));
    }
    public ArrayList<Rectangle> getLines() {
        return lines;
    }
    public ArrayList<StringWithPosition> getText() {
        return text;
    }

    public ArrayList<Rectangle> getCircles() {
        return circles;
    }
}

