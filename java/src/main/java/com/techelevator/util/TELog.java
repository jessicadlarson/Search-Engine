package com.techelevator.util;

import java.io.*;

public class TELog {

    public static void log(String message){
        try{
            String path = "logs/search.log";
            File logFile = new File(path);
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(logFile, true))) {
                printWriter.append(message + "\n");
                printWriter.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        } catch(TELogException e){
            e.getMessage();
        }
    }
}
