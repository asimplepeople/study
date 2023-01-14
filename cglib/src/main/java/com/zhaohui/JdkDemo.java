package com.zhaohui;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 🤪zhaohui🤪
 * @date 2023/1/13
 */
public class JdkDemo {
    public static void main(String[] args) {
        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(JdkDemo.class.getClassLoader(), new Class[]{UserInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("test");
                return null;
            }
        });
        userInterface.test();
    }
}
