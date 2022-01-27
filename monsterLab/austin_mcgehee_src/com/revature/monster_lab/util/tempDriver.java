package com.revature.monster_lab.util;

public class tempDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> myStringList = new LinkedList<>();
		
		myStringList.add("Hello");
		myStringList.add("My");
		myStringList.add("Name");
		myStringList.add("Is");
		myStringList.add("Austin");
		
		System.out.println(myStringList.contains("Is"));
		
		myStringList.remove("Is");
		
		System.out.println(myStringList.contains("Is"));
		

	}

}
