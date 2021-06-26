package top.mask.chuan;

/**
 * ClassName SqStringClass
 * Create by hx
 * Date 2021/6/26 3:47 下午
 */

public class SqStringClass {
    final int maxSize = 100;
    char[] data;
    int size;
    public SqStringClass(){
        data = new char[maxSize];
        size = 0;
    }

    public SqStringClass subStr(int i,int j){
        if (i < 0 || i >= size || i-j+1 < 0 || i-j+1 >= size){
            throw new IndexOutOfBoundsException();
        }
        SqStringClass t = new SqStringClass();
        t.size = j;
        for (int k = 0; k < j; k++) {
            t.data[k] = this.data[i+k];
        }
        return t;
    }

    //设计一个算法strcmp(s,t) 以字典顺序比较两个英文字母s和t的大小，俩串均以顺序存储
    //s比t大，返回正值，小返回负值
    public int strcmp(SqStringClass s, SqStringClass t){
        int i=0; //s串的索引
        int j=0; //t串的索引
        while (i < s.size && j < t.size){
            if (s.data[i] == t.data[j]){
                i++;
                j++;
            }else {
                return s.data[i] - t.data[j];
            }
        }
        if (i == s.size){
            if (j == s.size){
                return 0;
            }else {
                return -1;
            }
        }else {
            return 1;
        }


    }
}
