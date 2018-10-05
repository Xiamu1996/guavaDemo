package pers.amber.guava.base;

import com.google.common.base.Preconditions;

/**
 * @Author: Amber
 * @Date: 2018/10/5 21:18
 */
public class PreconditionsTester {

    private void testCheckArgument(){
        // 检查boolean是否为true，检查失败时抛出IllegalArgumentException
        boolean test = false;
        try {
            Preconditions.checkArgument(test);
        }catch (IllegalArgumentException e){
            System.out.println("checkArgument IllegalArgumentException");
        }
    }

    private void testCheckNotNull(){
        // 检查value是否为true，检查失败时抛出NullPointerException
        Integer a = null;
        try {
            Preconditions.checkNotNull(a);
        }catch (NullPointerException e){
            System.out.println("checkNotNull NullPointerException");
        }
    }

    private void testCheckState(){
        // 检查boolean是否为true，检查失败时抛出IllegalStateException
        boolean test = false;
        try {
            Preconditions.checkState(test);
        }catch (IllegalStateException e){
            System.out.println("checkState IllegalStateException");
        }
    }

    private void testCheckElementIndex(){
        // 	检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size *
        int[] array = new int[]{1,3};
        try {
            Preconditions.checkElementIndex(3,array.length);
        }catch (IndexOutOfBoundsException e){
            System.out.println("checkElementIndex IndexOutOfBoundsException");
        }
    }

    private void testCheckPositionIndexes(){
        // 检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
        int[] array = new int[]{1,3};
        try {
            Preconditions.checkPositionIndexes(0,3,array.length);
        }catch (IndexOutOfBoundsException e){
            System.out.println("checkPositionIndexes IndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        PreconditionsTester tester = new PreconditionsTester();
        tester.testCheckArgument();
        tester.testCheckNotNull();
        tester.testCheckState();
        tester.testCheckElementIndex();
        tester.testCheckPositionIndexes();
    }
}
