package org.example;

public class Main {
    public static void main(String[] args) {
        Executor exceptor = new Executor();
        exceptor.processingTerminalArguments(args);
        exceptor.readAndSortFileData();
        exceptor.optionsProcessing();
        exceptor.writeResult();
    }
}