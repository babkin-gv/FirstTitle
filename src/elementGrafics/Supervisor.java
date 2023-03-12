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

    public SuperString analyzer(List<String> parm) {//���������� �������� ������ �� ����� init.txt
        String message = "";
        for (String str : parm) {
            if (str.indexOf("//") != 0) {//���������� �����������
                String[] arr = str.replaceAll(" ", "").toLowerCase().split(";");
                if (!str.substring(str.length() - 1, str.length()).equals(";")) {
                    message = "������ � ������ " + str;//���� ������ �� ������������� �������� ";"
                    superString.add("message", "������ � ������ " + str);
                    break;
                }
                for (String leks : arr) {
                    String[] body = leks.split("=");
                    if (body.length != 2) {//���� �������� ���� =
                        message = "������ � ������ " + leks;
                        superString.add("message", "������ � ������ " + leks);
                        break;
                    }
                    superString.add(body[0], body[1]);//�������� ������ ������ �������� ������
                }
                int uuu = 0;
            }
        }
        return superString;
    }
    public void calculate(String name){
        String fromSuper = superString.getNextKeyBy("TK");//�������� ��������� ������ �� �����
        if (!fromSuper.equals("")) {
            String[] contain = fromSuper.split("~");
            String[] xy = contain[1].split(",");
            int x = 0;
            int y = 0;
            if (xy.length == 2) {//������������ �����, �������� ������������ tk1~20,26
                x = Integer.parseInt(xy[0]);
                y = Integer.parseInt(xy[1]);
                putTk(new Point(x, y), contain[0]);
            }else {
                if (contain[1].contains("+")) {//��������� �����, �������� �����������
                } else {
                    return "������ � ������ " + fromSuper;
                }
            }
        }

    }
}
