package kr.ac.yyhighschool.vo;

import java.sql.Timestamp;

public class CommentVO {
	private String com_id;
	private String user_nickname;
	private int post_id;
	private String com_content;
	private Timestamp com_created;
	private int group_id;
	private int level;
	private int com_seq;

	public String getCom_id() {
		return com_id;
	}

	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public int getpost_id() {
		return post_id;
	}

	public void setpost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Timestamp getCom_created() {
		return com_created;
	}

	public void setCom_created(Timestamp com_created) {
		this.com_created = com_created;
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

	public int getCom_seq() {
		return com_seq;
	}

	public void setCom_seq(int com_seq) {
		this.com_seq = com_seq;
	}

	@Override
	public String toString() {
		return "CommentVO [com_id=" + com_id + ", user_nickname=" + user_nickname + ", post_id=" + post_id + ", com_content="
				+ com_content + ", com_created=" + com_created + ", group_id=" + group_id + ", level=" + level
				+ ", com_seq=" + com_seq + "]";
	}

}
