package com.iptf.db.model;

public class Program {
	private int programId;
	private int categoryId;
	private String programName;
	private String description;
	private String groupFlag;
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int category_id) {
		this.categoryId = category_id;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGroupFlag() {
		return groupFlag;
	}
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}

}
