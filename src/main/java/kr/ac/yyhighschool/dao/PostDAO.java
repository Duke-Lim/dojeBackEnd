package kr.ac.yyhighschool.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.PostVO;

public interface PostDAO {
	public List<PostVO> getPostList();
	public PostVO getPost(int id);
	public int writePost(HashMap<String, Object> reqMap);
	public int seqCount(HashMap<String, Object> reqMap);
	public int modifyPost(HashMap<String, Object> reqMap);
	public int viewCount(int seq);
}
