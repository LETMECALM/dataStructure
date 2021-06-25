package top.mask.linkedlist;

import java.util.LinkedList;

/**
 * ClassName Node
 * Create by hx
 * Date 2021/6/25 9:11 下午
 */

public class Node<E> {
    E item;
    Node<E> next;
    Node(E element,Node<E> next){
        this.item = element;
        this.next = next;
    }


}
