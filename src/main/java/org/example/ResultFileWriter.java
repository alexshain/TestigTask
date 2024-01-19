package org.example;

import java.util.List;
import java.io.IOException;
import java.io.FileWriter;

public class ResultFileWriter {
    public String fileName;
    private boolean append = false;

    public ResultFileWriter(String fileName, List<String> commands) {
        this.fileName = fileName;
        if(commands.contains("-a")) {
            append = true;
        }
    }

    public void write(List<?> data) {
        try {
            if(!data.isEmpty()) {
                FileWriter writer = new FileWriter(fileName, append);
                for(Object item : data) {
                    writer.write(item + "\n");
                    writer.flush();
                }
                writer.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
