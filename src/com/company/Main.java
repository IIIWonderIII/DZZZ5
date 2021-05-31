package com.company;

public class Main {

    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.load("file.csv");
        appData.save("new.csv");
    }
}
