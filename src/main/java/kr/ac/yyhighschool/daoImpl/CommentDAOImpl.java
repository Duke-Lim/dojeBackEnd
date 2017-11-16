package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.CommentDAO;
import kr.ac.yyhighschool.vo.CommentVO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommentVO> commentList(int id) {
		return sqlSession.selectList("commentList", id);
	}

	@Override
	public int writeComment(HashMap<String, Object> reqMap) {
		return sqlSession.insert("writeComment", reqMap);
	}

	@Override
	public int modifyComment(HashMap<String, Object> reqMap) {
		return sqlSession.update("modifyComment", reqMap);
	}

}
