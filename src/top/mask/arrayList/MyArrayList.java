package top.mask.arrayList;

import java.util.*;

/**
 * ClassName MyArrayList
 * Create by hx
 * Date 2021/6/24 5:40 下午
 */

public class MyArrayList<E> implements List {

    Object[] elementData;  //存放的数据
    private int size; //数组的长度
    private static final int DEFAULT_CAPACITY = 10;  //默认列表长度
    private static final Object[] EMPTY_ELEMENTDATA = {}; //空的数组

    /**
     * 创建无参列表，默认长度10
     */
    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    //创建有参列表
    public MyArrayList(int initCapacity){
        //当传入的长度大于0时创建对应长度线性表
        if (initCapacity > 0){
            elementData = new Object[initCapacity];
        }else {
            //如果长度为0创建空的数组
            elementData = EMPTY_ELEMENTDATA;
        }
        this.size = 0;

    }


    @Override
    public int size() {
        //返回此列表中的元素数
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        //如果此列表不包含元素，则返回true
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        //如果此列表包含指定元素，返回true
        return this.indexOf(o) != -1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (this.size == this.elementData.length){
            //如果数组的长度达到当前最大定义的最大长度，即扩容数组,1.5倍
            ensureCapacity(this.elementData.length + this.elementData.length / 2);
        }
        //将指定的元素追加到列表末尾
        elementData[size] = o;
        size++;
        //考虑数组个数达到最大值，此时需扩容

        return true;
    }

    /**
     * 扩容列表大小
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity){
        if (minCapacity > this.elementData.length){
            Object[] temp = new Object[minCapacity];
            for (int i = 0; i < this.size; i++) {
                //将原来的数组数据全部转移至扩容后的数组
                temp[i] = this.elementData[i];
            }
            this.elementData = temp;

        }
    }

    @Override
    public boolean remove(Object o) {
        //从列表中删除指定元素的第一个出现

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("数组越界");
        }
        return (E) this.elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("数组越界");
        }
        //返回插入位置的原来的数据
        Object old = this.elementData[index];
        this.elementData[index] = element;

        return old;
    }

    @Override
    public void add(int index, Object element) {
        //在此列表中指定位置插入元素
        if (index < 0 || index > size){
            //数组下标超出范围抛异常
            throw new IndexOutOfBoundsException();
        }
        //扩容
        if (this.size == this.elementData.length){
            this.ensureCapacity(this.elementData.length + this.elementData.length / 2);
        }
        for (int i = this.size - 1; i >= index; i--) {
            this.elementData[i+1] = this.elementData[i];
        }
        this.elementData[index] = element;
        this.size++;

    }

    @Override
    public Object remove(int index) {
        //删除指定元素
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        Object o = this.elementData[index];
        for (int i = index;i<size -1;i++){
            this.elementData[i] = this.elementData[i+1];
        }
        this.size--;
        return o;
    }

    @Override
    public int indexOf(Object o) {
        //返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素返回-1

        if (o == null){
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i].equals(o)){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size - 1; i++) {
            str += elementData[i]+", ";
        }
        if (this.size > 0 ){
            str += this.elementData[size-1];
        }
        str += "]";

        return str;
    }
}
