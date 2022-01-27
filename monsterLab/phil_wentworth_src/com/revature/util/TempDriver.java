package com.revature.util;

public class TempDriver {

	public static void main(String[] args) {
		List<String> myStringList = new LinkedList<>();
		myStringList.add("Hello");
		myStringList.add("There");
		myStringList.add("Ahhh");
		myStringList.add("General");
		myStringList.add("Kenobi");
		
		System.out.println(myStringList.contains("Hello"));
		
		System.out.println(myStringList.get(2));
	}
}
