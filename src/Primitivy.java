import java.awt.*;
import java.util.ArrayList;

public class Primitivy {

    private ArrayList<Rectangle> lines = new ArrayList<>();
    private ArrayList<StringWithPosition> text = new ArrayList<>();
    private ArrayList<Rectangle> circles = new ArrayList<>();
    public void DrawCircle(Point center, int radius)
    {
        circles.add(new Rectangle(center.x, center.y, radius, radius));
    }
    public void DrawLine(Point start, Point end){
        lines.add(new Rectangle(start, new Dimension(end.x, end.y)));
    }
    public void DrawString(Point start, String parm)
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
