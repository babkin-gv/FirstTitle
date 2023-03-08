package elementGrafics;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

public class Supervisor {
    private SuperString superString;

    public Supervisor() {
        this.superString = new SuperString();
    }

    public SuperString analyzer(List<String> parm) {
        String message = "";
        for (String str : parm) {
            if (str.indexOf("//") != 0) {
                String[] arr = str.replaceAll(" ", "").toLowerCase().split(";");
                if (!str.substring(str.length() - 1, str.length()).equals(";")) {
                    message = "Ошибка в строке " + str;
                    superString.add("message", "Ошибка в строке " + str);
                    break;
                }
                for (String leks : arr) {
                    String[] body = leks.split("=");
                    if (body.length != 2) {
                        message = "Ошибка в строке " + leks;
                        superString.add("message", "Ошибка в строке " + leks);
                        break;
                    }
                    superString.add(body[0], body[1]);
                }
                int uuu = 0;
            }
        }
        return superString;
    }
}
