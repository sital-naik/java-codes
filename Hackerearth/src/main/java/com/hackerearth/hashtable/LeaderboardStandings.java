package com.hackerearth.hashtable;

/*

There were N submissions made in a programming contest containing infinite problems. 
Each submission earned the contestant 100 points as none of the submissions is a wrong or a partial submission. 
You are given the details of the submissions - the username of the contestant and the time taken to solve the problem. 
Your task is to print the rank list according to the following rules:

The contestant with a higher score gets a higher rank.
	1) If the scores are tied, then the contestant with the least sum of the time taken to solve 
		the problems gets a higher rank.
	2) In case of a tie in both scores and sum of the time taken, 
		they are ranked lexicographically according to their usernames. 
Note: The details of the submissions are not sorted in any order (neither by time nor by username)

SAMPLE INPUT 
9
Tom 6
Jim 7
Tom 19
Phil 8
Rick 12
Jim 22
Rick 18
Phil 22
Tom 36

SAMPLE OUTPUT 
1 Tom
2 Jim
3 Phil
4 Rick


*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LeaderboardStandings {
	static class Student implements Comparable<Student> {
		String name;
		Integer score;
		Integer time;

		public Student(String name, int score, int time) {
			super();
			this.name = name;
			this.score = score;
			this.time = time;
		}

		@Override
		public int compareTo(Student obj) {
			if (this.score.equals(obj.score)) {
				if (this.time.equals(obj.time)) {
					return this.name.compareTo(obj.name);
				} else {
					return this.time.compareTo(obj.time);
				}
			} else if (this.score > obj.score) {
				return -1;
			} else {
				return 1;
			}
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", score=" + score + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Student> map = new HashMap<>();
		int n = sc.nextInt();
		Student st = null;
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int time = sc.nextInt();
			if (map.containsKey(name)) {
				st = map.get(name);
				st.score += 100;
				st.time += time;
				map.put(name, st);
			} else {
				map.put(name, new Student(name, 100, time));
			}
		}

		List<Student> list = map.entrySet().stream().map(a -> a.getValue()).sorted().collect(Collectors.toList());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + " " + list.get(i).name);
		}

	}
}
