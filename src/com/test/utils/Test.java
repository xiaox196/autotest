package com.test.utils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 4, 9, 5, 4, 7, 6, 3, 2, 1, 9 };

		for(int i=0;i<a.length;i++){
			int tmp=a[a[i]];
			System.out.println(a[i]);
		}

	}

	public int test(int[] a, int n) {
		{
			int j = -1;
			for (int i = 0; i < n; i++) {
				j = a[i];
				System.out.println("j=" + j + " i=" + i);
				if (i == j - 1)
					continue;
				if (a[i] == a[j - 1])
					return 1;
				a[i] = a[j - 1];
				a[j - 1] = j;
				i--;
			}
			return 0;
		}
	}

}
