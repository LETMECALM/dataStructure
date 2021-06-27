package top.mask.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortDemo {

	public static void main(String[] args) {

		int[] array = { 34, 26, 89, 17, 54, 67, 2, 11, 73, 26, 47 };
		System.out.println("待排数组：");
		print(array);

//		insertSort(array);		//直接插入排序
//		binInsertSort(array);	//二分插入排序
//		shellSort(array);		//希尔插入排序
//		bubbleSort(array); 		//冒泡排序
		quickSort(array); 		//快速排序
//		selectSort(array);		//简单选择排序
//		heapSort(array);		//堆排序
//		mergeSort(array);		//归并排序
//		radixSort(array);		//基数（桶）排序
		System.out.println("排序后数组：");
		print(array);


	}

	/**
	 *
	 * @param array
	 *   对数组array进行堆排序
	 */
	public static void heapSort(int[] array) {
		// 循环建堆
		buildMaxHeap(array);
		System.out.println("建堆后序列：");
		print(array);
		for (int i = 0; i < array.length - 1; i++) {
			// 交换堆顶和最后一个元素
			swap(array, 0, array.length - 1 - i);
			System.out.println("第" + i + ",趟排序：");
			print(array);
			System.out.println("第" + i + ",趟调整堆：");
			sift(array, 0, array.length - 2 - i);
			print(array);
		}
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static void sift(int[] array, int low, int high) {
		// k保存正在判断的节点
		int k = low;
		// 如果当前k节点的子节点存在
		while (k * 2 + 1 <= high) {
			// k节点的左子节点的索引
			int biggerIndex = 2 * k + 1;
			// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
			if (biggerIndex < high) {
				// 若果右子节点的值较大
				if (array[biggerIndex] < array[biggerIndex + 1]) {
					// biggerIndex总是记录较大子节点的索引
					biggerIndex++;
				}
			}
			// 如果k节点的值小于其较大的子节点的值
			if (array[k] < array[biggerIndex]) {
				// 交换他们
				swap(array, k, biggerIndex);
				// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
				k = biggerIndex;
			} else {
				break;
			}
		}
	}

	// 对array数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] array) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			sift(array, i, array.length - 1);
		}
	}

	/**
	 *
	 * @param array
	 *
	 * 	对数组进行归并排序
	 */

	public static void mergeSort(int[] array) {

		int len = 1;// 每组元素个数

		while (len < array.length) {
			int i;
			System.out.println("len = " + len);
			for (i = 0; i + 2 * len - 1 < array.length; i = i + 2 * len) {
				merge(array, i, i + len - 1, i + 2 * len - 1);
			}

			if (i + len < array.length)
				merge(array, i, i + len - 1, array.length - 1);

			len *= 2;
			print(array);
		}
	}

	/**
	 *
	 * @param array 数组array
	 * @param low   起始排序点
	 * @param mid   中间点
	 * @param high  末端排序点
	 *              将有序数组array[low...mid]和array[mid+1...high]归并成有序数组array[low...high]
	 */
	private static void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[array.length];
		int i = low; // array[low...mid]的下标
		int j = mid + 1; // array[mid+1...high]的下标
		int k = low; // temp的下标
		while (i <= mid && j <= high) {
			if (array[i] <= array[j]) {
				temp[k] = array[i];
				i++;
			} else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}
		while (i <= mid) { // array[low...mid]余下部分复制到temp中
			temp[k++] = array[i++];
		}

		while (j <= high) { // array[mid+1...high]余下部分复制到temp中
			temp[k++] = array[j++];
		}

		for (i = low; i <= high; i++) // 将temp复制回array
			array[i] = temp[i];
	}

	/**
	 * 直接选择排序
	 */
	private static void selectSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {// 循环次数
			int key = array[i];
			int position = i;
			for (int j = i + 1; j < length; j++) {// 选出最小的值和位置
				if (array[j] < key) {
					key = array[j];
					position = j;
				}
			}
			array[position] = array[i];// 交换位置
			array[i] = key;
		}
	}

	/**
	 *
	 * @param array 快速排序
	 */

	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 *
	 * @param array
	 * @param start
	 * @param end
	 * 		array[start]为基准，对数组array[start...end]进行排序
	 */
	private static void quickSort(int[] array, int start, int end) {
		// 快速排序，经过一趟排序之后，数组的
		if (end <= start) {
			return;
		}
		int temp = array[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j && array[j] >= temp) { // 找到第一个比temp小的数字
				j--;
			}
			array[i] = array[j];
			while (i < j && array[i] <= temp) { // 从前往后找，找到第一个比temp大的数字
				i++;
				if (i > end) {
					break;
				}
			}
			array[j] = array[i];
		}
		System.out.println("i = " + i + ", j = " + j);
		array[i] = temp;
		print(array);
		quickSort(array, start, i - 1);
		quickSort(array, i + 1, end);
	}

	/**
	 *
	 * @param array 冒泡排序
	 */
	private static void bubbleSort(int[] array) {
		// 冒泡排序
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	private static void print(int[] array) {
		// 输出数组
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	private static void binInsertSort(int[] array) {
		// 二分插入排序算法
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int low = 0;
			int high = i - 1;
			int mid;
			while (low <= high) {
				// 查找插入位置
				mid = (low + high) / 2;
				if (array[mid] <= temp) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			high++; // 最终插入位置
			for (int j = i; j >= high + 1; j--) {
				// 将插入位置上的元素往后面移动一位
				array[j] = array[j - 1];
			}
			System.out.println("插入位置：" + high);
			array[high] = temp;
			print(array);

		}
	}

	private static void insertSort(int[] array) {
		// 插入排序算法
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) { // 查找插入位置
				if (array[j] > temp) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}

			j = j + 1;
			array[j] = temp;
			print(array);
		}

	}

	private static void shellSort(int[] array) {
		// 希尔排序算法
		int d = array.length / 2;
		while (d >= 1) {
			int k = 0;
			while (k < d) {
				for (int i = d + k; i < array.length; i = i + d) {
					int temp = array[i];
					int j;
					for (j = i - d; j >= 0; j = j - d) { // 查找插入位置
						if (array[j] > temp) {
							array[j + d] = array[j];
						} else {
							break;
						}
					}

					j = j + d;
					array[j] = temp;
				}
				k++;
			}
			d = d / 2;
			print(array);
		}
	}


	/**
	 *
	 * @param array
	 * 	基数排序
	 */
	public static void radixSort(int[] array) {
		// 建立10个队列，分别存放十位数字是0-9的数字;
		ArrayList<Queue<Integer>>  list = new ArrayList<> ();
		for(int i = 0 ;i<10;i++) {
			list.add(new LinkedList<>());
		}

		for(int num:array) {		//根据十位数字发放到10个桶中（0号桶存储十位数字是0的所有数字，etc
			list.get(num/10).offer(num);
		}

		int k = 0;
		for(Queue<Integer> queue:list) {		//依次处理十位数字是0-9的队列
			// 建立10个队列，分别存放个位数字是0-9的数字;
			ArrayList<Queue<Integer>>  list1 = new ArrayList<> ();
			for(int i = 0 ;i<10;i++) {
				list1.add(new LinkedList<>());
			}
			for(Integer num:queue) {				//根据个位数字发放到不同的10个桶中
				list1.get(num%10).offer(num);
			}
			for(Queue<Integer> queue2:list1) {		//依次处理10个桶
				for(Integer num:queue2) {			//每个桶是有多个数字
					array[k++] = num;
				}
			}
		}
	}
}
