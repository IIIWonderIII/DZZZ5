package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AppData {

    private String[] headers;
    private int[][] data = new int[2][3];

    public void load(String path) {
        String separator = ";";
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            headers = lines.remove(0).split(separator);

            for (int i = 0; i < lines.size(); i++) {
                String[] dataFromLine = lines.get(i).split(separator);
                for (int j = 0; j < dataFromLine.length; j++) {
                    data[i][j] = Integer.parseInt(dataFromLine[j]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path) {
        String result = String.join(";", headers);

        for (int i = 0; i < data.length; i++) {
            String line = "";
            for (int j = 0; j < data[i].length; j++) {
                line += data[i][j] + ";";
            }
            result += "\n" + line.substring(0, line.length()-1);
        }

        try {
            Files.writeString(Path.of(path), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
