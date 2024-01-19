package org.example;

import org.example.commands.CommandWithArgument;
import org.example.commands.CommandWithArgumentFactory;
import org.example.commands.SingleCommand;
import org.example.commands.SingleCommandFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Executor {
    public List<String> fileNames = new ArrayList<>();
    public List<String> commands = new ArrayList<>();
    public List<Integer> intsList = new ArrayList<>();
    public List<Double> floatsList = new ArrayList<>();
    public List<String> stringsList = new ArrayList<>();
    public String[] pathComponents = {"", ""};

    public void processingTerminalArguments(String[] args) {
        for(String item : args) {
            if(Pattern.compile("^[A-Za-z0-9+_.-]+(.txt)$").matcher(item).matches()){
                fileNames.add(item);
            } else commands.add(item);
        }
    }

    public void readAndSortFileData() {
        for(String fileName : fileNames) {
            DataFileReader fileReader = new DataFileReader(fileName);
            fileReader.readFile();
            Sorter sorter = new Sorter(fileReader.getLines());
            sorter.sort();
            intsList.addAll(sorter.getIntsList());
            floatsList.addAll(sorter.getFloatsList());
            stringsList.addAll(sorter.getStringsList());
        }
    }

    public void optionsProcessing() {
        for(String item : commands) {
            SingleCommandFactory factory = new SingleCommandFactory(intsList, floatsList, stringsList);
            try {
                SingleCommand command = factory.create(item);
                command.toDo();
            } catch (Exception e) {
                //
            }
            CommandWithArgumentFactory withArgumentFactory = new CommandWithArgumentFactory(pathComponents);
            try {
                CommandWithArgument command = withArgumentFactory.create(item);
                pathComponents = command.setFullPath(commands.get(commands.indexOf(item)+1));
            } catch (Exception e) {
                //
            }
        }
    }

    public void writeResult() {
        ResultFileWriter intResult = new ResultFileWriter(String.join("",pathComponents) +"integers.txt", commands);
        ResultFileWriter floatResult = new ResultFileWriter(String.join("",pathComponents) +"floats.txt", commands);
        ResultFileWriter strResult = new ResultFileWriter(String.join("",pathComponents) +"strings.txt", commands);

        intResult.write(intsList);
        floatResult.write(floatsList);
        strResult.write(stringsList);
    }
}
