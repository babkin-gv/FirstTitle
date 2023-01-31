import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel myPanel = new MyPanel();
        myPanel.line(new Point(100, 200), new Point(200, 150));
        myPanel.repaint();
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
}
