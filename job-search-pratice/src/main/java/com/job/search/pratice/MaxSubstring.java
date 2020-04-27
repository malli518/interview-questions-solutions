package com.job.search.pratice;

import java.io.IOException;
import java.util.Scanner;

class Result {

	/*
	 * Complete the 'maxSubstring' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String maxSubstring(String str) {
		String mx = "";
		for (int i = 0; i < str.length(); ++i) {
			System.out.println("Compare:: "+mx.compareTo(str.substring(i)));
			if (mx.compareTo(str.substring(i)) <= 0) {
				mx = str.substring(i);
				System.out.println("Mx :: "+mx);
			}
		}
		return mx;
	}
}

public class MaxSubstring {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String ");
		String s = scanner.nextLine();
		String result = Result.maxSubstring(s);

		System.out.println("Result :: " + result);
	}

}
