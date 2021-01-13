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
