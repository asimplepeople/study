package com.example.var;

import org.springframework.lang.NonNull;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * 局部变量类型推断 var"关键字" 非关键字
 *
 *
 * @author 神秘的X先生
 * @date 2022/3/14
 */
public class VVar {
    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.printf(t.toUpperCase(Locale.ROOT));
        Consumer<String> consumer1 = (var t) -> System.out.printf(t.toUpperCase(Locale.ROOT));
        Consumer<String> consumer2 = (@NonNull var t) -> System.out.printf(t.toUpperCase(Locale.ROOT));
        //Consumer<String> consumer = (var t) -> System.out.printf(t.toUpperCase(Locale.ROOT));
    }

}
