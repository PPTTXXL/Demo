package test;

import java.util.HashSet;

public class Fenjie {
	/**
	 * 临时的构建内部类
	 */
	static class Construct {
		int left; // 拆的第一个数 eg：拆5 left=1,right=4
		int right; // 与拆的第一个数互补的数
		String complement; // 补充1的片段

		public Construct(int left, int right, String complement) {
			this.left = left;
			this.right = right;
			this.complement = complement;
		}

		public int getLeft() {
			return left;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public int getRight() {
			return right;
		}

		public void setRight(int right) {
			this.right = right;
		}

		public String getComplement() {
			return complement;
		}

		public void setComplement(String complement) {
			this.complement = complement;
		}

		@Override
		public String toString() {
			return "Construct{" + "left=" + left + ", right=" + right + ", complement='" + complement + '\'' + '}';
		}
	}

	public static void main(String[] args) {
		// 要拆的数
		int num = 10;
		// 拆的临时数组
		Construct[][] tempConstruct = new Construct[num + 1][];
		// 构建的结果
		HashSet<String> res = new HashSet<String>();
		// 将不用的置空
		tempConstruct[0] = null;
		tempConstruct[1] = null;
		// 按需构建二维数组并填充拆开的数据
		for (int i = 2; i <= num; i++) {
			tempConstruct[i] = new Construct[i - 1];
			int index = 0;
			for (int j = 1; j < i; j++) {
				StringBuilder str = new StringBuilder();
				for (int z = 0; z < (num - i); z++) {
					str.append("1+");
				}
				// 去掉末尾的加号并添加到构建对象中
				tempConstruct[i][index++] = new Fenjie.Construct(j, i - j,
						str.length() > 0 ? str.toString().substring(0, str.length() - 1) : str.toString());
			}
		}
		// 构建结果
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j < tempConstruct[i].length; j++) {
				Construct construct = tempConstruct[i][j];
				if (construct.getComplement().equals("")) {
					res.add(construct.getLeft() + "+" + construct.getRight());
					res.add(construct.getRight() + "+" + construct.getLeft());
				} else {
					res.add(construct.getLeft() + "+" + construct.getRight() + "+" + construct.getComplement());
					res.add(construct.getComplement() + "+" + construct.getLeft() + "+" + construct.getRight());
					res.add(construct.getRight() + "+" + construct.getComplement() + "+" + construct.getLeft());
				}
			}
		}
		// 打印结果
		System.out.println(num + "所拆的个数:" + res.size());
		for (String string : res) {
			System.out.println(num + "=" + string);
		}

	}

}
