package org.example.commands;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandWithArgumentFactory {
    private final Properties properties;
    public String[] fullPath;

    public CommandWithArgumentFactory(String[] fullPath) {
        properties = new Properties();
        try {
            properties.load(new FileReader("/Users/sasha/IdeaProjects/" +
                    "TestingTask/src/main/resources/commands.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.fullPath = fullPath;
    }

    public CommandWithArgument create(String name) throws Exception {
        var fullName = "org.example.commands." + properties.getProperty(name);

        Class<?> targetClass;
        try {
            targetClass = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
            throw new Exception("There is no such command");
        }

        CommandWithArgument instance;
        try {
            instance =(CommandWithArgument) targetClass.getDeclaredConstructor(String[].class).newInstance((Object)fullPath);
        } catch (InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
