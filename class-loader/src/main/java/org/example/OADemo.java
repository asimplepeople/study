package org.example;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/1/14
 */
public class OADemo {
    public static void main(String[] args) throws Exception {
        Double salary = 2000.0;
        Double money;
        URL jarPath = new URL("file:D:\\ideaProjects\\study\\out\\artifacts\\SalaryCalculater_jar\\SalaryCalculater.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jarPath});
        while (true) {
            money = calSalary(salary, urlClassLoader);
            System.out.println("实际到手的工资:" + money);
            Thread.sleep(1000L);
        }
    }

    private static Double calSalary(Double salary, URLClassLoader urlClassLoader) throws Exception {
        Class<?> aClass = urlClassLoader.loadClass("com.zhaohui.SalaryCaler");
        Object o = aClass.getDeclaredConstructor().newInstance();
        return (double) aClass.getMethod("cal", double.class).invoke(o, salary);
    }
}
