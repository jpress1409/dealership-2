package com.pluralsight;

public class Main {

    public static void main(String[] args) {
        boolean loop;
        UserInterface ui = new UserInterface();
        while(loop = true){
            ui.display(loop);
        }
    }
}