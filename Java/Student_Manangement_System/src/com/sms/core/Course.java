package com.sms.core;

import java.util.Comparator;

public enum Course  implements Comparable<Course>{

	CORE_JAVA(75, 10), DBT(65, 8), PYTHON(60, 10), MERN(70, 8), WEB_JAVA(75, 70), DEV_OPS(80, 15);

	private int min_marks, max_capacity;

	Course(int min_marks, int max_capacity) {

		this.min_marks = min_marks;
		this.max_capacity = max_capacity;
	}
	
	public String getPlan() {
		return this.name();
	}

	public int getMin_marks() {
		return min_marks;
	}

	public void setMin_marks(int min_marks) {
		this.min_marks = min_marks;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}
	
	@Override
	public String toString() {
		return name()+", Min marks :"+this.min_marks+" Max capacity :"+this.max_capacity;
	}

	



	
	
	
	
	
}
