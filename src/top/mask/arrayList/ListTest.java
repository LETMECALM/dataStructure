package top.mask.arrayList;

import java.util.ArrayList;

/**
 * ClassName ListTest
 * Create by hx
 * Date 2021/6/24 6:01 下午
 */

public class ListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
//        ArrayList list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add(3,"x");
//        list.add(15,"y");

//        System.out.println(list.indexOf(null));
        System.out.println(list.set(2,"C"));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("删除一个元素");
        list.remove("b");
        System.out.println(list);
    }
}
