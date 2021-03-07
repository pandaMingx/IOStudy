package com.pamdamingx.io.study.file;

import java.io.*;

public class FileCopyDemo {
    public static void main(String[] args) {
        // 1.创建流，文件输入流，文件输出流
        String orgPath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/ccc.txt";
        String tarPath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/ddd.txt";

        try (
                FileInputStream in = new FileInputStream(orgPath);
                FileOutputStream out = new FileOutputStream(tarPath);
        ) {
       // 2 边读边写
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = in.read(buf)) != -1) {
                out.write(buf, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
