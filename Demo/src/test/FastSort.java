package test;

/**
 * @author xxl
 * @category 快速排序
 * 
 *           https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class FastSort {

	/**
	 * 递归实现快速排序
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] arr, int low, int high) {
		// low 首位，high 末位
		// temp，基准位

		int i, j, temp, t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		temp = arr[low];

		while (i < j) {
			// 先看右边，依次往左递减
			while (temp <= arr[j] && i < j) {
				j--;
			}
			// 再看左边，依次往右递增
			while (temp >= arr[i] && i < j) {
				i++;
			}
			// 如果满足条件则交换
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}

		}
		// 最后将基准为与i和j相等位置的数字交换
		arr[low] = arr[i];
		arr[i] = temp;
		// 递归调用左半数组
		quickSort(arr, low, j - 1);
		// 递归调用右半数组
		quickSort(arr, j + 1, high);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19 };
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

// int[] a = new int[] { 6, 2, 3, 9, 4, 5, 8, 10, 9, 7 };
