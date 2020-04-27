package com.job.search.pratice;

public class JohnCasino {

	public int solution(int n, int k) {
		if(k==0) {
			return n-1;
		}
		int count = 0;
		while (n > 1) {
			if (k > 0 && n%2 == 0) {
				n = n / 2;
				count++;
				k--;
			} else {
				count++;
				n = n - 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		JohnCasino johnCasino=new JohnCasino();
		System.out.println(johnCasino.solution(18, 2));
		System.out.println(johnCasino.solution(10, 10));
		System.out.println(johnCasino.solution(8, 0));
		
		System.out.println(johnCasino.solution(8, 2));
	}

}
