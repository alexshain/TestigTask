package org.example;

public class Main {
    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.processingTerminalArguments(args);
        executor.readAndSortFileData();
        executor.optionsProcessing();
        executor.writeResult();
    }
}