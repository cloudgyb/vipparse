package com.gyb.iqiyi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoData {
	private String name;
	private String description;
	private Integer tvId;
	private String vid;
	private String url;
	private Integer playCount;
	private Integer albumId;
	private Integer videoType;
	private Integer duration;
	private Integer upCount;
	private Integer downCount;
	private String imageUrl;
	private long issueTime;
	private VideoCategorie[] categories;
	private VideoCast cast;
	private float score;
	private String albumFocus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTvId() {
		return tvId;
	}
	public void setTvId(Integer tvId) {
		this.tvId = tvId;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getUpCount() {
		return upCount;
	}
	public void setUpCount(Integer upCount) {
		this.upCount = upCount;
	}
	public Integer getDownCount() {
		return downCount;
	}
	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(long issueTime) {
		this.issueTime = issueTime;
	}
	public VideoCategorie[] getCategories() {
		return categories;
	}
	public void setCategories(VideoCategorie[] categories) {
		this.categories = categories;
	}
	public VideoCast getCast() {
		return cast;
	}
	public void setCast(VideoCast cast) {
		this.cast = cast;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getAlbumFocus() {
		return albumFocus;
	}
	public void setAlbumFocus(String albumFocus) {
		this.albumFocus = albumFocus;
	}
	
	
	
}
