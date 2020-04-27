package com.job.search.pratice;

public class ArrayExample {

	public static void main(String[] args) {
		int a[]= {1,2,3,4};
		String str="";
		for (int i = 0; i < a.length; i++) {
			str=str+a[i];
			if(a[i]==a.length) {
				int appendedArray=Integer.parseInt(str);				
				appendedArray=appendedArray+1;
				str=Integer.toString(appendedArray);
				str=str.substring(a.length-1, a.length);				
				a[i]=Integer.parseInt(str);
			}			
		}
		for (int i : a) {
			System.out.println(i);
		}		
	}
}
//input array={1,2,3,4}
//output array={1,2,3,5}