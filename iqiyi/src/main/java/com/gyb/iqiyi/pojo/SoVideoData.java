package com.gyb.iqiyi.pojo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SoVideoData {
	private Long aid;
	private String name;
	private String link;
	private String picture_url;
	private int cid;
	private String cname;
	private String[] director;
	private String[] main_actor;
	private int is_purchase;
	private String region;
	private int year;
	private int duration;
	private long vid;
	private String[] link_address;
	private String normalize_query;
	private float final_score;
	
	public SoVideoData() {
	}
	public SoVideoData(Long aid, String name, String link, String picture_url, int cid, String cname, String[] director,
			String[] main_actor, int is_purchase, String region, int year, int duration, long vid,
			String[] link_address, String normalize_query, float final_score) {
		super();
		this.aid = aid;
		this.name = name;
		this.link = link;
		this.picture_url = picture_url;
		this.cid = cid;
		this.cname = cname;
		this.director = director;
		this.main_actor = main_actor;
		this.is_purchase = is_purchase;
		this.region = region;
		this.year = year;
		this.duration = duration;
		this.vid = vid;
		this.link_address = link_address;
		this.normalize_query = normalize_query;
		this.final_score = final_score;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String[] getDirector() {
		return director;
	}
	public void setDirector(String[] director) {
		this.director = director;
	}
	public String[] getMain_actor() {
		return main_actor;
	}
	public void setMain_actor(String[] main_actor) {
		this.main_actor = main_actor;
	}
	public int getIs_purchase() {
		return is_purchase;
	}
	public void setIs_purchase(int is_purchase) {
		this.is_purchase = is_purchase;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public String[] getLink_address() {
		return link_address;
	}
	public void setLink_address(String[] link_address) {
		this.link_address = link_address;
	}
	public String getNormalize_query() {
		return normalize_query;
	}
	public void setNormalize_query(String normalize_query) {
		this.normalize_query = normalize_query;
	}
	public float getFinal_score() {
		return final_score;
	}
	public void setFinal_score(float final_score) {
		this.final_score = final_score;
	}
	@Override
	public String toString() {
		return "SoVideoData [aid=" + aid + ", name=" + name + ", link=" + link + ", picture_url=" + picture_url
				+ ", cid=" + cid + ", cname=" + cname + ", director=" + Arrays.toString(director) + ", main_actor="
				+ Arrays.toString(main_actor) + ", is_purchase=" + is_purchase + ", region=" + region + ", year=" + year
				+ ", duration=" + duration + ", vid=" + vid + ", link_address=" + Arrays.toString(link_address)
				+ ", normalize_query=" + normalize_query + ", final_score=" + final_score + "]";
	}
	
	
}
