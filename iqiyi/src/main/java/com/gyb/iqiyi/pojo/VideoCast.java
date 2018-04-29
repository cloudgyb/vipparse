package com.gyb.iqiyi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoCast {
	private Videodirector[] directors;
	private VideoActor[] mainActors;
	public Videodirector[] getDirectors() {
		return directors;
	}
	public void setDirectors(Videodirector[] directors) {
		this.directors = directors;
	}
	public VideoActor[] getMainActors() {
		return mainActors;
	}
	public void setMainActors(VideoActor[] mainActors) {
		this.mainActors = mainActors;
	}
	
	
	
}
