package com.saucedemo.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.management.RuntimeErrorException;

import com.google.gson.Gson;
import com.saucedemo.pojos.Config;

public class ConfigHelper {
    public static Config getConfig() {
        var gson = new Gson();
        try {
            var config = gson.fromJson(new FileReader("config.json"), Config.class);
            return config;
        } catch (FileNotFoundException ex) {
            throw new RuntimeErrorException(new Error(ex.getMessage()));
        }
    }
}