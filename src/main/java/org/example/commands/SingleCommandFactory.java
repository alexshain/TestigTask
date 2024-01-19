package org.example.commands;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;

public class SingleCommandFactory {
    private final Properties properties;
    public List<Integer> intsList;
    public List<Double> floatsList;
    public List<String> stringsList;

    public SingleCommandFactory(List<Integer> intsList, List<Double> floatsList, List<String> stringsList) {
        properties = new Properties();
        try {
            properties.load(new FileReader("/Users/sasha/IdeaProjects/" +
                    "TestingTask/src/main/resources/commands.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.intsList = intsList;
        this.floatsList = floatsList;
        this.stringsList = stringsList;
    }

    public SingleCommand create(String name) throws Exception {
        var fullName = "org.example.commands." + properties.getProperty(name);

        Class<?> targetClass;
        try {
            targetClass = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
            throw new Exception("There is no such command");
        }

        SingleCommand instance;
        try {
            instance =(SingleCommand)targetClass.getDeclaredConstructor(List.class, List.class,
                    List.class).newInstance(intsList, floatsList, stringsList);
        } catch (InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
