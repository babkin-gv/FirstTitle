import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Primitivy primitivy = new Primitivy();
        primitivy.DrawLine(new Point(100, 250), new Point(200, 150));
        primitivy.DrawLine(new Point(250, 250), new Point(50, 50));
        primitivy.DrawCircle(new Point(100, 100), 70);
        primitivy.DrawString(new Point(150, 150), "Proba Proba Проверка");
        MyPanel myPanel = new MyPanel();
        myPanel.setLines(primitivy.getLines());
        myPanel.setText(primitivy.getText());
        myPanel.setCircles(primitivy.getCircles());
        myPanel.repaint();
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
}
