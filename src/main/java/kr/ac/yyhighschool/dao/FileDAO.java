package kr.ac.yyhighschool.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.ac.yyhighschool.vo.FileVO;

@Transactional
public interface FileDAO {
	public int fileSave(HashMap<String, Object> reqMap);
	public List<FileVO> fileList(int post_id);
	public FileVO getFile(int file_id);
}
