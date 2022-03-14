package com.example.design;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 流的处理
 * 1) 流的创建
 * 2) 中间操作
 * 3) 流的终止
 *
 * @author 神秘的X先生
 * @date 2022/3/14
 */
public class StreamTest {

    @Test
    public void test1(){
        Stream<Integer> integerStream = Stream.of(4, 1, 3, 5);
        integerStream.forEach(System.out::println);
        // 流中没有数据
        Stream<Integer> integerStream2 = Stream.of();
        integerStream2.forEach(System.out::println);
        // 传入null会被解析成一个数组对象,会进一步访问长度信息
        // Stream<Integer> integerStream3 = Stream.of(null);
        //integerStream3.forEach(System.out::println);
    }
}
