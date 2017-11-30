package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.vo.FileVO;

@Repository("fileDAO")
public class FileDAOImpl implements FileDAO {

	@Autowired
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
	public FileVO getFile(String name) {
		return sqlSession.selectOne("getFile", name);
	}

}
