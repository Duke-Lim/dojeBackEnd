package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.UserDAO;
import kr.ac.yyhighschool.vo.UserVO;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<UserVO> getUserList() {
		return sqlSession.selectList("getUserList");
	}

	@Override
	public UserVO getUser(String id) {
		return sqlSession.selectOne("getUser", id);
	}

	@Override
	public int joinUser(HashMap<String, Object> reqMap) {
		return sqlSession.insert("joinUser", reqMap);
	}

	@Override
	public int modifyUser(HashMap<String, Object> reqMap) {
		return sqlSession.update("modifyUser", reqMap);
	}

}
