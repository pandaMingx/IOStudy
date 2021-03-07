package com.pamdamingx.io.study.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String filePath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/ccc.txt";
        try(FileOutputStream out = new FileOutputStream(filePath)){
            out.write("hello word!".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
