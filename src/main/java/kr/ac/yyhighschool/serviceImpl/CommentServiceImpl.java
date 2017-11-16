package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.CommentDAO;
import kr.ac.yyhighschool.service.CommentService;
import kr.ac.yyhighschool.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public List<CommentVO> commentList(int id) {
		return commentDAO.commentList(id);
	}

	@Override
	public int writeComment(HashMap<String, Object> reqMap) {
		return commentDAO.writeComment(reqMap);
	}

	@Override
	public int modifyComment(HashMap<String, Object> reqMap) {
		return commentDAO.modifyComment(reqMap);
	}

}
