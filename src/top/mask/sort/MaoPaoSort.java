package top.mask.sort;

/**
 * ClassName MaoPaoSort
 * Create by hx
 * Date 2021/6/27 6:39 下午
 */

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] array = {12,43,54,56,78,90,45,56};
        int temp = 0;
        System.out.println("遍历前的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("遍历后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
