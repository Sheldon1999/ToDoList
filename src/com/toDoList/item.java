package com.toDoList;

public class item {

	private int id;
	private String label;
	private String date;
	private String time;
	
	public item(int id, String label, String date, String time) {
		super();
		this.id = id;
		this.label = label;
		this.date = date;
		this.time = time;
	}
	
	public item(String label, String date, String time) {
		super();
		this.label = label;
		this.date = date;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
}
