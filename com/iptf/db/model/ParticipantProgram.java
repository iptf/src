package com.iptf.db.model;

public class ParticipantProgram {
	private int participantId;
	private int programId;
	private String trackUrl;
	private int year;
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getTrackUrl() {
		return trackUrl;
	}
	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


}
