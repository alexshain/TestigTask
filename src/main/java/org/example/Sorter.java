package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sorter {
    public List<String> lines;
    public List<Integer> intsList = new ArrayList<>();
    public List<Double> floatsList = new ArrayList<>();
    public List<String> stringsList = new ArrayList<>();

    public Sorter(List<String> lines) {
        this.lines = lines;
    }

    public int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("String " + str + " cannot be converted to int type");
            return 0;//если число не соответствует типу, то заменяем его на 0
        }
    }

    public double stringToFloat(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("String " + str + " cannot be converted to float type");
            return 0.;//если число не соответствует типу, то заменяем его на 0
        }
    }

    public void sort() {
        Pattern intPattern = Pattern.compile("\\d+");
        Pattern strPattern = Pattern.compile("\\D+");
        Pattern floatPattern = Pattern.compile("^-?\\d+(.\\d+)(E\\d+)?(E-\\d+)?$");

        for(String item : lines) {
            if(intPattern.matcher(item).matches()) {
                intsList.add(stringToInt(item));
            } else if (strPattern.matcher(item).matches()) {
                stringsList.add(item);
            } else if (floatPattern.matcher(item).matches()) {
                floatsList.add(stringToFloat(item));
            }
        }
    }

    public List<Integer> getIntsList() {
        return intsList;
    }

    public List<Double> getFloatsList() {
        return floatsList;
    }

    public List<String> getStringsList() {
        return stringsList;
    }
}

