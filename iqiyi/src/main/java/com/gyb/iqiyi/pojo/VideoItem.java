package com.gyb.iqiyi.pojo;
/**
 * 视频列表项
 * @author GengYB
 *
 */
public class VideoItem {
	private String vid;
	private String name;
	private String href;
	private String img;
	private String score_unit;
	private String score_decimal;
	private String desc;
	
	public VideoItem() {
	}
	public VideoItem(String vid, String name, String href, String img, String score_unit, String score_decimal,
			String desc) {
		super();
		this.vid = vid;
		this.name = name;
		this.href = href;
		this.img = img;
		this.score_unit = score_unit;
		this.score_decimal = score_decimal;
		this.desc = desc;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getScore_unit() {
		return score_unit;
	}
	public void setScore_unit(String score_unit) {
		this.score_unit = score_unit;
	}
	public String getScore_decimal() {
		return score_decimal;
	}
	public void setScore_decimal(String score_decimal) {
		this.score_decimal = score_decimal;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "VideoItem [vid=" + vid + ", name=" + name + ", href=" + href + ", img=" + img + ", score_unit="
				+ score_unit + ", score_decimal=" + score_decimal + ", desc=" + desc + "]";
	}
	
	
}
