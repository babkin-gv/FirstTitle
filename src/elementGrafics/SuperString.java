package elementGrafics;

import java.util.ArrayList;
import java.util.List;

public class SuperString {
    private List<String> keys;
    private List<String> bodys;
    private List<String> names;
    private List<Integer> numbers;

    public SuperString() {
        keys = new ArrayList<>();//Ключ - имя объекта в виде, например, "tk"
        bodys = new ArrayList<>();//Значение, например, 20,70
        names = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    public void add(String key, String body){
        keys.add(key);
        bodys.add(body);
    }
    public boolean containsKey(String key){
        return keys.contains(key);
    }
    public String getBody(String key){
        int index = keys.indexOf(key);
        return bodys.get(index);
    }
    public String getNextKeyBy(String name){//Поиск конкретного объекта по имени в хранилище SuperSnring
        String keyBody = "";
        String resultBody = "";
        int index = 0;
        if (names.contains(name)) {//Обращение уже было
            int indexOfNames = names.indexOf(name);
            index = numbers.get(indexOfNames);
            if (index < keys.size()) {
                keyBody = keys.get(index);
                numbers.remove(indexOfNames);
                numbers.add(indexOfNames, index + 1);
            } else {
                return "";
            }
        } else {//В первый раз
            //Найти key начинающийся с name
            boolean ok = false;
            for (String temp : keys){
                if (temp.indexOf(name.toLowerCase()) == 0){
                    ok = true;
                    keyBody = temp;
                    break;
                }
            }
            if (ok) {
                names.add(name);
                numbers.add(index+1);
            }
        }
        //resultBody = bodys.get(index);
        return keyBody + "~" + bodys.get(index);
    }
}
