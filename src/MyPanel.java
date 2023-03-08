import elementGrafics.StringWithPosition;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    private final int width;
    private final int height;
    public MyPanel(int width, int height) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.width = width;
        this.height = height;
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    private ArrayList<Rectangle> lines = new ArrayList<>();
    private ArrayList<StringWithPosition> text = new ArrayList<>();
    private ArrayList<Rectangle> circles = new ArrayList<>();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle rectangle:lines) {
            g.drawLine(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        for (StringWithPosition sp:text){
            g.drawString(sp.getStr(), sp.getPosition().x, sp.getPosition().y);
        }
        for (Rectangle rectangle: circles){
            g.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }
    public void setLines(ArrayList<Rectangle> lines) {
        this.lines = lines;
    }
    public void setText(ArrayList<StringWithPosition> text) {
        this.text = text;
    }

    public void setCircles(ArrayList<Rectangle> circles) {
        this.circles = circles;
    }
}
