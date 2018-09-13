package com.hackerearth.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CricketBalls {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int n;
		int[] arr;
		int k;
		int result;
		for (int i = 0; i < testcase; i++) {
			n = sc.nextInt();
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			k = sc.nextInt();
			result = solve(arr,k);
			System.out.println(result);
		}
		sc.close();
	}

	private static int solve(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int temp;
		int val;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = k-arr[i];
			if(map.containsKey(temp)){
				val = map.get(temp);
				if(val == 0){
					val =1;
				}
				map.put(temp, val+1);
			}else{
				map.put(arr[i], 0);
			}
			
		}
		System.out.println(map);
		return count;
	}

}

/*

1
5
3 3 3 3 3
6

*/