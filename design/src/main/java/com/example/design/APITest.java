package com.example.design;

import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author 神秘的X先生
 * @date 2022/3/14
 */
public class APITest {


    @Test
    public void test3(){
        LocalDate of = LocalDate.of(2019, 7, 8);
        // 在添加重复元素的时候,不是无法添加,而是排除异常
        Set<Integer> integers = Set.of(100, 50, 100);
        System.out.println(integers);

        Stream<Integer> stream = Stream.of(12,23,43);

    }

    // 集合中的一些增强的api
    @Test
    public void test1(){
        int[] arr = {1,2,3,4,5};
        var aa = List.of("aa", "bb", "dd");
        aa.add("yy");
        System.out.println(aa);
    }
    @Test
    public void test2(){
        var list = new ArrayList<String>();
        list.add("hello");
        System.out.println(list);
    }
}
