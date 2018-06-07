package main;

import java.util.Random;

public class Main {

	MyContainer<Integer> ints = new MyContainer<>();
	Random r = new Random();

	public static void main(String[] args) {
		MyContainer<Integer> ints = new MyContainer<>();
		Random r = new Random();
		for(int i = 0; i < 1000000; ++i)
			ints.add(Math.abs(r.nextInt()) % 1000);

		ints.countNumber(1);
		ints.countNumberBiggerThen(900);
		ints.countNumberLessThen(900);
	}
}
