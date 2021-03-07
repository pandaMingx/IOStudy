# IOStudy
Java IO 流学习笔记
## 1 什么是流
内存与存储设备之间传输数据的通道。
## 2 流的分类
### 2.1 按方向
- 输入流：将存储设备中的内容读取到内存中；
- 输出流：将内存中的内容写入到存储设备中。
### 2.2 按单位
- 字节流：以字节为单位，可以读取所有数据；
- 字符流：以字符为单位，只能读取文本数据。  
>字节(Byte)是计量单位，表示数据量多少，是计算机信息技术用于计量存储容量的一种计量单位，通常情况下一字节等于八位。
>字符(Character)计算机中使用的字母、数字、字和符号，比如'A'、'B'、'$'、'&'等。
### 2.3 按功能
- 节点流：具有实际传输数据的读写功能；
- 过滤流：在节点流的基础之上增强的功能。

## 3 字节流抽象类
- InputStream  
这个抽象类是表示输入字节流的所有类的超类。
需要定义InputStream子类的应用InputStream必须始终提供一种返回输入的下一个字节的方法。
- OutputStream  
这个抽象类是表示字节输出流的所有类的超类。 输出流接收输出字节并将其发送到某个接收器。
需要定义OutputStream子类的应用OutputStream必须至少提供一个写入一个字节输出的方法。

## 4.文件输入输出流
### 4.1 FileInputStream输入流

(1) read() 单字节读取
```
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
```
（2）read(byte[] b) 一次读取多个字节
```
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
```
(3) read(byte[] b, int off, int len)
```
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
```

### 4.2 FileOutputStream文件输出流
```
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
```

### 4.3 文件输入输出流案例
```
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
```
## 5 字节缓冲流
缓冲流：BufferedInputStream/ BufferedOutputStream
- 提高IO效率，减少访问磁盘次数
- 数据存储在缓冲区中，flush是将缓冲区的内容写入文件中，也可以直接close
### 5.1 BufferedInputStream
```
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
```
### 5.2 BufferedOutputStream
```
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
```

## 6 对象流
ObjectOutputStream / ObjectInputStream

- 增强了缓冲区功能
- 增强了读写8种基本数据类型和字符串的功能
- 增强了读写对象的功能  
readObject() 从流中读取一个对象  
writeObject(Object obj) 向流中写入一个对象  
使用流传输对象的过程称为序列化、反序列化

### 6.1 使用ObjectOutputStream实现对象的序列化

```
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
```

### 6.2 使用ObjectInputStream实现对象的反序列化
```
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
```

### 6.3 注意事项
- 1.某个类要想序列化必须实现Serializable接口
- 2.序列化类中对象属性要求实现Serializable接口
- 3.序列化版本号ID，保证序列化的类和反序列化的类是同一个类
- 4.使用transient修饰属性，这个属性就不能序列化
- 5.静态属性不能序列化
- 6.序列化多个对象，可以借助集合来实现

