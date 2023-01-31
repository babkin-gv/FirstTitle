import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1560,700);
    }
    private int x = 0;
    private int y = 0;
    private int width = 100;
    private int height = 100;
    private  Point from = new Point(0, 0);
    private  Point to = new Point(0, 0);
    public void line(Point from, Point to){
        this.from = from;
        lineTo(to);
    }
    public void lineTo(Point to){
        this.to = to;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        //g.drawString("This is my custom Panel!",10,20);
        g.drawLine(from.x, from.y, to.x, to.y);
    }
}
