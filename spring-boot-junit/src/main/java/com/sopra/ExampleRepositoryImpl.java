package com.sopra;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepositoryImpl {
	
    public String get() {
        return "Hello JUnit 5";
    }

	public String getById(int id) {
		String n = String.valueOf(id);
		return n;
	}

}