package com.example.bean;

import java.util.Date;

public class Notes {
	private int id;
	private int noteBookId;
	private Date startDate;
	private Date endDate;
	private String description;
	private String notesName;
	public String getNotesName() {
		return notesName;
	}
	public void setNotesName(String notesName) {
		this.notesName = notesName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoteBookId() {
		return noteBookId;
	}
	public void setNoteBookId(int noteBookId) {
		this.noteBookId = noteBookId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
