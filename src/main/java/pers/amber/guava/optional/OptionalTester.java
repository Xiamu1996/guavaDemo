package pers.amber.guava.optional;

import com.google.common.base.Optional;

/**
 * @Author: Amber
 * @Date: 2018/10/5 17:05
 */
public class OptionalTester {

    private Optional<Integer> optional1;

    private Optional<Integer> optional2;

    private Optional<Integer> optional3;

    private Optional<Integer> optional4;

    private void init(){
        optional1 = Optional.of(1);

        // 若引用为null则快速失败
        try {
            optional2 = Optional.of(null);
        }catch (NullPointerException e){
            System.out.println("optional2 of null NullPointerException");
        }

        // 创建引用缺失的Optional实例
        optional3 = Optional.absent();

        // 创建指定引用的Optional实例，若引用为null则表示缺失
        optional4 = Optional.fromNullable(null);
    }

    private void testIsPresent(){
        assert optional1.isPresent() == true;
        assert optional3.isPresent() == false;
        assert optional4.isPresent() == false;
    }

    private void testGet(){
        assert optional1.get() == 1;
        try {
            optional3.get();
        }catch (IllegalStateException e){
            System.out.println("optional3 is null then get IllegalStateException");
        }
    }

    private void testOr(){
        // 若引用缺失，返回指定的值
        int defaultValue = 1;
        assert optional3.or(defaultValue) == defaultValue;
    }

    private void testOrNull(){
        // 若引用缺失，返回null
        assert optional3.orNull() == null;
    }

    private void testAsSet(){
        // 若引用缺失，返回null
        // 如果引用存在，返回一个只有单一元素的集合，如果引用缺失，返回一个空集合
        assert optional1.asSet().size() == 1;
        assert optional3.asSet().isEmpty() == true;
    }


    public static void main(String[] args) {
        System.out.println("OptionalTester start!---------------");
        OptionalTester tester = new OptionalTester();
        tester.init();
        tester.testIsPresent();
        tester.testGet();
        tester.testOr();
        tester.testOrNull();
        tester.testAsSet();
        System.out.println("OptionalTester end!-----------------");
    }
}
