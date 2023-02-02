import java.awt.*;
import java.util.ArrayList;

public class Primitivy {

    private ArrayList<Rectangle> lines = new ArrayList<>();
    private ArrayList<StringWithPosition> text = new ArrayList<>();
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
}
