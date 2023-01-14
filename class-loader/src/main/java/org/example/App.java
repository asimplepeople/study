package org.example;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println(App.class.getClassLoader());
        System.out.println("Bootstrap classLoader 记载目录：" + System.getProperty("sun.boot.class.path"));
        System.out.println("Extension classLoader 记载目录：" + System.getProperty("java.ext.dirs"));
        System.out.println("App classLoader 记载目录：" + System.getProperty("java.class.path"));
        System.out.println( System.getProperty("file.encoding"));
    }
}
