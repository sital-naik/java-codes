package com.hackerearth.hashtable;

/*
Q: You have been given an integer array A and a number K. 
Now, you need to find out whether any two different elements of the array A sum to the number K. 
Two elements are considered to be different if they lie at different positions in the array. 
If there exists such a pair of numbers, print "YES" (without quotes), else print "NO" without quotes.

SAMPLE INPUT 
5 9
1 2 3 4 5

SAMPLE OUTPUT 
YES


Solution Algorithm

1) Initialize an empty hash table s.
2) Do following for each element A[i] in A[]
   (a)    If s[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)    Insert A[i] into s.
   
*/

import java.util.HashMap;
import java.util.Scanner;

public class PairSums {
	
	public static void main(String[] args) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = sc.nextInt();
			if(map.containsKey(k-temp)){
				System.out.println("YES");
				return;
			}else{
				map.put(temp, true);
			}
		}
		System.out.println("NO");
		
	}
}
