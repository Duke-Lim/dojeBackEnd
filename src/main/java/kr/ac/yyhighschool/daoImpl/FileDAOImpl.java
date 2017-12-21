package kr.ac.yyhighschool.daoImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.vo.FileVO;

@Repository("fileDAO")
public class FileDAOImpl implements FileDAO {

	@Inject
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
	public FileVO getFile(int file_id) {
		return sqlSession.selectOne("getFile", file_id);
	}

}
