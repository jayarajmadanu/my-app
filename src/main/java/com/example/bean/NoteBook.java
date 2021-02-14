package com.example.bean;

import java.util.ArrayList;

public class NoteBook {
	private String bookName;
	private int bookId;
	private int userId;
	private ArrayList<Notes> note;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ArrayList<Notes> getNote() {
		return note;
	}
	public void setNote(ArrayList<Notes> note) {
		this.note = note;
	}
	
}
