package com.elearning.entitites;

import java.util.Objects;

public class Feedback {

	private int userId;
	private String name;
	private String email;
	private int fId;
	private String feedback;
	
	

	public Feedback() {
		super();
	}

	public Feedback(int userId, String name, String email, int fId, String feedback) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.fId = fId;
		this.feedback = feedback;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fId, feedback, name, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(email, other.email) && fId == other.fId && Objects.equals(feedback, other.feedback)
				&& Objects.equals(name, other.name) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "Feedback [user_id=" + userId + ", name=" + name + ", email=" + email + ", f_id=" + fId + ", feedback="
				+ feedback + "]";
	}
	
}
