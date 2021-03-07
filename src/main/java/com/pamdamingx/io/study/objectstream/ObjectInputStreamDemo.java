package com.pamdamingx.io.study.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/student.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Student stu = (Student) ois.readObject();
            System.out.println(stu.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
