package com.pamdamingx.io.study.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

    public static void main(String[] args) {
        // 1.创建对象流
        try (
                FileOutputStream fos = new FileOutputStream("/Users/pandamig/IdeaProjects/Study/IOStudy/src/main/resources/student.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            // 2.序列化
            Student student = new Student();
            student.setAge(14);
            student.setName("hello");

            oos.writeObject(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
