package com.dj.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public static void main2(String[] args) {

		System.out.println("Hello World!");
		//SpringApplication.run(App.class, args);

		int[] arr = { 1, 2, 3, 4, 5 };
		reverse(arr);
		String str = "Dheeraj";
		char[] brr = str.toCharArray();
		reverse(brr);
	}

	public static void reverse(int[] arr) {
		int j = arr.length;
		int n = arr.length;
		int[] brr = new int[j];
		for (int i = 0; i < arr.length; i++) {
			brr[j - 1] = arr[i];
			j = j - 1;
		}

		System.out.println("After Reversing--");
		for (int i = 0; i < n; i++) {
			System.out.print(brr[i]);
		}

	}

	public static void reverse(char[] arr) {
		int j = arr.length;
		int n = arr.length;
		char[] brr = new char[j];
		for (int i = 0; i < arr.length; i++) {
			brr[j - 1] = arr[i];
			j = j - 1;
		}

		System.out.println("After Reversing--");
		for (int i = 0; i < n; i++) {
			System.out.print(brr[i]);
		}
	}
}
