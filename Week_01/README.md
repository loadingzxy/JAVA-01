学习笔记

20210104
todo  第一课必做作业  

1、自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后 自己分析一下对应的字节码，有问题群里讨论。

（选做）  todo

2、自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内 容是一个 Hello.class 文件所有字节(x=255-x)处理后的文件。文件群里提供。

（必做） /src/myclassloader.class

```java
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @program: JAVA-01
 * @description: 第一课 第二题
 * @author: zhxy
 * @create: 2021-01-13 23:58
 **/
public class MyClassLoader extends ClassLoader {

    private static final String filePath = "D:\\java\\JAVA-01\\Week_01\\src\\Hello.xlass";

    public static void main(String[] args) {
        try {
            Object o = new MyClassLoader().findClass("Hello").newInstance();
            Method m = o.getClass().getMethod("hello");
            m.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义classloader
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = new byte[0];
        try {
             data = readFile(filePath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defineClass(name, data, 0, data.length);

    }

    private byte[] readFile(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        byte[] bytes = new byte[1024];
        byte[] readByte = null;
        try{
            baos = new ByteArrayOutputStream();
            fis = new FileInputStream(file);
            int length;
            while ((length = fis.read(bytes))!=-1){
                baos.write(bytes,0,length);
            }
            readByte = baos.toByteArray();
            byte b;
            for (int i = 0; i < readByte.length; i++) {
                b = (byte) (255 - readByte[i]);
                readByte[i] = b;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fis.close();
            baos.close();
        }

        return readByte;
    }
}

```

3、画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的 关系。
(必做)

Xmx ：为jvm运行过程中分配的最大内存，比如-Xms500m，表示jvm进程最多只能够占用500M内存

Xms ： 为jvm启动时分配的内存，比如-Xms200m，表示分配200M

Xmn : 新生代大小

Xss: 为jvm启动的每个线程分配的内存大小，默认JDK1.4中是256K，JDK1.5+中是1M

Meta ：XX:MetaspaceSize、-XX:MaxMetaspaceSize 分别设置元空间最小大小与最大大小（Java8以后）



![Image text](https://raw.githubusercontent.com/loadingzxy/JAVA-01/main/Week_01/jvm.png)



20210104 
 第二课必做作业

1、本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况
这个地方由于时间关系听的不是很细致，暂时先放上一张可视化的jvm分析进行整理

首先是jmap

![Image text](https://raw.githubusercontent.com/loadingzxy/JAVA-01/main/Week_01/jamp.jpg)

其次是可视化的两个界面

![Image text](https://raw.githubusercontent.com/loadingzxy/JAVA-01/main/Week_01/jvm.png)
![Image text](https://raw.githubusercontent.com/loadingzxy/JAVA-01/main/Week_01/jvm.png)


