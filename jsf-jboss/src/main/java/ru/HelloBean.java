package ru;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class HelloBean {
	
	@Autowired
	private Test test;
	
	private String name;

	public String getName() {
		return name + test.getWord();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	
}