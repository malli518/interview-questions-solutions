package com.job.search.pratice;

import java.util.LinkedList;
import java.util.List;

public class MyClass2 {

	private List<String> items = new LinkedList<String>();

	public synchronized void push(String item) {
		items.add(item);
		if (items.size() > 100000) {
			System.out.println("Stack is too big");
		}
	}

	public String pop() {
		String item = items.get(items.size() - 1);
		items.remove(items.size() - 1);
		return item;
	}

	public synchronized Package print() {
		Package result = new Package();
		String resultStr = "";
		for (int i = items.size() - 1; i >= 0; i--) {
			resultStr = resultStr + items.get(i);
			resultStr = resultStr + "\n";
		}
		result.values = resultStr;
		result.digest = (resultStr.length() + items.size()) % 1007;
		return result;
	}

	public static class Package {
		String values;
		/** some numeric checksum */
		long digest;
	}

	public static void main(String[] args) {
		
		MyClass2 myClass = new MyClass2();
		long start=System.currentTimeMillis();
		System.out.println("start :: "+start);
		
		for (int i = 0; i < 10; i++) {
			myClass.push("Ramdam"+i);
		}		
		System.out.println("Beofre Values :: " + myClass.print().values);
		System.out.println(myClass.pop());		
		System.out.println("After Values :: " + myClass.print().values);
		System.out.println(myClass.print().digest);
		long end=System.currentTimeMillis();
		System.out.println("end :: "+end);
		System.out.println((end-start)/1000.0 + " secs");

	}

}
