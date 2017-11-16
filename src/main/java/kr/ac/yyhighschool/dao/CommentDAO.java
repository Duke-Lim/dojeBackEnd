package kr.ac.yyhighschool.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.CommentVO;

public interface CommentDAO {
	public List<CommentVO> commentList(int id);
	public int writeComment(HashMap<String, Object> reqMap);
	public int modifyComment(HashMap<String, Object> reqMap);
}
