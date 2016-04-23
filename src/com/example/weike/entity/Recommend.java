package com.example.weike.entity;

import java.io.Serializable;


public class Recommend implements Serializable {
		
	private String title;
	private String tag;
	private String works_id;
	private int terminal_type;
	private String url;
	private String update;
	private int rating;
	private String works_type;
	private String img_url;
	private String play_filter;
	private String is_yingyin;
	private String duration;
	private String teacher;
	private String status_day;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getWorks_id() {
		return works_id;
	}
	public void setWorks_id(String works_id) {
		this.works_id = works_id;
	}
	public int getTerminal_type() {
		return terminal_type;
	}
	public void setTerminal_type(int terminal_type) {
		this.terminal_type = terminal_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getWorks_type() {
		return works_type;
	}
	public void setWorks_type(String works_type) {
		this.works_type = works_type;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getPlay_filter() {
		return play_filter;
	}
	public void setPlay_filter(String play_filter) {
		this.play_filter = play_filter;
	}
	public String getIs_yingyin() {
		return is_yingyin;
	}
	public void setIs_yingyin(String is_yingyin) {
		this.is_yingyin = is_yingyin;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getStatus_day() {
		return status_day;
	}
	public void setStatus_day(String status_day) {
		this.status_day = status_day;
	}

}
