package org.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
	
	public static boolean isPalindrom(int num ) {
		if (!isValid(num)) 
			return false;
		
		int div = 1;
		while(num/div >= 10) {
			div *= 10;
		}
		
		while (num >0 ) {
			int first = num/div;
			int last = num%10;
			if (first != last)
				return false;
			// first move right 1 step
			num -= num/div * div;
			// last move left 1 step
			num/= 10;
			div/=100;
		}
		return true;
	}
	
	private static boolean isValid(int num) {
		return (num >= 0);
	}

	// test cases
	public static void main(String args[]) {
		List<Boolean> results = new ArrayList<Boolean>();
		
		results.add(isPalindrom(11));
		results.add(isPalindrom(0));
		results.add(isPalindrom(1));
		results.add(isPalindrom(9876789));
		results.add(isPalindrom(1234321));
		results.add(isPalindrom(12345));
		results.add(isPalindrom(987789));
		
		System.out.print(results);
	}
	
	
}
