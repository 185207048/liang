package com.bluesky.entity;

public class Forum {
	private int user_id;
	private int forum_id;
	private String forum_icon;
	private String forum_name;
	private String forum_des;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_icon() {
		return forum_icon;
	}
	public void setForum_icon(String forum_icon) {
		this.forum_icon = forum_icon;
	}
	public String getForum_name() {
		return forum_name;
	}
	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}
	public String getForum_des() {
		return forum_des;
	}
	public void setForum_des(String forum_des) {
		this.forum_des = forum_des;
	}
	
	
}
