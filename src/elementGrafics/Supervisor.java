package elementGrafics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

public class Supervisor {
    private SuperString superString;

    public Supervisor() {
        this.superString = new SuperString();
    }

    public SuperString analyzer(List<String> parm) {//анализатор входного текста из файла init.txt
        String message = "";
        for (String str : parm) {
            if (str.indexOf("//") != 0) {//Пропустить комментарии
                String[] arr = str.replaceAll(" ", "").toLowerCase().split(";");
                if (!str.substring(str.length() - 1, str.length()).equals(";")) {
                    message = "Ошибка в строке " + str;//Если строка не заканчивается символом ";"
                    superString.add("message", "Ошибка в строке " + str);
                    break;
                }
                for (String leks : arr) {
                    String[] body = leks.split("=");
                    if (body.length != 2) {//Если пропущен знак =
                        message = "Ошибка в строке " + leks;
                        superString.add("message", "Ошибка в строке " + leks);
                        break;
                    }
                    superString.add(body[0], body[1]);//Получаем список лексем исходных данных
                }
                int uuu = 0;
            }
        }
        return superString;
    }
    public void calculate(String name){
        String fromSuper = superString.getNextKeyBy("TK");//Получить очередной объект по имени
        if (!fromSuper.equals("")) {
            String[] contain = fromSuper.split("~");
            String[] xy = contain[1].split(",");
            int x = 0;
            int y = 0;
            if (xy.length == 2) {//Обрабатываем точку, заданную координатами tk1~20,26
                x = Integer.parseInt(xy[0]);
                y = Integer.parseInt(xy[1]);
                putTk(new Point(x, y), contain[0]);
            }else {
                if (contain[1].contains("+")) {//Обработка точки, заданной приращением
                } else {
                    return "Ошибка в строке " + fromSuper;
                }
            }
        }

    }
}
