package com.job.search.pratice;
public class RemoveOddPositionNumbersFromString {
	
	public static void removeOddNumber(String s) {			    	   
		String resultString = "";
        boolean isOdd = false;
        int counter = 1;
        for (char c : s.toCharArray()) {
            int asci = (int) c;
            if (asci == 32) {
                if (counter % 2 == 0) {
                    isOdd = false;
                } else {
                    isOdd = true;
                }
                resultString += c;
                counter++;
            } else if (isOdd && 48 <= asci && asci >= 57) {
                resultString += c;
            }
            if (!isOdd) {
                resultString += c;
            }
        }
        System.out.println("Result :: " + resultString);	    
	}
	public static void main(String[] args) {
		String s = "11a 33b 12p ace 12";
		removeOddNumber(s);
		
		String str[] = { "11a", "33b", "12p", "ace", "12" };
		for (int i = 0; i < str.length; i++) {
			System.out.println("Beofre Replacing :: " + str[i]);
			if (i % 2 != 0) {
				str[i] = str[i].replaceAll("[0123456789]", "");
			}
		}
		for (int j = 0; j < str.length; j++) {
			System.out.println("Ater Replacing :: " + str[j]);
		}
	}
}
