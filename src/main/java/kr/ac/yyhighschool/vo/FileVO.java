package kr.ac.yyhighschool.vo;

public class FileVO {
	private int file_id;
	private int post_id;
	private String user_nickname;
	private String file_name;
	private String fake_file_name;
	private long file_size;

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFake_file_name() {
		return fake_file_name;
	}

	public void setFake_file_name(String fake_file_name) {
		this.fake_file_name = fake_file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "FileVO [file_id=" + file_id + ", post_id=" + post_id + ", user_nickname=" + user_nickname
				+ ", file_name=" + file_name + ", fake_file_name=" + fake_file_name + ", file_size=" + file_size + "]";
	}

}
