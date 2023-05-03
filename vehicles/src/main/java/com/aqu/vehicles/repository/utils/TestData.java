package com.aqu.vehicles.repository.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestData {
    public static String GetTestData() {

       String fileName = "e:\\dev\\java\\vehicles_aq\\vehicles\\src\\test\\java\\com\\aqu\\vehicles\\spisokMashin.json";
       Path path = Paths.get(fileName);
        try {
//            return  Files.readAllLines(path).toString();
//            byte[] bytes = Files.readAllBytes(path);
            List<String> allLines = Files.readAllLines(path);
            StringBuilder stringBuilder = new StringBuilder();
            for (String line:
                 allLines) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
