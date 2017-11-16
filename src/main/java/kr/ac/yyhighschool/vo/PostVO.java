package kr.ac.yyhighschool.vo;

import java.sql.Timestamp;

public class PostVO {
	private int post_id;
	private String post_title;
	private String post_content;
	private Timestamp post_created;
	private int post_view;
	private String user_nickname;
	private int group_id;
	private int level;
	private int post_seq;

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
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

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Timestamp getPost_created() {
		return post_created;
	}

	public void setPost_created(Timestamp post_created) {
		this.post_created = post_created;
	}

	public int getPost_view() {
		return post_view;
	}

	public void setPost_view(int post_view) {
		this.post_view = post_view;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPost_seq() {
		return post_seq;
	}

	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}

	@Override
	public String toString() {
		return "PostVO [post_id=" + post_id + ", post_title=" + post_title + ", post_content=" + post_content
				+ ", post_created=" + post_created + ", post_view=" + post_view + ", user_nickname=" + user_nickname
				+ ", group_id=" + group_id + ", level=" + level + ", post_seq="
				+ post_seq + "]";
	}

}
