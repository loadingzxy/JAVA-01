学习笔记

20210104
todo  第一课必做作业  

1、自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后 自己分析一下对应的字节码，有问题群里讨论。

（选做）  todo

2、自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内 容是一个 Hello.class 文件所有字节(x=255-x)处理后的文件。文件群里提供。

（必做） /src/myclassloader.class

3、画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的 关系。
(必做)

Xmx ：为jvm运行过程中分配的最大内存，比如-Xms500m，表示jvm进程最多只能够占用500M内存

Xms ： 为jvm启动时分配的内存，比如-Xms200m，表示分配200M

Xmn : 新生代大小

Xss: 为jvm启动的每个线程分配的内存大小，默认JDK1.4中是256K，JDK1.5+中是1M

Meta ：XX:MetaspaceSize、-XX:MaxMetaspaceSize 分别设置元空间最小大小与最大大小（Java8以后）
 
todo 放图



20210104 
todo 第二课必做作业

1、本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况


