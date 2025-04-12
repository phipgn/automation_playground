package com.saucedemo.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CsvHelper {
    public static Iterator<Object[]> readCsv(String filePath) throws IOException {
        var testData = new ArrayList<Object[]>();
        var reader = new BufferedReader(new FileReader(filePath));
        String line;
        reader.readLine();
        while((line = reader.readLine()) != null) {
            var parts = line.split(",", -1);
            testData.add(parts);
        }
        reader.close();
        return testData.iterator();
    }
}
