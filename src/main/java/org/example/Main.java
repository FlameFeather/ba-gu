package org.example;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		System.out.println(SingleCl.getInstance());
		System.out.println(SingleCl.getInstance());
		System.out.println(SingleCl.a);
	}

	public static void testOnLinkedListAndArrayList() {
		int n = 10000000;
		ArrayList<Integer> arrayList = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			arrayList.add(random.nextInt(100000));
		}
		LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("ArrayList");
		addToList(arrayList, 1000, random);
		stopWatch.stop();
		stopWatch.start("LinkedList");
		addToList(linkedList, 1000, random);
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}

	public static void addToList(List<Integer> list, int n, Random random) {
		for (int i = 0; i < n; i++) {
			list.add(list.size() / 2, random.nextInt(10000));
		}
	}
}