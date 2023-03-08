package elementGrafics;

import java.awt.*;
import java.util.List;

public class MakeGrafic {
    private Primitives primitives;
    private final int headerHeigth = 40;//0;//
    private final int headerWidth = 15;//0;//
    private final int ShagSetki = 5;
    private final int zasechka = 5;

    private String[] nadpisX;
    private String[] nadpisY;

    public MakeGrafic(Primitives primitives,
                      String[] nadpisX, String[] nadpisY, int width, int height) {
        this.primitives = primitives;
        this.nadpisX = nadpisX;
        this.nadpisY = nadpisY;
        _height = height - headerHeigth;
        _width = width - headerWidth;
        kY = _height / _width;
    }

    private final int poleX = 70;
    private final int poleY = 0;
    private int kY;
    private int deltaX;
    private int deltaY;
    private int _height;
    private int _width;

    private void coordinates(String[] nadpisX, String[] nadpisY)
    {
        //ось Y
        primitives.drawLine(new Point (poleX, poleX * kY), new Point (poleX, _height - poleX * kY));
        //ось X
        primitives.drawLine(new Point(_width - poleX, _height - poleX * kY-17 ),
                new Point (poleX, _height - poleX * kY-17 ));
        //ось X вывод символов
        for (int i = 0; i < nadpisX.length; i++)
        {
            primitives.drawLine(new Point(poleX + i * deltaX, _height - poleX * kY - zasechka-17),
                    new Point(poleX + i * deltaX, _height - poleX * kY + zasechka-17));
            primitives.drawString(new Point(poleX + i * deltaX, _height - poleX * kY), nadpisX[i]);
        }
        //ось Y вывод символов
        for (int i = 0; i < nadpisY.length; i++)
        //for (int i = scaleCountY + 1; i > 0; i--)
        {
            //primitives.drawLine(new Point(poleX + zasechka, (i + 1) * deltaY + poleX * kY),
            //        new Point(poleX - zasechka, (i + 1) * deltaY + poleX * kY));
            //primitives.drawString(new Point(poleX - 20, (i + 1) * deltaY + poleX * kY - 9),
            //        nadpisY[nadpisY.length - i - 1]);//
            primitives.drawLine(new Point(poleX + zasechka, (i + 1) * deltaY + poleX * kY),
                    new Point(poleX - zasechka, (i + 1) * deltaY + poleX * kY));
            primitives.drawString(new Point(poleX - 20, (i + 0) * deltaY + poleX * kY+30),
                    nadpisY[nadpisY.length - i - 1]);//
        }
        //PutSector(new Point(10, 25), 5, 60, 30, true);
        //PutSector(new Point(25, 25), 5, 60, 120, true);
        //PutSector(new Point(40, 25), 5, 60, 210, true);
        //PutSector(new Point(55, 25), 5, 60, 300, true);
        //
        //PutSector(new Point(10, 10), 5, 60, 30, false);
        //PutSector(new Point(25, 10), 5, 60, 120, false);
        //PutSector(new Point(40, 10), 5, 60, 210, false);
        //PutSector(new Point(55, 10), 5, 60, 300, false);

    }
    private void coordinates1(String[] nadpisX, String[] nadpisY)
    {
        deltaX = (_width - 2 * poleX) / (nadpisX.length);
        deltaY = ((_height - 2 * poleX * kY) / (nadpisY.length));// * kY;

        //рисование горизонтальных линий
        for (int i = 0; i < nadpisY.length / ShagSetki; i++)
        {
            int sgn = (int)Math.signum(i);
            primitives.drawLine(new Point(poleX, (i) * deltaY * ShagSetki + poleX * kY + deltaY),
                            new Point(_width - poleX, (i) * deltaY * ShagSetki + poleX * kY + deltaY));
        }
        //рисование вертикальных линий
        for (int i = 0; i < nadpisX.length / ShagSetki; i++)
        {
            primitives.drawLine(new Point((i + 1) * deltaX * ShagSetki + poleX, poleX * kY),
                            new Point((i + 1) * deltaX * ShagSetki + poleX, _height - poleX * kY));
        }
    }
    public String graphic(SuperString superString){
        coordinates1(nadpisX, nadpisY);
        coordinates(nadpisX, nadpisY);
        String fromSuper = "";
        do {
            fromSuper = superString.getNextKeyBy("TK");
            if (!fromSuper.equals("")) {
                String[] contain = fromSuper.split("~");
                String[] xy = contain[1].split(",");
                if (xy.length!= 2){
                    return "Ошибка в строке " + fromSuper;
                }
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                putTk(new Point(x, y), contain[0]);
            }
        } while (!fromSuper.equals(""));
        putTk(new Point(34, 21), "t1");
        return "";
    }
    public void putTk(Point coord, String name)
    {
        double constMax = Double.MAX_VALUE;// - 2 * Utility.epsilon;
        double constMin = Double.MIN_VALUE;// + 2 * Utility.epsilon;
        //if (Math.Abs(coord.Y) < constMin)
        //{
        //    coord.Y = 0;
        //}
        if (Math.abs(coord.y) > constMax)
        {
            coord.y = nadpisY.length;
        }
        if (Math.abs(coord.x) > constMax)
        {
            coord.x = nadpisX.length;
        }
        //if (Math.Abs(coord.X) < constMin)
        //{
        //    coord.X = 0;
        //}
        Point coordCurrent = mashtab(coord);
        primitives.drawLine(new Point(coordCurrent.x + zasechka, coordCurrent.y),
                new Point(coordCurrent.x - zasechka, coordCurrent.y));
        primitives.drawLine(new Point(coordCurrent.x, coordCurrent.y + zasechka),
                new Point(coordCurrent.x, coordCurrent.y - zasechka));
        primitives.drawString(coordCurrent, name);
    }
    private Point mashtab(Point parm)
    {
        return new Point(parm.x * deltaX + poleX , _height - parm.y * deltaY - poleX * kY-17);
    }
}
