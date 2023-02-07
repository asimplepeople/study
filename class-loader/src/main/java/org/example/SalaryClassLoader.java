package org.example;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.SecureClassLoader;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/1/14
 */
public class SalaryClassLoader extends SecureClassLoader {
    private String classPath;

    public SalaryClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name){
        String filePath = this.classPath + name.replace(".", "\\").concat(".myclass");
        FileInputStream fis;
        ByteArrayBuffer ba = new ByteArrayBuffer();
        byte[] b;
        int code;
        try {
             fis = new FileInputStream(filePath);
            while ((code = fis.read()) != -1) {
                ba.write(code);
            }
            b = ba.toByteArray();
            return this.defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new RuntimeException("自定义文件不存在");
        }
    }
}
