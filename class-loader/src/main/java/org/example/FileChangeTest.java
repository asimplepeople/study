package org.example;

import java.io.*;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/1/14
 */
public class FileChangeTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\ideaProjects\\study\\target\\production\\SalaryCalculater\\com\\zhaohui\\SalaryCaler.class");
        FileInputStream fis = new FileInputStream(file);
        File file2 = new File("D:\\ideaProjects\\study\\target\\production\\SalaryCalculater\\com\\zhaohui\\SalaryCaler2.class");
        FileOutputStream fos = new FileOutputStream(file2);

        int code = 1;
        fos.write(1);
        while((code = fis.read()) != -1){
            fos.write(code);
        }
        fis.close();
        fos.close();
    }
}
