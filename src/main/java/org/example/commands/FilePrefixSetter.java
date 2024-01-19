package org.example.commands;

public class FilePrefixSetter implements CommandWithArgument{
    public String[] fullPath;

    public FilePrefixSetter(String[] fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public String[] setFullPath(String name) {
        if(fullPath[1].length() == 0) {
            fullPath[1] = name;
        } else fullPath[1] += name;
        return fullPath;
    }
}
