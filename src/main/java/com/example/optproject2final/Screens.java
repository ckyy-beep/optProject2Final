package com.example.optproject2final;

public enum Screens {
    LOGIN("login"), MAIN("main");
    private final String fileName;
    public String getFileName() {return fileName;}
    private Screens(String fileName) {
        this.fileName = fileName;
    }
}
