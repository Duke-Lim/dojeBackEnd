package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

<<<<<<< HEAD
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
=======
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.vo.FileVO;

@Repository("fileDAO")
public class FileDAOImpl implements FileDAO {

<<<<<<< HEAD
	@Inject
=======
	@Autowired
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
	private SqlSession sqlSession;
	
	@Override
	public int fileSave(HashMap<String, Object> reqMap) {
		return sqlSession.insert("fileSave", reqMap);
	}

	@Override
	public List<FileVO> fileList(int post_id) {
		return sqlSession.selectList("fileList", post_id);
	}

	@Override
<<<<<<< HEAD
	public FileVO getFile(int file_id) {
		return sqlSession.selectOne("getFile", file_id);
=======
	public FileVO getFile(String name) {
		return sqlSession.selectOne("getFile", name);
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
	}

}
