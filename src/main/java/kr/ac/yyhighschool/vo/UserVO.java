package kr.ac.yyhighschool.vo;

import java.sql.Timestamp;

public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_nickname;
	private String user_authority;
	private Timestamp user_created;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_authority() {
		return user_authority;
	}

	public void setUser_authority(String user_authority) {
		this.user_authority = user_authority;
	}

	public Timestamp getUser_created() {
		return user_created;
	}

	public void setUser_created(Timestamp user_created) {
		this.user_created = user_created;
	}

	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_nickname=" + user_nickname
				+ ", user_authority=" + user_authority + ", user_created=" + user_created + "]";
	}

}