package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.PostDAO;
import kr.ac.yyhighschool.vo.PostVO;

@Repository(value = "postDAO")
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PostVO> getPostList() {
		return sqlSession.selectList("getPostList");
	}

	@Override
	public PostVO getPost(int id) {
		return sqlSession.selectOne("getPost", id);
	}

	@Override
	public int writePost(HashMap<String, Object> reqMap) {
		return sqlSession.insert("writePost", reqMap);
	}

	@Override
	public int seqCount(HashMap<String, Object> reqMap) {
		return sqlSession.update("seqCount", reqMap);
	}

	@Override
	public int modifyPost(HashMap<String, Object> reqMap) {
		return sqlSession.update("modifyPost", reqMap);
	}

	@Override
	public int viewCount(int seq) {
		return sqlSession.update("viewCount", seq);
	}
	
}
