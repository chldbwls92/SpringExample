package com.chldbwls92.spring.ex.lifecycle;

public class Person {
	
	// 멤버변수
	// 이름, 나이
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Object class에 포함되어있는
	@Override
	public String toString() {
		return "이름 : " + name + " 나이 : " + age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

}
