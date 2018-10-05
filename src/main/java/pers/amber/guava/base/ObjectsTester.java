package pers.amber.guava.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * @Author: Amber
 * @Date: 2018/10/5 23:15
 */
public class ObjectsTester {

    private void testEqual(){
        // JDK7引入的Objects类提供了一样的方法
        assert Objects.equal("a", "a");
        assert !Objects.equal(null, "a");
        assert !Objects.equal("a", null);
        assert Objects.equal(null, null);
    }

    private void testHashCode(){
        // JDK7引入的Objects类提供了一样的方法Objects.hash(Object...)
        Person person1 = new Person();
        person1.setSex(0);
        person1.setName("a");

        Person person2 = new Person();
        person2.setSex(1);
        person2.setName("b");

        Person person3 = new Person();
        person3.setSex(1);
        person3.setName("b");

        assert Objects.hashCode(person1) != Objects.hashCode(person2);
        assert Objects.hashCode(person2) == Objects.hashCode(person2);
        assert Objects.hashCode(person2.getSex()) == Objects.hashCode(person3.getSex());
        assert Objects.hashCode(person2.getName()) == Objects.hashCode(person3.getName());
        assert Objects.hashCode(person2) != Objects.hashCode(person3);
    }

    private void testToString(){
        // Returns "ClassName{x=1}"
        assert MoreObjects.toStringHelper(Person.class).add("x",0).toString().equals("Person{x=0}");
    }

    private void testComparator(){
        // ComparisonChain执行一种懒比较：它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略
        Person person1 = new Person();
        person1.setSex(0);
        person1.setName("a");

        Person person2 = new Person();
        person2.setSex(0);
        person2.setName("b");

        Person person3 = new Person();
        person3.setSex(0);
        person3.setName("b");

        assert ComparisonChain.start()
                .compare(person1.sex, person2.sex)
                .compare(person1.name, person2.name)
                .result() != 0;

        assert ComparisonChain.start()
                .compare(person2.sex, person3.sex)
                .compare(person2.name, person3.name)
                .result() == 0;
    }

    public static void main(String[] args) {
        ObjectsTester tester = new ObjectsTester();
        tester.testEqual();
        tester.testHashCode();
        tester.testToString();
        tester.testComparator();
    }

    private class Person{
        private int sex;
        private String name;

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
