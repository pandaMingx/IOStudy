package com.pamdamingx.io.study.buffer;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) {
        String tarPath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/eee.txt";
        try (
                FileOutputStream fos = new FileOutputStream(tarPath);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            // 写入文件
            for (int i = 0; i < 10; i++) {
                bos.write("hello".getBytes());// 写入8k缓冲区
                bos.flush(); // 刷新到硬盘
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
