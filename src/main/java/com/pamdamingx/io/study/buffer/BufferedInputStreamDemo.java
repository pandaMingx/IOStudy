package com.pamdamingx.io.study.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        String filePath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/ccc.txt";
        try (
                FileInputStream fis = new FileInputStream(filePath);
                BufferedInputStream bis = new BufferedInputStream(fis)
        ) {
            // 2 读取
            int data = 0;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
