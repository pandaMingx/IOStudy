package com.pamdamingx.io.study.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    /**
     * FileInputStream: FilterInputStream本身简单地覆盖了所有InputStream的方法。
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/abc.txt";
//        demo1(filePath);
//        demo2(filePath);
        demo3(filePath);
    }

    /**
     * 单字节读取
     * read(): 从该输入流读取下一个数据字节
     * @param filePath
     */
    public static void demo1(String filePath){
        try(FileInputStream fileInputStream = new FileInputStream(filePath)){
            int data;
            while ((data = fileInputStream.read()) != -1){
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一次读取多个字节
     *
     * read(byte[] b)：从该输入流读取最多 byte.length个字节的数据到字节数组。
     * @param filePath
     */
    public static void demo2(String filePath){
        try(FileInputStream fileInputStream = new FileInputStream(filePath)){
            byte[] buf = new byte[3]; // 大小为3的缓存区
            int count = 0;
            while((count = fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf, 0, count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *一次读取多个字节
     *
     * read(byte[] b, int off, int len)
     * 从该输入流读取最多 len字节的数据到字节数组。
     * @param filePath
     */
    public static void demo3(String filePath){
        try(FileInputStream fileInputStream = new FileInputStream(filePath)){
            byte[] buf = new byte[3]; // 大小为3的缓存区
            int count = 0;
            while((count = fileInputStream.read(buf,0,buf.length)) != -1){
                System.out.println(new String(buf, 0, count));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
