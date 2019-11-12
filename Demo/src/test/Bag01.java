package test;

import java.util.Scanner;

/**
 * @author xxl
 * @category 01背包问题
 * 
 *           https://blog.csdn.net/qq_38410730/article/details/81667885
 */
public class Bag01 {

	public static void main(String[] args) {
		// 背包最大可放物品数：100
		final int max = 100;
		int[][] f = new int[max][max];

		// 物品数量
		int n;
		// 背包体积
		int v;
		// 每个物品占用空间
		int[] c = new int[max];
		// 每个物品的价值
		int[] w = new int[max];

		Scanner sc = new Scanner(System.in);

		System.out.println("请输入物品数量：");
		n = sc.nextInt();
		System.out.println("请输入背包体积：");
		v = sc.nextInt();

		System.out.println("请输入每个物品的体积：");
		// 输入每个物品的体积
		for (int i = 1; i <= n; i++) {
			c[i - 1] = sc.nextInt();
		}

		System.out.println("请输入每个物品的价值：");
		// 输入每个物品的价值
		for (int i = 1; i <= n; i++) {
			w[i - 1] = sc.nextInt();
		}

		// 寻找最佳方案
		// 第i个物品
		for (int i = 1; i <= n; i++) {
			// 剩余空间j
			for (int j = v; j >= 0; j--) {
				// 如果装的下
				if (j >= c[i]) {
					// max方法为c++中的max函数
					f[i][j]=max{f[i-1][j-c[i]]+w[i],f[i-1][j]};
				}else {
					f[i][j]=f[i-1][j];
				}
			}
		}
		
		// 输出结果
		System.out.println(f[n][v]);

	}

}
