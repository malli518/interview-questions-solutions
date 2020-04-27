package com.job.search.pratice;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class MyClass {
	private LinkedList<String> items = new LinkedList<String>();
	String resultStr = "";
	
	public synchronized void push(String item) {
		items.add(item);
		item=item + "\n";
		resultStr = item + resultStr;		
		if (items.size() > 100) {
			System.out.println("Stack is too big");
		}
	}

	public String pop() {
		String item = items.get(items.size() - 1);
		items.remove(items.size() - 1);
		resultStr= resultStr.substring(resultStr.indexOf('\n')+1);
		/*
		 * int truncateIndex=resultStr.length();
		 * truncateIndex=resultStr.lastIndexOf('\n', truncateIndex - 2);
		 * resultStr=resultStr.substring(0, truncateIndex);
		 */
		return item;
	}

	public synchronized Package print() {
		Package result = new Package();		
		/*
		 * for (int i = items.size() - 1; i > 0; i--) { resultStr = resultStr +
		 * items.get(i); resultStr = resultStr + "\n"; }
		 */
		result.values = resultStr;
		result.digest = (resultStr.length() + items.size()) % 1007;
		return result;
	}

	public static class Package {
		String values;
		/** some numeric checksum */
		long digest;
	}

	/*
	 * public synchronized void push(String item) { //items.add(item);
	 * items.push(item);
	 * 
	 * if (items.size() > 100000) { System.out.println("Stack is too big"); }
	 * 
	 * }
	 * 
	 * public String pop() { return items.pop();
	 * 
	 * String item = items.get(items.size() - 1); items.remove(items.size() - 1);
	 * 
	 * //return item; }
	 * 
	 * public synchronized Package print() throws NoSuchAlgorithmException { Package
	 * result = new Package(); String resultStr = ""; for (int i = items.size()-1; i
	 * >= 0; i--) { resultStr = resultStr + items.get(i); } result.values =
	 * resultStr; System.out.println("resultStr:: "+resultStr); result.digest =
	 * toHexString(getSHA(resultStr)); return result; }
	 * 
	 * public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
	 * // Static getInstance method is called with hashing SHA MessageDigest md =
	 * MessageDigest.getInstance("SHA-256");
	 * 
	 * // digest() method called // to calculate message digest of an input // and
	 * return array of byte return
	 * md.digest(input.getBytes(StandardCharsets.UTF_8)); } public static String
	 * toHexString(byte[] hash) { // Convert byte array into signum representation
	 * BigInteger number = new BigInteger(1, hash);
	 * 
	 * // Convert message digest into hex value StringBuilder hexString = new
	 * StringBuilder(number.toString(16));
	 * 
	 * // Pad with leading zeros while (hexString.length() < 32) {
	 * hexString.insert(0, '0'); }
	 * 
	 * return hexString.toString(); }
	 * 
	 * public static class Package { String values; String digest; }
	 */

	public static void main(String args[]) throws NoSuchAlgorithmException {
		MyClass myClass = new MyClass();
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
