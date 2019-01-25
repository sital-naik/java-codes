package com.learning.hackerearth;

public class CountSolutions {

	public static void main(String[] args) {
		long s = 200000;
		long start = System.nanoTime();
		System.out.println(countTotalSol(s));
		System.out.println("Total time : " + ((System.nanoTime() - start) / 1000000));

	}

	private static long countTotalSol(long s) {
		long a, b, b2, c, c3, d, d4, count, res;
		a = b = c = b2 = c3 = d4 = res = count = 0;
		for (a = 0; a < 1000; a++) {
			if (a > s)break;
			for (b = 0; b < 1000; b++) {
				b2 = b * b;
				if (b2 > s)break;
				for (c = 0; c < 1000; c++) {
					c3 = c * c * c;
					if (c3 > s)break;
					for (d = 0; d < 1000; d++) {
						d4 = d * d * d * d;
						if (d4 > s)break;
						res = a + b2 + c3 + d4;
						if (res > s) break;
						count++;
					}
				}
			}
		}
		return count;
	}

}
