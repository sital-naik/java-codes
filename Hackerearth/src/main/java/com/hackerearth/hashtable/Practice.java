package com.hackerearth.hashtable;

import java.util.Scanner;

public class Practice {
	
	static class Hashtable{
		
		private String[] entry;
		
		public Hashtable(int n) {
			entry = new String[n];
		}
		
		public void put(int key, String value){
			entry[key-1] = value;
		}
		
		public String get(int key){
			return entry[key-1];
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		Hashtable h = new Hashtable(n);
		for (int i = 0; i < n; i++) {
			h.put(sc.nextInt(), sc.next());
		}
		
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			System.out.println(h.get(sc.nextInt()));
		}
	}
}
