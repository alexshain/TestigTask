package org.example.commands;

import java.util.List;

public class ShortStatisticCreater implements SingleCommand{
    public List<String> intsList;
    public List<String> floatsList;
    public List<String> stringsList;

    public  ShortStatisticCreater(List<String> intsList, List<String> floatsList, List<String> stringsList) {
        this.intsList = intsList;
        this.floatsList = floatsList;
        this.stringsList = stringsList;
    }

    @Override
    public void toDo() {
        System.out.println("int type variables:" + intsList.size());
        System.out.println("float type variables:" + floatsList.size());
        System.out.println("string type variables:" + stringsList.size());
    }
}
