package com.spring.basic.model;

public class BirthVO {
	private String year;
	private String month;
	private String day;

	@Override
	public String toString() {
		return "BirthVO [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;

	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		int num = Integer.parseInt(month);
		if (num > 10)
			this.month = month;
		else
			this.month = "0" + month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		int num = Integer.parseInt(day);
		if (num > 10)
			this.day = day;
		else
			this.day = "0" + day;
	}

	public BirthVO(String year, String month, String day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

}
