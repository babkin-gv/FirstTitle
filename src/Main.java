import elementGrafics.MakeGrafic;
import elementGrafics.Primitives;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int width = 1560;
        int height = 800;
        String[] nadpisX = new String[] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"
        };
        String[] nadpisY = new String[] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
        };
        System.out.println("Hello world!");

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Primitivy primitivy = new Primitivy();
        //primitivy.drawLine(new Point(100, 250), new Point(200, 150));
        //primitivy.drawLine(new Point(250, 250), new Point(50, 50));
        //primitivy.drawCircle(new Point(100, 100), 70);
        //primitivy.drawEllipse(new Point(320, 100), 165, 95);
        //primitivy.drawString(new Point(150, 150), "Proba Proba Проверка");
        MyPanel myPanel = new MyPanel(width, height);
        elementGrafics.Primitives primitives = new Primitives();
        elementGrafics.MakeGrafic makeGrafic = new MakeGrafic(primitives,
                nadpisX, nadpisY, width, height);
        makeGrafic.Test();
        myPanel.setLines(primitives.getLines());
        myPanel.setText(primitives.getText());
        myPanel.setCircles(primitives.getCircles());
        myPanel.repaint();
        readFile("D:\\Working\\2023\\Projects\\TechnProgr\\FirstTitle\\init.txt");
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
    private static void readFile(String path) throws IOException {
        Reader reader1 = new FileReader( path );
        BufferedReader buffReader1 = new BufferedReader( reader1 );
        while (buffReader1.ready()) {
            String line1 = buffReader1.readLine().trim().replaceAll(" ", "");
            String[] arr = line1.split(",");
        }
    }
}
