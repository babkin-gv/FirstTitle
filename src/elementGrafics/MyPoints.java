package elementGrafics;

import java.awt.*;

public class MyPoints {
    private int x;
    private int y;
    private String name;

    public MyPoints(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public Point getPosition() {
        return new Point(x, y);
    }
    //public static boolean operator !=(MyPoints obj1, MyPoints obj2){
    //}
    //public static boolean operator ==(MyPoints obj1, MyPoints obj2){
    //}
    //public static boolean operator +(MyPoints obj1, MyPoints obj2){
    //}
    //public static boolean operator -(MyPoints obj1, MyPoints obj2){
    //}
    public static MyPoints sub(MyPoints obj1, MyPoints obj2){
        return new MyPoints("", obj1.x - obj2.x,
                obj1.y - obj2.y);
    }
    public static int orientation(MyPoints p0, MyPoints p1, MyPoints p2)
    {
        MyPoints a = sub(p1, p0);
        MyPoints b = sub(p2, p0);
        return a.x * b.y - b.x * a.y;
    }
    private double length(MyPoints obj)
    {
        double x = this.x - obj.x;
        double y = this.y - obj.y;
        return Math.sqrt(x * x + y * y);
    }
    private double lengthTwo(MyPoints obj1, MyPoints obj2)
    {
        double x = obj1.x - obj2.x;
        double y = obj1.y- obj2.y;
        return Math.sqrt(x * x + y * y);
    }
    private double subOfLen(MyPoints obj)
    {
        double my = lengthTwo(new MyPoints("", 0, 0), this);
        double ob = lengthTwo(new MyPoints("", 0, 0), obj);
        return my - ob;
    }
    public String getName() {
        return name;
    }
}
