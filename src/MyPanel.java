import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1560,700);
    }
    private ArrayList<Rectangle> lines = new ArrayList<>();
    private ArrayList<StringWithPosition> text = new ArrayList<>();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        //g.drawString("This is my custom Panel!",10,20);
        for (Rectangle rectangle:lines) {
            g.drawLine(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        for (StringWithPosition sp:text){
            g.drawString(sp.getStr(), sp.getPosition().x, sp.getPosition().y);
        }
    }
    public void setLines(ArrayList<Rectangle> lines) {
        this.lines = lines;
    }
    public void setText(ArrayList<StringWithPosition> text) {
        this.text = text;
    }
}
