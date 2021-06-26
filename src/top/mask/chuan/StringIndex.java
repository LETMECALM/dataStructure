package top.mask.chuan;

/** BF暴力求解算法
 * ClassName StringIndex
 * Create by hx
 * Date 2021/6/26 4:50 下午
 */

public class StringIndex {
    public static void main(String[] args) {
        System.out.println(index("abced","ce"));
    }


    public static int index(String s,String t){
        int i=0;
        int j=0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1; //匹配不成功，回溯初始化
                j = 0;
            }
        }
        if (j == t.length()){
            return i - j;
        }else {
            return -1;
        }
    }
}
