package org.example.commands;

import java.io.File;

public class NewPathSetter implements CommandWithArgument{
    public String[] fullPath;

    public NewPathSetter(String[] fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public String[] setFullPath(String name) {
        if((new File(name)).exists()) {
            fullPath[0] = name;
            return fullPath;
        } else {
            System.out.println("There is no such directory");
            return fullPath;
        }
    }
}
