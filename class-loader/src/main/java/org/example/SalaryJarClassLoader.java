package org.example;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.SecureClassLoader;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/1/14
 */
public class SalaryJarClassLoader extends SecureClassLoader {

    private String jarPath;

    public SalaryJarClassLoader(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    protected Class<?> findClass(String name) {
        String filePath = "jar:file:" + jarPath + "!/" + name.replace(".", "/").concat(".class");
        InputStream is;
        URL fileUrl;
        ByteArrayBuffer ba = new ByteArrayBuffer();
        byte[] b;
        int code;
        try {
            fileUrl = new URL(filePath);
            is = fileUrl.openStream();
            while ((code = is.read()) != -1) {
                ba.write(code);
            }
            b = ba.toByteArray();
            return this.defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new RuntimeException("自定义文件不存在");
        }
    }

}
