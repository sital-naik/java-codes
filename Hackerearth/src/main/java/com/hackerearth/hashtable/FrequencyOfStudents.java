package com.hackerearth.hashtable;



/*
There is a class consisting of 'N' students . There can be many students with the same name.
Now, you have to print the names of the students followed by there frequency as
shown in the sample explanation given below.
Output the names in the lexicographical order.

SAMPLE INPUT 
5
sumit
ambuj
himanshu
ambuj
ambuj

SAMPLE OUTPUT 
ambuj 3
himanshu 1
sumit 1


*/

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequencyOfStudents {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new TreeMap<>();
		int n = sc.nextInt();
		String key;
		for (int i = 0; i < n; i++) {
			key = sc.next();
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
	}
}
