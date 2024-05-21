package com.kike.classicmodels.scanner;

import java.util.Scanner;

public class MiScanner {
	private static Scanner sc;
	public static Scanner getInstance() {
		if (sc == null) {
			sc = new Scanner(System.in);
			
		}
		return sc;
		
	}

}
