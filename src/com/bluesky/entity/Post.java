package com.bluesky.entity;

public class Post {
	private int user_id;
	private int post_id;
	private int post_type;
	private String post_title;
	private String post_img;
	private String post_text;
	private int is_top;
	private int is_official;
	private int post_comment_num;
	private int post_like_num;
	private String post_create_time;
	private int forum_id;
	private String post_tag;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_img() {
		return post_img;
	}
	public void setPost_img(String post_img) {
		this.post_img = post_img;
	}
	public String getPost_text() {
		return post_text;
	}
	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}
	public int getIs_top() {
		return is_top;
	}
	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}
	public int getIs_official() {
		return is_official;
	}
	public void setIs_official(int is_official) {
		this.is_official = is_official;
	}
	public int getPost_comment_num() {
		return post_comment_num;
	}
	public void setPost_comment_num(int post_comment_num) {
		this.post_comment_num = post_comment_num;
	}
	public int getPost_like_num() {
		return post_like_num;
	}
	public void setPost_like_num(int post_like_num) {
		this.post_like_num = post_like_num;
	}
	public String getPost_create_time() {
		return post_create_time;
	}
	public void setPost_create_time(String post_create_time) {
		this.post_create_time = post_create_time;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public int getPost_type() {
		return post_type;
	}
	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}
	public String getPost_tag() {
		return post_tag;
	}
	public void setPost_tag(String post_tag) {
		this.post_tag = post_tag;
	}
	
	
}
