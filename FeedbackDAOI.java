package com.elearning.daos;

import java.util.List;

import com.elearning.entitites.Feedback;

public interface FeedbackDAOI {
	public boolean saveFeedback(Feedback feedback);
	public List<Feedback> getAllFeedback();
}
