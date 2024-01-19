package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {
    public String fileName;
    public List<String> lines = new ArrayList<>();

    public DataFileReader(String fileName) {
        this.fileName = fileName;
    }

    public void readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch (IOException e) {
            System.err.println("Error while reading file:" + e.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    public List<String> getLines() {
        return lines;
    }
}
