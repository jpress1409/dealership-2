package com.pluralsight;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean loop;
        UserInterface ui = new UserInterface();
        while(loop = true){
            ui.display(loop);
        }
    }
}