package org.example.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullStatisticCreater implements SingleCommand{
    public List<Integer> intsList;
    public List<Double> floatsList;
    public List<String> stringsList;

    public  FullStatisticCreater(List<Integer> intsList, List<Double> floatsList, List<String> stringsList) {
        this.intsList = intsList;
        this.floatsList = floatsList;
        this.stringsList = stringsList;
    }

    @Override
    public void toDo() {
        int sumOfInt = 0;
        double sumOfFloat = 0.;
        for(int item : intsList) {
            sumOfInt += item;
        }
        for(double item : floatsList) {
            sumOfFloat += item;
        }

        //статистика для int
        if(!intsList.isEmpty()) {
            System.out.println("max int variable:" + Collections.max(intsList));
            System.out.println("min int variable:" + Collections.min(intsList));
            System.out.println("sum of int variables:" + sumOfInt);
            System.out.println("average of int variable:" + (double) sumOfInt / intsList.size());
        }

        //статистика для float
        if(!floatsList.isEmpty()) {
            System.out.println("max float variable:" + Collections.max(floatsList));
            System.out.println("min float variable:" + Collections.min(floatsList));
            System.out.println("sum of float variables:" + sumOfFloat);
            System.out.println("average of float variable:" + sumOfFloat / floatsList.size());
        }

        //статистика для string
        if(!stringsList.isEmpty()) {
            //С помощью Collection работало некорректно, стал решать "в обход"
            List<Integer> lineSizes = new ArrayList<>();
            for(String item : stringsList) {
                lineSizes.add(item.length());
            }
            System.out.println("amount of string type variables:" + stringsList.size());
            System.out.println("shortest line size:" + Collections.min(lineSizes));
            System.out.println("longest line size:" + Collections.max(lineSizes));
        }
    }
}
