package top.mask.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ClassName MyLinkedList
 * Create by hx
 * Date 2021/6/25 9:52 下午
 */

public class MyLinkedList<E> implements List<E> {

    Node<E> head;
    private static class Node<E>{
        E item;
        Node<E> next;
        Node(E element,Node<E> next){
            this.item = element;
            this.next = next;
        }
    }

    public MyLinkedList(){
        head = new Node<>(null,null);
    }

    public MyLinkedList(Collection<? extends E> c){
        //构造一个包含指定集合的元素列表，按照由集合的迭代器返回的顺序
        this(); //调用空参构造器
        Node<E> p = head;
        for (E e : c){
            Node<E> tNode = new Node<>(e,null);
            p.next = tNode;
            p = p.next;
        }


    }



    @Override
    public int size() {
        int count = 0;
        Node<E> pNode = head.next;
        while (pNode != null){
            count++;
            pNode = pNode.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
